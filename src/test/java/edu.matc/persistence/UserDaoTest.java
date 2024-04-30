package edu.matc.persistence;

import edu.matc.entity.Review;
import edu.matc.entity.User;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {
    /**
     * The Generic dao.
     */
    GenericDao genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        genericDao = new GenericDao(User.class);
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Cat", retrievedUser.getFirstName());
    }


    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        User userToUpdate = (User)genericDao.getById(1);
        userToUpdate.setLastName("Smith");
        genericDao.update(userToUpdate);

        //retrieve the user and check that the name change worked
        User actualUser = (User)genericDao.getById(1);
        assertEquals(userToUpdate, actualUser);
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        User userToInsert = new User("Gray", "Squirrel", "gSquirrel", "gsquirrell@email.com", 53718);
        int insertedUserId = genericDao.insert(userToInsert);
        assertNotEquals(0, insertedUserId);
        User insertedUser = (User)genericDao.getById(insertedUserId);
        assertEquals(userToInsert, insertedUser);

    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }


    /**
     * Delete with reviews success.
     */
    @Test
    void deleteWithReviewsSuccess() {

        //get the user we want to delete that has 2 orders associated
        User userToBeDeleted = (User)genericDao.getById(1);
        List<Review> reviews = userToBeDeleted.getReviews();

        //get the associated order numbers
        int reviewNumber1 = reviews.get(0).getId();
        int reviewNumber2 = reviews.get(1).getId();

        //delete user
        genericDao.delete(userToBeDeleted);

        //verify that the user was deleted
        assertNull(genericDao.getById(1));

        //verify that the orders were also deleted
        GenericDao reviewDao = new GenericDao(Review.class);
        assertNull(reviewDao.getById(reviewNumber1));
        assertNull(reviewDao.getById(reviewNumber2));
    }


    /**
     * Gets all.
     */
    @Test
    void getAll() {
        List<User> users = genericDao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {

        List<User> users = genericDao.findByPropertyEqual("firstName", "Cat");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        List<User> users = genericDao.getByPropertyLike("lastName", "c");
        assertEquals(2, users.size());
    }

    @Test
    void getPropertyLikeUnique() {
        User user = (User) genericDao.findByPropertyEqualUnique("userName", "catRat");
        assertEquals(genericDao.getById(1), user);
    }
}
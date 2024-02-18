package edu.matc.persistence;

import edu.matc.entity.Review;
import edu.matc.entity.User;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        userDao = new UserDao();
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Cat", retrievedUser.getFirstName());
    }



    @Test
    void updateSuccess() {
        User userToUpdate = userDao.getById(1);
        userToUpdate.setLastName("Smith");
        userDao.update(userToUpdate);

        //retrieve the user and check that the name change worked
        User actualUser = userDao.getById(1);
        assertEquals("Smith", actualUser.getLastName());
    }

    @Test
    void insertSuccess() {
        User userToInsert = new User("Gray", "Squirrel", "gSquirrel", "gsquirrell@email.com", 53718);
        int insertedUserId = userDao.insert(userToInsert);
        assertNotEquals(0, insertedUserId);
        User insertedUser = userDao.getById(insertedUserId);
        assertEquals("Gray", insertedUser.getFirstName());

    }

    @Test
    void deleteSuccess() {
        userDao.delete(userDao.getById(3));
        assertNull(userDao.getById(3));
    }


   /** @Test
    void deleteWithOrdersSuccess() {

        //get the user we want to delete that has 2 orders associated
        User userToBeDeleted = userDao.getById(3);
        List<Review> orders = userToBeDeleted.getReviews();

        //get the associated order numbers
        int orderNumber1 = orders.get(0).getId();
        int orderNumber2 = orders.get(1).getId();

        //delete user
        userDao.delete(userToBeDeleted);

        //verify that the user was deleted
        assertNull(userDao.getById(3));

        //verify that the orders were also deleted
        ReviewDao reviewDao = new ReviewDao();
        assertNull(reviewDao.getById(orderNumber1));
        assertNull(reviewDao.getById(orderNumber2));
    }
    **/

    @Test
    void getAll() {
        List<User> users = userDao.getAll();
        assertEquals(6, users.size());
    }

    @Test
    void getByPropertyEqual() {
        List<User> users = userDao.getByPropertyEqual("firstName", "Cat");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        List<User> users = userDao.getByPropertyLike("lastName", "c");
        assertEquals(2, users.size());
    }
}
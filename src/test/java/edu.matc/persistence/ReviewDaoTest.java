package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.Review;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Review dao test.
 */
class ReviewDaoTest {

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
        genericDao = new GenericDao(Review.class);
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        List<Review> reviews = genericDao.getAll();
        assertEquals(4, reviews.size());
    }
    /**
     * Gets review by id.
     */
    @Test
    void getById() {
        Review retrievedReview = (Review)genericDao.getById(7);
        assertNotNull(retrievedReview);
        assertEquals(retrievedReview, genericDao.getById(7));
    }

    /**
     * Update review.
     */
    @Test
    void update() {
        Review reviewToUpdate = (Review)genericDao.getById(8);
        reviewToUpdate.setCampsite("89");
        genericDao.update(reviewToUpdate);
        Review retrievedReview = (Review)genericDao.getById(8);
        assertEquals(reviewToUpdate,retrievedReview);

    }

    /**
     * Insert Review
     */
    @Test
    void insert() {

        UserDao userDao = new UserDao();
        User user = userDao.getById(3);

        Review reviewToInsert= new Review("Mirror Lake", "CliffWood", "89", "A",
                    "B", "C", "D", "F", "cool", user);
        int insertedReviewId = genericDao.insert(reviewToInsert);
        assertNotEquals(0, insertedReviewId);
        Review insertedReview = (Review)genericDao.getById((insertedReviewId));
        assertEquals(reviewToInsert, insertedReview);

        assertEquals(user.getFirstName(), insertedReview.getUser().getFirstName());

    }


    /**
     * Delete review.
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(7));
        assertNull(genericDao.getById(7));
    }




    /**
     * Gets by property equal.
     */
    @Test
    void findByPropertyEqual() {
        List<Review> reviews = genericDao.findByPropertyEqual("shade", "A");
        assertEquals(1, reviews.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void ByPropertyLike() {
        List<Review> reviews = genericDao.getByPropertyLike("reviewText", "nice");
        assertEquals(2, reviews.size());
    }
}
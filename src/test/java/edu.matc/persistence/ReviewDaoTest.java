package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.Review;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewDaoTest {

    ReviewDao reviewDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        reviewDao = new ReviewDao();
    }


    @Test
    void getById() {
        Review retrievedReview = reviewDao.getById(3);
        assertNotNull(retrievedReview);
        assertEquals("Devils Lake", retrievedReview.getPark());
    }

    @Test
    void update() {
        Review reviewToUpdate = reviewDao.getById(3);
        reviewToUpdate.setCampsite("89");
        reviewDao.update(reviewToUpdate);
        Review actualReview = reviewDao.getById(3);
        assertEquals("89", actualReview.getCampsite());

    }

    @Test
    void insert() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(3);

        Review reviewToInsert= new Review("Mirror Lake", "CliffWood", "89", "A",
                    "B", "C", "D", "F", "cool", user);
        int insertedReviewId = reviewDao.insert(reviewToInsert);
        assertNotEquals(0, insertedReviewId);
        Review insertedReview = reviewDao.getById((insertedReviewId));
        assertEquals("Mirror Lake", insertedReview.getPark());

        assertEquals("DJ", insertedReview.getUser().getFirstName());

    }


    @Test
    void delete() {
        reviewDao.delete(reviewDao.getById(4));
        assertNull(reviewDao.getById(4));
    }


    @Test
    void getAll() {
        List<Review> reviews = reviewDao.getAll();
        assertEquals(4, reviews.size());
    }

    @Test
    void getByPropertyEqual() {
        List<Review> reviews = reviewDao.getByPropertyEqual("shade", "A");
        assertEquals(1, reviews.size());
    }

    @Test
    void getByPropertyLike() {
        List<Review> reviews = reviewDao.getByPropertyLike("reviewText", "nice");
        assertEquals(2, reviews.size());
    }
}
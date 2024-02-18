package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.Review;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        Review reviewToInsert= new Review("Mirror Lake", "CliffWood", "89", "A", "B", "C", "D", "F", "cool", user);
        int insertedReviewId = reviewDao.insert(reviewToInsert);
        assertNotEquals(0, insertedReviewId);
        Review insertedReview = reviewDao.getById((insertedReviewId));
        assertEquals("Mirror Lake", insertedReview.getPark());

        //todo check this test against orderdao2/16
    }


    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }
}
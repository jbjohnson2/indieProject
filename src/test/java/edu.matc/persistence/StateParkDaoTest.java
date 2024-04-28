package edu.matc.persistence;

import edu.matc.entity.StatePark;

import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StateParkDaoTest {

    GenericDao genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        genericDao = new GenericDao(StatePark.class);
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        StatePark retrievedStatePark = (StatePark)genericDao.getById(1);
        assertNotNull(retrievedStatePark);
        assertEquals("Amnicon Falls", retrievedStatePark.getParkName());
    }


    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        StatePark stateParkToUpdate = (StatePark)genericDao.getById(1);
        stateParkToUpdate.setParkName("New Park Name");
        genericDao.update(stateParkToUpdate);

        //retrieve the statePark and check that the name change worked
        StatePark actualStatePark = (StatePark)genericDao.getById(1);
        assertEquals(stateParkToUpdate, actualStatePark);
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        StatePark stateParkToInsert = new StatePark("New Park", 53718);
        int insertedStateParkId = genericDao.insert(stateParkToInsert);
        assertNotEquals(0, insertedStateParkId);
        StatePark insertedStatePark = (StatePark)genericDao.getById(insertedStateParkId);
        assertEquals(stateParkToInsert, insertedStatePark);

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
     * Gets all.
     */
    @Test
    void getAll() {
        List<StatePark> stateParks = genericDao.getAll();
        assertEquals(36, stateParks.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {

        List<StatePark> stateParks = genericDao.findByPropertyEqual("parkName", "Willow River");
        assertEquals(1, stateParks.size());
        assertEquals(34, stateParks.get(0).getId());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        List<StatePark> stateParks = genericDao.getByPropertyLike("parkName", "Falls");
        assertEquals(2, stateParks.size());
    }
}



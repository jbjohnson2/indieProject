package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.com.zipcodeapi.DistanceResults;
import edu.matc.entity.StatePark;

import javax.swing.plaf.nimbus.State;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Zipcode api dao.
 */
public class ZipcodeApiDao {

    /**
     * The Generic dao.
     */
    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets distance.
     *
     * @param userZipcode the user zipcode
     * @param parkZipcode the park zipcode
     * @return the distance
     */
    public double getDistance(int userZipcode, int parkZipcode) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://www.zipcodeapi.com/rest/7anltjvxKmKglJVffir5sGG1htZc2x8Dl9f9BoctCW3253ff0F5jme5x9aDV0PiG/distance.json/" + userZipcode + "/" + parkZipcode + "/mile");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        double distance = 0;
        DistanceResults distanceResults = null;
        try {
            distanceResults = mapper.readValue(response, DistanceResults.class);
        } catch (JsonProcessingException e) {
            logger.error(e);
        }
        distance = (double) distanceResults.getDistance();
        return distance;
    }

}


package edu.matc.persistence;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.com.zipcodeapi.DistanceResults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Test service client.
 */
public class TestServiceClient {
    /**
     * The Zipcode api dao.
     */
    ZipcodeApiDao zipcodeApiDao = new ZipcodeApiDao();
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Test zipcodeapi json.
     *
     * @throws Exception the exception
     */
    @Test
    public void testZipcodeapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://www.zipcodeapi.com/rest/7anltjvxKmKglJVffir5sGG1htZc2x8Dl9f9BoctCW3253ff0F5jme5x9aDV0PiG/distance.json/53718/53038/mile");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        DistanceResults distanceResults = mapper.readValue(response, DistanceResults.class);
        double expectedDistance = 24.756;
        assertEquals(expectedDistance, distanceResults.getDistance());

    }

    /**
     * Test zipcodeapi passing variables.
     *
     * @throws Exception the exception
     */

    @Test
    public void testZipcodeapiPassingVariables() throws Exception {
        double distance = zipcodeApiDao.getDistance(53718, 53038);
        assertEquals(24.756, distance);
    }

}

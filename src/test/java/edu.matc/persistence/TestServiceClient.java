package edu.matc.persistence;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestServiceClient {
    @Test
    public void testZipcodeapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://www.zipcodeapi.com/rest/7anltjvxKmKglJVffir5sGG1htZc2x8Dl9f9BoctCW3253ff0F5jme5x9aDV0PiG/distance.json/53718/53038/mile");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("{\"distance\":24.756}", response);
    }
}

package shevchik.webservices;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.MediaType;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class DistanceWebServiceIT {

    @Test
    public void testPutDistance(){
        String input = "{\"cityA\":\"Moscow\",\"cityB\":\"Kiev\",\"distance\":1000}";
        assertEquals(204,putDistance(input).getClientResponseStatus().getStatusCode());
    }

    @Test
    public void testGetDistance(){
        String input = "{\"cityA\":\"Moscow\",\"cityB\":\"Kiev\",\"distance\":null}";
        String expected = "{\"cityA\":\"Moscow\",\"cityB\":\"Kiev\",\"distance\":1000}";
        assertEquals(expected,getDistance(input).getEntity(String.class));

    }

    /**
     * Gets JSON-formatted Distance object and puts it into MongoDB
     * @param jsonString
     * @return
     */
    public ClientResponse putDistance(String jsonString){
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/webservice/rest/json/distances/put");
        return webResource.type("application/json").post(ClientResponse.class, jsonString );
    }


    /**
     * Gets JSON-formatted Distance object with distance null
     * and returns JSON-formatted Distance with distance if an object exists in MongoDB
     *
     * Example:
     * { 'cityA' : 'Moscow', 'cityB' : 'Kiev', 'distance' : null}
     * If an object can be found in MongoDB it gets returned with set distance field
     * { 'cityA' : 'Moscow', 'cityB' : 'Kiev', 'distance' : 1000}
     * @param jsonString
     * @return
     */
    public ClientResponse getDistance(String jsonString){
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/webservice/rest/json/distances/get");
        return webResource.accept(MediaType.APPLICATION_JSON).type("application/json").post(ClientResponse.class, jsonString );
    }
}

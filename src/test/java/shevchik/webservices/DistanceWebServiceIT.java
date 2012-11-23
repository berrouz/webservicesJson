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
@ContextConfiguration(locations={"classpath:/META-INF/spring/applicationContext.xml"})
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

    public ClientResponse putDistance(String jsonString){
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/webservice/rest/json/distances/put");
        return webResource.type("application/json").post(ClientResponse.class, jsonString );
    }

    public ClientResponse getDistance(String jsonString){
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/webservice/rest/json/distances/get");
        return webResource.accept(MediaType.APPLICATION_JSON).type("application/json").post(ClientResponse.class, jsonString );
    }
}

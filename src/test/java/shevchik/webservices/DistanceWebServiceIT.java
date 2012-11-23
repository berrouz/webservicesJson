package shevchik.webservices;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/applicationContext.xml"})
public class DistanceWebServiceIT {

    @Test
    public void testPutDistance(){
        String input = "{\"cityA\":\"Moscow\", \"cityB\":\"Kiev\", \"distance\":\"1100\"}";
        assertEquals(200,putDistance(input).getClientResponseStatus().getStatusCode());
    }

    public ClientResponse putDistance(String jsonString){
        Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8080/webservice/rest/json/distances/post");
        return webResource.accept("application/json").post(ClientResponse.class, jsonString );
    }

    public String getDistance(String jsonString){
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/webservice/rest/json/distances/get");
        ClientResponse clientResponse = webResource.accept("application/json").post(ClientResponse.class, jsonString );
        return clientResponse.getEntity(String.class);
    }
}

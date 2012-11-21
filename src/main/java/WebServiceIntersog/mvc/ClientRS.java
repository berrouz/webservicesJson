package WebServiceIntersog.mvc;

import WebServiceIntersog.domain.Distance;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.impl.provider.entity.FormProvider;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class ClientRS {
    public static void main(String[] args) throws IOException {

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8090/webservice/rest/json/distances/put");
        String input  = "{\"cityA\":\"Moscow\",\"cityB\":\"Kiev\",\"distance\":\"1010\"}";
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

        System.out.println("Output from Server .... \n");
        System.out.println(response);

        WebResource webResource1 = client.resource("http://localhost:8090/webservice/rest/json/distances/get");
        String input1 = "{\"cityA\":\"Moscow\",\"cityB\":\"Kiev\",\"distance\": null}";
        //WebResource.Builder builder = webResource1.accept(MediaType.APPLICATION_JSON);
        //ClientResponse response2 = builder.type("appliation/json").post(ClientResponse.class, input1);
        //Distance distance = response2.getEntity(Distance.class);
        ClientResponse response1 = webResource1
                .type("application/json").post(ClientResponse.class, input1);
        //Distance  distance =  response1.getEntity(Distance.class);
        System.out.println(response1.getLength());


    }
}

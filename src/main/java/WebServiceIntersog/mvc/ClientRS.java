package WebServiceIntersog.mvc;

import WebServiceIntersog.domain.Distance;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class ClientRS {
    public static void main(String[] args) throws IOException {

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8090/webservice/rest/json/distances/put");
        String input  = "{\"cityA\":\"Berlin\",\"cityB\":\"Donezk\",\"distance\":\"2900\"}";
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

       /* System.out.println("Output from Server .... \n");
        System.out.println(response);
        Client client1 = Client.create();

        WebResource webResource1 = client1.resource("http://localhost:8090/webservice/rest/json/distances/get");
        String input1 = "{\"cityA\":\"Moscow\",\"cityB\":\"Paris\",\"distance\": null}";
        ClientResponse response1 = webResource1.accept(MediaType.APPLICATION_JSON).type("application/json")
                .post(ClientResponse.class, input1);
        System.out.println(response1.getEntity(String.class));*/


    }
}

package WebServiceIntersog.webservices;

import WebServiceIntersog.domain.Distance;
import WebServiceIntersog.services.DistanceServiceImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Distance Web Service JSON
 */
@Component
@Path("/json/distances")
public class DistanceWebService {

    @Inject
    private DistanceServiceImpl distanceService;

    @POST
    @Path("/get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Distance getDistance(Distance distance){
        System.out.println(distance.toString());
        System.out.println(distanceService.getDistance(distance));
        return distanceService.getDistance(distance);
    }

    @POST
    @Path("/put")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putDistance(Distance distance){
        distanceService.putDistance(distance);
    }

    public DistanceServiceImpl getDistanceService() {
        return distanceService;
    }

    public void setDistanceService(DistanceServiceImpl distanceService) {
        this.distanceService = distanceService;
    }
}

package shevchik.webservices;

import shevchik.domain.Distance;
import shevchik.services.DistanceServiceImpl;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Distance Web Service JSON has 2 methods
 * /rest/json/distances/put saves Distance
 * /rest/json/distances/get gets Distance if it exists in MongoDB
 * Both methods use POST methods in order to send JSON object.
 * only /get method returns JSON-formatted response
 * @author shevchik
 * @version 0.0.1
 */
@Component
@Path("/json/distances")
public class DistanceWebService {

    @Inject
    private DistanceServiceImpl distanceService;

    /**
     * Consumes JSON-formatted Distance with distance as null
     * and produces JSON-formatted Distance with set distance if available in MongoDB
     * @param distance
     * @return
     */
    @POST
    @Path("/get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Distance getDistance(Distance distance){
        return distanceService.getDistance(distance);
    }

    /**
     * Consumes JSON-formatted Distance with set distance,
     * it gets saved if unique. Uniqueness is guaranteed by Composite Index in DB(cityA and cityB)
     * @param distance
     */
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

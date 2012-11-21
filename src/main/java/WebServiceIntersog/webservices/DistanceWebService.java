package WebServiceIntersog.webservices;

import WebServiceIntersog.domain.Distance;
import WebServiceIntersog.services.DistanceServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Distance Web Service JSON
 */

@Controller
@RequestMapping("/distances")
public class DistanceWebService {

    @Inject
    private DistanceServiceImpl distanceService;


    public Response putDistance(Distance distance){
        distanceService.putDistance(distance);
        return Response.status(200).build();
    }

    public Distance getDistance(Distance distance){
        return distanceService.getDistance(distance);
    }
}

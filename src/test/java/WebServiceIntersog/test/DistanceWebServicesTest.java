package WebServiceIntersog.test;

import WebServiceIntersog.domain.Distance;
import WebServiceIntersog.services.DistanceServiceImpl;
import WebServiceIntersog.webservices.DistanceWebService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.math.BigDecimal;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/applicationContext.xml"})
public class DistanceWebServicesTest
{
    @Inject
    private DistanceServiceImpl distanceService;

    @Test
    public void testPutDistance(){
        Distance distance = new Distance();
        distance.setCityA("Tokio");
        distance.setCityB("Berlin");
        distance.setDistance(7890);
        distanceService.putDistance(distance);
        assertEquals(distance, distanceService.getDistance(distance));

    }

}

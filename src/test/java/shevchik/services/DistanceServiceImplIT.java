package shevchik.services;

import shevchik.domain.Distance;
import shevchik.services.DistanceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/applicationContext.xml"})
public class DistanceServiceImplIT
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

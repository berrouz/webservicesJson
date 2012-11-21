package WebServiceIntersog.test;

import WebServiceIntersog.webservices.DistanceWebService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class DistanceWebServicesTest
{
    @Inject
    private DistanceWebService distanceWebService;

    @Test
    public void testPutDistance(){

        //distanceWebService.putDistance()
    }

}

package WebServiceIntersog.services;

import WebServiceIntersog.domain.Distance;
import WebServiceIntersog.persistence.MongoConfig;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Distance Service Implementation
 */
@Service
public class DistanceServiceImpl implements DistanceService {

    @Inject
    private MongoOperations mongoOperations;

    @Override
    public boolean putDistance(Distance distance) {
        mongoOperations.save(distance, "distances");
        return true;
    }

    @Override
    public Distance getDistance(Distance distance) {
        return mongoOperations.findById(distance.getCityA()+distance.getCityB(), Distance.class);
    }
}

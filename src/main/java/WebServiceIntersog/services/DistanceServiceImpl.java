package WebServiceIntersog.services;

import WebServiceIntersog.domain.Distance;
import WebServiceIntersog.persistence.MongoConfig;
import WebServiceIntersog.repositories.DistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DistanceRepository distanceRepository;

    @Override
    public void putDistance(Distance distance) {
        distanceRepository.addNewDistance(distance);
    }

    @Override
    public Distance getDistance(Distance distance) {
        return distanceRepository.findByFromCityToCity(distance);
    }

    public DistanceRepository getDistanceRepository() {
        return distanceRepository;
    }

    public void setDistanceRepository(DistanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }
}

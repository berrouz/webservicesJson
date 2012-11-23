package shevchik.services;

import shevchik.domain.Distance;
import shevchik.repositories.DistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Distance Service Implementation
 * @author shevchik
 * @version 0.0.1
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

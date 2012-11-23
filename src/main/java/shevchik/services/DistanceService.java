package shevchik.services;


import shevchik.domain.Distance;

/**
 * Distance Service interface
 * @author shevchik
 * @version 0.0.1
 */
public interface DistanceService {

    /**
     * Puts the distance between cities cityA and cityB in DB
     * @param distance
     * @return
     */
    public void putDistance(Distance distance);


    /**
     *  Returns the distance between cities CityA and CityB
     *  @param distance
     */
    public Distance getDistance(Distance distance);

}

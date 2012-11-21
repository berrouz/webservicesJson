package WebServiceIntersog.services;


import WebServiceIntersog.domain.Distance;

/**
 * Distance Service interface
 */
public interface DistanceService {

    /**
     * Puts the distance between cities cityA and cityB in DB
     * @param distance
     * @return
     */
    public boolean putDistance(Distance distance);


    /**
     *  Returns the distance between cities CityA and CityB
     *  @param distance
     */
    public Distance getDistance(Distance distance);

}

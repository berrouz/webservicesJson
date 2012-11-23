package shevchik.repositories;

import shevchik.domain.Distance;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/** Distance Repository bean is used for working with MongoDB via queries
 * @author shevchik
 * @version 0.0.1
 */
@Repository
public class DistanceRepository {

    @Inject
    private MongoTemplate mongoTemplate;

    /**
     * Finds Distance objected by looking for cityA and cityB
     * @param distance
     * @return
     */
    public Distance findByFromCityToCity(Distance distance){
        Query query = new Query(Criteria.where("cityA").is(distance.getCityA()).and("cityB").is(distance.getCityB()));
        return mongoTemplate.findOne(query, Distance.class);
    }

    public void addNewDistance(Distance distance){
       mongoTemplate.insert(distance);
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}

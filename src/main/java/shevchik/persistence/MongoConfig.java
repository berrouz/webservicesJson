package shevchik.persistence;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * Mongo DB Configuration
 * "services" database is used for saving Distance Objects
 * @author shevchik
 * @version 0.0.1
 */

@Configuration
public class MongoConfig {
    /**
     * MongoDB Factory Bean
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(new Mongo(), "services");
    }


    /**
     * MongoTemplate Bean is used for persistence of Distance
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}

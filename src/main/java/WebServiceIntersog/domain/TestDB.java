package WebServiceIntersog.domain;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.List;

public class TestDB {
    public static void main(String[] args) throws UnknownHostException {
        Mongo mongo = new Mongo("localhost", 27017);
        DB db = mongo.getDB("services");
        DBCollection collection = db.getCollection("distances");
        BasicDBObject object = new BasicDBObject();
        object.put("name", "Shevchik");
        object.put("id", 1000);
        collection.insert(object);
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", 1000);
        DBCursor cursor = collection.find(searchQuery);
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
}

import com.mongodb.*;
import fr.database.MongoDBConnector;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static MongoDBConnector mongo = new MongoDBConnector();

    public static void main(String[] args) throws UnknownHostException {
        // Connection to the server
        MongoClient mongoServer = new MongoClient(new MongoClientURI(mongo.getMongoIP()));

        // Link to the database
        DB database = mongoServer.getDB("garage");

        // Link to the collection
        DBCollection collection = database.getCollection("cars");

        // Creation of the object
        List<Integer> books = Arrays.asList(27464, 747854);
        DBObject person = new BasicDBObject("_id", "jo")
                .append("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake St")
                        .append("city", "Faketon")
                        .append("state", "MA")
                        .append("zip", 12345))
                .append("books", books);

        // Insert to collection
        collection.insert(person);

    }
}

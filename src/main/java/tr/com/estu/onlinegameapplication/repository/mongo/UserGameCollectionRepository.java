package tr.com.estu.onlinegameapplication.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.com.estu.onlinegameapplication.model.mongo.UserGameCollection;

public interface UserGameCollectionRepository extends MongoRepository<UserGameCollection, String> {
}

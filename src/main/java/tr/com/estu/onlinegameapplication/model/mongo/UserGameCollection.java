package tr.com.estu.onlinegameapplication.model.mongo;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "userGameCollections")
public class UserGameCollection {
    @Id
    private String id;
    private String userId;
    private List<Long> gameIds;
}

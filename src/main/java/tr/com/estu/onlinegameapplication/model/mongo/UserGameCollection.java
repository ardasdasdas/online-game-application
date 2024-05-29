package tr.com.estu.onlinegameapplication.model.mongo;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "userGameCollections")
public class UserGameCollection {
    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING, unique = true)
    private String userId;
    private List<Long> gameIds;
}

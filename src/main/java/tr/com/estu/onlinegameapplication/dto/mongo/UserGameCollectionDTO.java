package tr.com.estu.onlinegameapplication.dto.mongo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserGameCollectionDTO {
    private String userId;
    private List<Long> gameIds = new ArrayList<>();
}

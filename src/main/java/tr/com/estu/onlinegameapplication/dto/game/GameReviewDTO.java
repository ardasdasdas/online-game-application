package tr.com.estu.onlinegameapplication.dto.game;

import lombok.*;
import tr.com.estu.onlinegameapplication.dto.base.BaseAdditionalFieldsDTO;
import tr.com.estu.onlinegameapplication.dto.base.BaseDTO;
import tr.com.estu.onlinegameapplication.model.enums.ReviewRate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameReviewDTO implements BaseDTO {
    private Long gameId;
    private Long userId;
    private String review;
    private ReviewRate reviewRate;
    private BaseAdditionalFieldsDTO baseAdditionalFields;
}

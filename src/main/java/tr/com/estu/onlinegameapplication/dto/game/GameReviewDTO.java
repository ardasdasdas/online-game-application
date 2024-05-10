package tr.com.estu.onlinegameapplication.dto.game;

import lombok.*;
import tr.com.estu.onlinegameapplication.dto.base.BaseAdditionalFieldsDTO;
import tr.com.estu.onlinegameapplication.dto.base.BaseDTO;
import tr.com.estu.onlinegameapplication.model.enums.ReviewRate;

@Getter
@Setter
public class GameReviewDTO implements BaseDTO {
    private Long gameId;
    private Long userId;
    private String review;
    private ReviewRate reviewRate;
    private transient BaseAdditionalFieldsDTO baseAdditionalFields;
}

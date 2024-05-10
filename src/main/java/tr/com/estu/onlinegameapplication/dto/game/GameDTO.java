package tr.com.estu.onlinegameapplication.dto.game;

import lombok.*;
import tr.com.estu.onlinegameapplication.dto.base.BaseAdditionalFieldsDTO;
import tr.com.estu.onlinegameapplication.dto.base.BaseDTO;

@Getter
@Setter
public class GameDTO implements BaseDTO {
    private String title;
    private String description;
    private double price;
    private Long categoryId;
    private transient BaseAdditionalFieldsDTO baseAdditionalFields;
}

package tr.com.estu.onlinegameapplication.dto;

import lombok.*;
import tr.com.estu.onlinegameapplication.dto.base.BaseAdditionalFieldsDTO;
import tr.com.estu.onlinegameapplication.dto.base.BaseDTO;

@Getter
@Setter
public class PurchaseDTO implements BaseDTO {
    private Long userId;
    private Long gameId;
    private double amount;
    private transient BaseAdditionalFieldsDTO baseAdditionalFields;
}

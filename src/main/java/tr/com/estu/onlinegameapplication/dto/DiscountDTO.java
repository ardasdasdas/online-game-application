package tr.com.estu.onlinegameapplication.dto;

import lombok.*;
import tr.com.estu.onlinegameapplication.dto.base.BaseAdditionalFieldsDTO;
import tr.com.estu.onlinegameapplication.dto.base.BaseDTO;

import java.util.Date;

@Getter
@Setter
public class DiscountDTO implements BaseDTO {
    private String code;
    private double amount;
    private Date expirationDate;
    private transient BaseAdditionalFieldsDTO baseAdditionalFields;
}

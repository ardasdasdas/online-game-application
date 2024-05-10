package tr.com.estu.onlinegameapplication.dto;

import lombok.*;
import tr.com.estu.onlinegameapplication.dto.base.BaseAdditionalFieldsDTO;
import tr.com.estu.onlinegameapplication.dto.base.BaseDTO;

@Getter
@Setter
public class LogDTO implements BaseDTO {
    private String message;
    private transient BaseAdditionalFieldsDTO baseAdditionalFields;
}

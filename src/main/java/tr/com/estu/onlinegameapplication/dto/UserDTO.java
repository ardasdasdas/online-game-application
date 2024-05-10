package tr.com.estu.onlinegameapplication.dto;

import lombok.*;
import tr.com.estu.onlinegameapplication.dto.base.BaseAdditionalFieldsDTO;
import tr.com.estu.onlinegameapplication.dto.base.BaseDTO;

@Getter
@Setter
public class UserDTO implements BaseDTO {
    private String userName;
    private String email;
    private String password;
    private transient BaseAdditionalFieldsDTO baseAdditionalFields;
}
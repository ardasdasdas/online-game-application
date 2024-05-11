package tr.com.estu.onlinegameapplication.dto;

import lombok.*;
import tr.com.estu.onlinegameapplication.dto.base.BaseAdditionalFieldsDTO;
import tr.com.estu.onlinegameapplication.dto.base.BaseDTO;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class LogDTO implements BaseDTO {
    private final String message;
    private transient BaseAdditionalFieldsDTO baseAdditionalFields;
}

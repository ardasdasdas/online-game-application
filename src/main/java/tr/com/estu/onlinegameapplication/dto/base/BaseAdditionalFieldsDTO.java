package tr.com.estu.onlinegameapplication.dto.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BaseAdditionalFieldsDTO implements Serializable {
    private Date createDate;
    private Date updateDate;
}

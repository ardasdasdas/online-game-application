package tr.com.estu.onlinegameapplication.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Embeddable
public class BaseAdditionalFields implements Serializable {
    @Column(name = "create_date", updatable = false)
    @CreatedDate
    private Date createDate;

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
}

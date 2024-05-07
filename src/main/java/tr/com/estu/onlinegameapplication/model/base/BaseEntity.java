package tr.com.estu.onlinegameapplication.model.base;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable, Entity  {

    @Serial
    private static final long serialVersionUID = 1L;

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;

    @Override
    public BaseEntity clone() {
        try {
            return (BaseEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

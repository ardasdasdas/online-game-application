package tr.com.estu.onlinegameapplication.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
    private Date errorDate;
    private String message;
}

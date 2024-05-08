package tr.com.estu.onlinegameapplication.dto.base;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T extends Serializable> implements Serializable {

    private T data;
    private Date responseDate;
    private boolean isSuccess;
    private String messages;

    public RestResponse(T data, boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
        responseDate = new Date();
    }

    public static <T extends Serializable> RestResponse<T> of(T t){
        return new RestResponse<>(t, true);
    }

    public static <T extends Serializable> RestResponse<T> error(T t){
        return new RestResponse<>(t, false);
    }

    public static <T extends Serializable> RestResponse<T> empty(){
        return new RestResponse<>(null, true);
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}

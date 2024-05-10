package tr.com.estu.onlinegameapplication.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tr.com.estu.onlinegameapplication.dto.LogDTO;
import tr.com.estu.onlinegameapplication.dto.base.RestResponse;
import tr.com.estu.onlinegameapplication.exception.error.ExceptionResponse;
import tr.com.estu.onlinegameapplication.mapper.Mapper;
import tr.com.estu.onlinegameapplication.model.Log;
import tr.com.estu.onlinegameapplication.model.base.BaseAdditionalFields;
import tr.com.estu.onlinegameapplication.service.LogService;

import java.util.Date;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final LogService logService;

    @ExceptionHandler(OnlineGameApplicationException.class)
    public ResponseEntity<Object> handleException(OnlineGameApplicationException ex) {
        Date errorDate = new Date();
        String message = ex.getMessage();

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate, message);
        RestResponse<ExceptionResponse> restResponse = RestResponse.error(exceptionResponse);
        restResponse.setMessages(message);
        log.error(ex.getMessage(), ex);
        logError(exceptionResponse);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void logError(ExceptionResponse exceptionResponse) {
        Log log = new Log();
        log.setMessage(exceptionResponse.getMessage());
        log.setBaseAdditionalFields(new BaseAdditionalFields());

        logService.log(Mapper.map(log, LogDTO.class));
    }
}

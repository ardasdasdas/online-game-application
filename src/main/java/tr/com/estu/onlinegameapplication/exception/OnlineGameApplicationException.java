package tr.com.estu.onlinegameapplication.exception;

import lombok.RequiredArgsConstructor;
import tr.com.estu.onlinegameapplication.exception.error.BaseErrorMessage;

@RequiredArgsConstructor
public class OnlineGameApplicationException extends RuntimeException {
    private final BaseErrorMessage baseErrorMessage;
}

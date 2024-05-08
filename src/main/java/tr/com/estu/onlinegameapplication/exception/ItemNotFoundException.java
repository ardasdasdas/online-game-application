package tr.com.estu.onlinegameapplication.exception;

import tr.com.estu.onlinegameapplication.exception.error.BaseErrorMessage;

public class ItemNotFoundException extends OnlineGameApplicationException {
    public ItemNotFoundException(BaseErrorMessage message) {
        super(message);
    }
}

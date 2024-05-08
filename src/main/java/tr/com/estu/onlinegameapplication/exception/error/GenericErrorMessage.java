package tr.com.estu.onlinegameapplication.exception.error;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GenericErrorMessage implements BaseErrorMessage {

    ITEM_NOT_FOUND("Item not found!")
    ;

    private final String message;

    @Override
    public String getMessage() {
        return message;
    }
}

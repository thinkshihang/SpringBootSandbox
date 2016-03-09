package errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such order")
public class OrderNotFoundException extends RuntimeException {

    private int code;

    public OrderNotFoundException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}

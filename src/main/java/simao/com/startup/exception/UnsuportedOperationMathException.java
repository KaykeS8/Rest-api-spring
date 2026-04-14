package simao.com.startup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedOperationMathException extends RuntimeException {

    public UnsuportedOperationMathException(String message) {
        super(message);
    }
}

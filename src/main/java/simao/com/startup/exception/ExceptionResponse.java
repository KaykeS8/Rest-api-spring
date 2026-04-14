package simao.com.startup.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details, int status) {
}

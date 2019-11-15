package pw.stas.qautils.exception;

import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GeneralExceptionHandler {

  @ExceptionHandler(value = NumberFormatException.class)
  public ResponseEntity<?> handleNumberFormatException(WebRequest request) {

    String message = "Argument should be a number";

    if (!Objects.equals(request.getHeader("Accept"), "application/json")) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    GeneralException response = new GeneralException(
        HttpStatus.BAD_REQUEST.value(),
        message,
        System.currentTimeMillis()
    );

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler
  public ResponseEntity<?> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException exc) {
    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exc.getLocalizedMessage());
  }

  @ExceptionHandler
  public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exc,
                                                                        WebRequest request) {

    if (!Objects.equals(request.getHeader("Accept"), "application/json")) {
      return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(exc.getLocalizedMessage());
    }

    GeneralException response = new GeneralException(
        HttpStatus.METHOD_NOT_ALLOWED.value(),
        exc.getLocalizedMessage(),
        System.currentTimeMillis()
    );

    return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
  }
}

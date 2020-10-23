package icu.random.exception;

import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GeneralExceptionHandler {

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

  @ExceptionHandler
  public ResponseEntity<?> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exc, WebRequest request) {

    if (!Objects.equals(request.getHeader("Accept"), "application/json")) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
          exc.getName(),
          exc.getValue(),
          Objects.requireNonNull(exc.getRequiredType()).getSimpleName()));
    }

    GeneralException response = new GeneralException(
        HttpStatus.BAD_REQUEST.value(),
        String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
            exc.getName(),
            exc.getValue(),
            Objects.requireNonNull(exc.getRequiredType()).getSimpleName()),
        System.currentTimeMillis()
    );
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IncorrectLanguageException.class)
  public ResponseEntity<?> handleIncorrectLanguageException(IncorrectLanguageException exc) {

    GeneralException response = new GeneralException(
        HttpStatus.BAD_REQUEST.value(),
        exc.getLocalizedMessage(),
        System.currentTimeMillis()
    );
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpClientFailureException.class)
  public ResponseEntity<?> handleHttpClientFailureException(HttpClientFailureException exc) {

    HttpStatus status = exc.getStatus();

    GeneralException response = new GeneralException(
        status.value(),
        exc.getLocalizedMessage(),
        System.currentTimeMillis()
    );

    return new ResponseEntity<>(response, status);
  }
}

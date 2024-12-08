package mmiftahrzki.bootcamp.final_project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import mmiftahrzki.bootcamp.final_project.model.response.ErrorResponse;

@ControllerAdvice
public class AppExceptionHandler {
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exception, WebRequest request) {
    ErrorResponse error_response = new ErrorResponse();

    error_response.setTimeStamp(LocalDateTime.now());
    error_response.setStatus(HttpStatus.BAD_REQUEST.value());
    error_response.setMessage(exception.getMessage());
    error_response.setPath(request.getDescription(false));

    return new ResponseEntity<ErrorResponse>(error_response, HttpStatus.BAD_REQUEST);
  }
}

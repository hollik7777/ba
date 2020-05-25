package code;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(DemoModelNotFoundException.class)
  protected ResponseEntity<Error> handleDemoModelNotFoundException(DemoModelNotFoundException ex) {
    return new ResponseEntity<>(new Error(HttpStatus.NOT_FOUND.value(), "Demo model not found"), HttpStatus.NOT_FOUND);
  }

  public static class Error {
    int status;
    String message;

    public Error(int status, String message) {
      this.status = status;
      this.message = message;
    }

    public int getStatus() {
      return status;
    }

    public void setStatus(int status) {
      this.status = status;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }
  }
}

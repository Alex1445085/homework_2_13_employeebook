package pro.sky.homework213employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Department not found")
public class FirstNameOrLastNameIsEmptyException extends RuntimeException {
    public FirstNameOrLastNameIsEmptyException(String note) {
        super("FirstNameOrLastNameIsEmptyException = " + note);
    }
}

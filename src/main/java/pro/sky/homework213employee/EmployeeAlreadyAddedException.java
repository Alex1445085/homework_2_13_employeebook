package pro.sky.homework213employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "EmployeeAlreadyAddedException")
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String note) {
        super("EmployeeAlreadyAddedException = " + note);
    }
}

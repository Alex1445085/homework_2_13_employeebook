package pro.sky.homework213employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "EmployeeNotExistException")
public class EmployeeNotExistException extends RuntimeException {
    public EmployeeNotExistException(String note) {
        super("EmployeeNotExistException = " + note);
    }
}


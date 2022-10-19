package proskyEmployeeList;

import org.springframework.web.bind.annotation.ResponseStatus;
import static org.springframework.http.HttpStatus.CONFLICT;
@ResponseStatus(value = CONFLICT)
public class EmployeeAlreadyAddedException extends RuntimeException {
        public EmployeeAlreadyAddedException(String message){
            super(message);
        }
    }

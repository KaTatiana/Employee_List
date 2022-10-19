package proskyEmployeeList;

import org.springframework.web.bind.annotation.ResponseStatus;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
        public EmployeeNotFoundException(){
            //super(message);
        }

}

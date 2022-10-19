package proskyEmployeeList;

import org.springframework.web.bind.annotation.ResponseStatus;
import static org.springframework.http.HttpStatus.PAYLOAD_TOO_LARGE;

@ResponseStatus(value = PAYLOAD_TOO_LARGE)
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message){
        super(message);
    }
}
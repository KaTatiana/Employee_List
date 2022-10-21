package proskyEmployeeList;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value =BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    public BadRequestException(){
    }
}


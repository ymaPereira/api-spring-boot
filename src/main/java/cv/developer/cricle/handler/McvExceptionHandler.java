package cv.developer.cricle.handler;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class McvExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException ex){
		log.info("Violation exception");
		List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());
		ex.getConstraintViolations().forEach(error-> {
			errorList.add(error.getMessage());
			log.error(error.getMessage());
		});
		
		return new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);
	}	
	/*
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex){
		log.info("Global exception");
		log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }*/
}

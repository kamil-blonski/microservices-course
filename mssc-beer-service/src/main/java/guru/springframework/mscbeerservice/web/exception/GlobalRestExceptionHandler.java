package guru.springframework.mscbeerservice.web.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		//handle errors with code 400
		logger.info(ex.getClass().getName());
		final List<String> errors = new ArrayList<String>();
		for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		ApiErrorResponse apiResponse = new ApiErrorResponse
			.ApiErrorResponseBuilder()
			.withMessage("Message fot 400 bad request")
			.withDetail("...")
			.withError_code("404")
			.withStatus(HttpStatus.NOT_FOUND)
			.atTime(LocalDateTime.now(ZoneOffset.UTC))
			.errors(errors)
			.build();

		return handleExceptionInternal(ex, apiResponse, headers, apiResponse.getStatus(), request);
	}

}

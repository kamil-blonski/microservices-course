package guru.springframework.mscbeerservice.web.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter //returning to json requires public get methods
public class ApiErrorResponse {

	private HttpStatus status;

	private String error_code;

	private String message;

	private String detail;

	private LocalDateTime timeStamp;

	private List<String> errors;

	public static final class ApiErrorResponseBuilder {
		private HttpStatus status;
		private String error_code;
		private String message;
		private String detail;
		private LocalDateTime timeStamp;
		private List<String> errors;

		public ApiErrorResponseBuilder() {}

		public static ApiErrorResponseBuilder anApiErrorResponse() {
			return new ApiErrorResponseBuilder();
		}

		public ApiErrorResponseBuilder withStatus(HttpStatus status) {
			this.status = status;
			return this;
		}

		public ApiErrorResponseBuilder withError_code(String error_code) {
			this.error_code = error_code;
			return this;
		}

		public ApiErrorResponseBuilder withMessage(String message) {
			this.message = message;
			return this;
		}

		public ApiErrorResponseBuilder withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public ApiErrorResponseBuilder atTime(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
			return this;
		}

		public ApiErrorResponseBuilder errors(List<String> errors) {
			this.errors = errors;
			return this;
		}
		public ApiErrorResponse build() {
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.status = this.status;
			apiErrorResponse.error_code = this.error_code;
			apiErrorResponse.detail = this.detail;
			apiErrorResponse.message = this.message;
			apiErrorResponse.timeStamp = this.timeStamp;
			apiErrorResponse.errors = this.errors;
			return apiErrorResponse;
		}
	}
}
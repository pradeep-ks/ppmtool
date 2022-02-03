package io.javatech.ppmtool.api.web.dto.response;

public class ApiResponseDTO {

	private String message;

	private boolean success;

	public ApiResponseDTO() {
	}

	public ApiResponseDTO(String message, boolean success) {
		this.message = message;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}

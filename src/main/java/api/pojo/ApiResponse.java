package api.pojo;

public class ApiResponse {

	private final int code;
	private final String type;
	private final String message;

	public ApiResponse(int code, String type, String message) {
		this.code = code;
		this.type = type;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}
}

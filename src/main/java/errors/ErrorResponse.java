package errors;

public class ErrorResponse {

    private int code;
    private String message;
    private String developerMessage;

    public ErrorResponse(int code, String message, String developerMessage) {
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}

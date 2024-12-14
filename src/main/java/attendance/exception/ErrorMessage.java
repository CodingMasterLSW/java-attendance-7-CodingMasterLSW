package attendance.exception;

public enum ErrorMessage {
    NOT_BLANK_INPUT("입력은 공백일 수 없습니다. 다시 입력해주세요."),
    INVALID_INPUT("잘못된 입력입니다. 다시 입력해주세요."),
    FILE_LOAD_EXCEPTION("잘못된 파일 형식입니다. 파일을 확인해주세요"),
    NOT_EXIST_NICKNAME("등록되지 않은 닉네임입니다."),
    INVALID_FORMAT("잘못된 형식을 입력하였습니다."),
    NOT_ATTENDANCE_DAY("%s월 %s일 %s은 등교일이 아닙니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}

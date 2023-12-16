package oncall.util.exception;

public enum ErrorMessage {
    WRONG_DELIMITER ("[ERROR]", "구분자를 잘못 입력하셨습니다. 콤마(,) 를 사용해주세요."),
    NOT_NUMBER ("[ERROR]", "월에는 숫자를 입력해 주세요."),
    NOT_DAY_OF_WEEK ("[ERROR]", "잘못된 요일을 입력했습니다."),
    WRONG_MONTH_VALUE ("[ERROR]", "월에는 0~12의 숫자를 입력해 주세요.");


    private final String suffix;
    private final String errorMessage;

    ErrorMessage(String suffix, String errorMessage) {
        this.suffix = suffix;
        this.errorMessage = errorMessage;
    }

    public String makeErrorMessage() {
        return String.join(" ", suffix, errorMessage);
    }
}

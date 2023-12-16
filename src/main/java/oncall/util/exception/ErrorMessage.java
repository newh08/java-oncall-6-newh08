package oncall.util.exception;

public enum ErrorMessage {
    WRONG_DELIMITER ("[ERROR]", "구분자를 잘못 입력하셨습니다. 콤마(,) 를 사용해주세요."),
    NOT_NUMBER ("[ERROR]", "월에는 숫자를 입력해 주세요."),
    NOT_DAY_OF_WEEK ("[ERROR]", "잘못된 요일을 입력했습니다."),
    WRONG_MONTH_VALUE("[ERROR]", "월에는 0~12의 숫자를 입력해 주세요."),
    WRONG_EMPLOYEE_NUMBER("[ERROR]", "직원 숫자는 최소 5명, 최대 35명 입니다."),
    NOT_SAME_EMPLOYEE_IN_ONE_WORK("[ERROR]", "평일, 혹은 휴일 비상근무 스케쥴에 중복 인원이 들어갈 수 없습니다."),
    TOO_LONG_EMPLOYEE_NAME("[ERROR]", "임직원의 이름은 5자까지 가능합니다");


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

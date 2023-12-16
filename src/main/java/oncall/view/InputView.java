package oncall.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.util.converter.ViewConverter;
import oncall.util.exception.ErrorMessage;
import oncall.util.exception.MyIllegalArgumentException;
import oncall.view.dto.InputMonthAndDayDto;

public class InputView {
    private static final String INPUT_START_MONTH_AND_DAY_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String INPUT_WEEK_WORK_EMPLOYEE_MESSAGE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String INPUT_WEEKEND_WORK_EMPLOYEE_MESSAGE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String DELIMITER = ",";

    private final ViewConverter viewConverter;

    public InputView(ViewConverter viewConverter) {
        this.viewConverter = viewConverter;
    }

    public InputMonthAndDayDto readMonthAndDay() {
        System.out.println(INPUT_START_MONTH_AND_DAY_MESSAGE);
        String inputMessage = Console.readLine();
        if (!inputMessage.contains(DELIMITER)) {
            throw new MyIllegalArgumentException(ErrorMessage.WRONG_DELIMITER);
        }
        String[] splitInput = inputMessage.split(DELIMITER);
        validateMonthIsNumber(splitInput);

        return viewConverter.convertToInputMonthAndDayDto(splitInput);
    }

    private static void validateMonthIsNumber(String[] splitInput) {
        try {
            Integer.parseInt(splitInput[0]);
        } catch (NumberFormatException e) {
            throw new MyIllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
    }

    public List<String> readWeekWorkEmployee() {
        System.out.println(INPUT_WEEK_WORK_EMPLOYEE_MESSAGE);
        return readEmployeeName();
    }

    public List<String> readWeekendWorkEmployee() {
        System.out.println(INPUT_WEEKEND_WORK_EMPLOYEE_MESSAGE);
        return readEmployeeName();
    }

    private static List<String> readEmployeeName() {
        String inputMessage = Console.readLine();
        if (!inputMessage.contains(DELIMITER)) {
            throw new MyIllegalArgumentException(ErrorMessage.WRONG_DELIMITER);
        }
        return List.of(inputMessage.split(DELIMITER));
    }
}

package oncall.util.converter;

import oncall.view.dto.InputMonthAndDayDto;

public class ViewConverter {
    private static ViewConverter instance;

    private ViewConverter() {
    }

    public static ViewConverter getInstance() {
        if (instance == null) {
            instance = new ViewConverter();
        }
        return instance;
    }

    public InputMonthAndDayDto convertToInputMonthAndDayDto(String[] input) {
        return new InputMonthAndDayDto(Integer.parseInt(input[0]), input[1]);
    }
}

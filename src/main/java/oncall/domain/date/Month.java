package oncall.domain.date;

import java.util.Arrays;
import oncall.util.exception.ErrorMessage;
import oncall.util.exception.MyIllegalArgumentException;

public enum Month {
    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5,31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);
    private final int month;
    private final int totalDate;

    Month(int month, int totalDate) {
        this.month = month;
        this.totalDate = totalDate;
    }

    public int getTotalDate() {
        return totalDate;
    }

    public static Month getMonth(int month) {
        return Arrays.stream(values())
                .filter(m -> m.month == month)
                .findAny()
                .orElseThrow(() -> new MyIllegalArgumentException(ErrorMessage.WRONG_MONTH_VALUE));
    }

    @Override
    public String toString() {
        return month + "월";
    }
}

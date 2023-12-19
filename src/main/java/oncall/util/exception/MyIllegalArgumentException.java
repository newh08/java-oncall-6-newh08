package oncall.util.exception;

public class MyIllegalArgumentException extends IllegalArgumentException {

    public MyIllegalArgumentException(ErrorMessage errorMessage) {
        super(errorMessage.makeErrorMessage());
    }
}

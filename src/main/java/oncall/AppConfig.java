package oncall;

import oncall.controller.Controller;
import oncall.util.converter.DomainConverter;
import oncall.util.converter.ViewConverter;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {
    public Controller controller() {
        return new Controller(inputView(), outputView(), domainConverter());
    }

    private DomainConverter domainConverter() {
        return DomainConverter.getInstance();
    }

    private InputView inputView() {
        return new InputView(viewConverter());
    }

    private ViewConverter viewConverter() {
        return ViewConverter.getInstance();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}

package mediator;

public class SimpleLogicProcessorFactory {
    private SimpleLogicProcessorFactory() {
    }

    public static LogicProcessor getProcessor(String event) {
        if ("register".equals(event)) {
            return new RegisterLogicProcessor();
        } else if ("login".equals(event)) {
            return new LoginLogicProcessor();
        } else {
            return new TextLogicProcessor();
        }
    }
}

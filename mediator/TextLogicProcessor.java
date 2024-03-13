package mediator;

public class TextLogicProcessor implements LogicProcessor{
    @Override
    public void process(String message) {
        System.out.println("no matter what kind of text, do nothing here, just for tester...");
    }
}

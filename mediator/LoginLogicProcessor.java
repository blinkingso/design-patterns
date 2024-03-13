package mediator;

public class LoginLogicProcessor implements LogicProcessor{
    @Override
    public void process(String message) {
        System.out.println("maybe open login dialog to do some logic....");
    }
}

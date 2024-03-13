package command;

public class StartTransactionCommand implements Command {
    @Override
    public void execute() {
        System.out.println("开启事务");
    }
}

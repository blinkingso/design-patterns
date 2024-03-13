package command;

public class RollbackCommand implements Command {
    @Override
    public void execute() {
        System.out.println("事务回滚模拟");
    }
}

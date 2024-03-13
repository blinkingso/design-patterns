package command;

public class CommitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("提交事务模拟");
    }
}

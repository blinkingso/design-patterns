package memento;

/**
 * 如果包含了一系列的历史记录比如： redis操作日志记录或者mysql的undo和redo日志等等，
 * 可以将这些记录放在一个数组或者链表中，按需取出所需记录完成状态恢复。
 *
 * @code List<Log> logs = new ArrayList<Log>
 */
public class GameStatusMemento {
    public GameStatusMemento(GameStatus status) {
        this.status = status;
    }

    private GameStatus status;

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
}

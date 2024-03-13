package memento;

/**
 * 游戏
 */
public class Game {

    private GameStatus status;

    public Game() {
        this.status = new GameStatus();
    }

    public GameStatus getStatus() {
        return status;
    }

    public void start() {
        System.out.println("Game start...");
        this.status.cal();
    }

    public GameStatusMemento pause() {
        System.out.println("Game paused");
        GameStatusMemento status = this.saveGameStatus();
        System.out.println("Game paused with status saved ready!!!");
        return status;
    }

    public void resume(GameStatusMemento statusMemento) {
        System.out.println("Game resume");
        this.status = statusMemento.getStatus();
        System.out.println("Game resume ok... ");
        this.status.cal();
        System.out.println("Game Over...");
    }

    public GameStatusMemento saveGameStatus() {
        return new GameStatusMemento(status);
    }

}

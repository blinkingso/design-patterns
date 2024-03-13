package memento;

/**
 * 备忘录模式：
 * 在不破坏封闭的前提下捕获一个对象的内部状态，并在该对象之外保存这个状态，从而可以将对象恢复到原先保存的状态
 */
public class MementoPattern {
    public static void main(String[] args) {
        final Game game = new Game();
        game.start();
        final GameStatusMemento savedStatus = game.pause();
        game.resume(savedStatus);
    }
}

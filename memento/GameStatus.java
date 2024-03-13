package memento;

public class GameStatus {
    private int x;
    private int y;
    private String color;
    private int occupied;
    private int score;
    private int level;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void cal() {
        this.x += 1;
        this.y += 1;
        this.setOccupied(1);
        this.setLevel(1);
        this.score += 100;
    }
}

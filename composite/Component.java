package composite;

public abstract class Component {
    private Component parent;
    private String id;
    private double x;
    private double y;

    protected Component(double x, double y) {
        this(null, x, y);
    }

    protected Component(Component parent, double x, double y) {
        this.parent = parent;
        this.x = x;
        this.y = y;
    }

    public Component getParent() {
        return parent;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * 注册单击事件
     */
    public abstract void onclick();

    /**
     * 部分组建拥有此功能
     */
    public void hover() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Component{" +
                ", id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

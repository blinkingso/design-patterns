package composite;

/**
 * Label 没有hover功能
 */
public class Label extends Component {
    private String name;

    public Label(String name) {
        this(0.0, 0.0);
        this.name = name;
    }

    protected Label(double x, double y) {
        super(x, y);
    }

    public String getName() {
        return name;
    }

    /**
     * 注册单击事件
     */
    @Override
    public void onclick() {
        System.out.println("Label: " + this.getName() + " was clicked");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

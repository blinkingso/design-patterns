package composite;

public class Button extends Component {
    public Button(String id) {
        this(null, 0.0, 0.0);
        this.setId(id);
    }

    public Button(Component parent, double x, double y) {
        super(parent, x, y);
    }

    /**
     * 注册单击事件
     */
    @Override
    public void onclick() {
        System.out.println("Button: " + this.getId() + " was clicked");
    }

    @Override
    public void hover() {
        System.out.println("Button: " + this.getId() + " hovered.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

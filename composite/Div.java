package composite;

import java.util.ArrayList;
import java.util.List;

public class Div extends Component {
    private final List<Component> components = new ArrayList<>();

    public Div(String id) {
        this(0.0, 0.0);
        super.setId(id);
    }

    public void addComponent(Component component) {
        component.setParent(this);
        this.components.add(component);
    }

    public void removeComponent(Component component) {
        this.components.remove(component);
    }

    public void removeComponentAt(int index) {
        this.components.remove(index);
    }

    public void show() {
        System.out.println(this);
    }

    protected Div(double x, double y) {
        super(x, y);
    }

    /**
     * 注册单击事件
     */
    @Override
    public void onclick() {
        System.out.println("Div clicked");
    }

    @Override
    public String toString() {
        return "Div{" + "components=" + components + '}';
    }
}

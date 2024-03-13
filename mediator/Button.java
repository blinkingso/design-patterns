package mediator;

public class Button extends Component {
    private String name;

    public Button(String name, DialogMediator dialog) {
        super(dialog);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void click() {
        System.out.println("Button: " + name + ", was clicked");
        dialog.onEvent(name, name);
    }
}

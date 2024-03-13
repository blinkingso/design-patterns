package mediator;

public class TextBox extends Component {
    private String value;

    public TextBox(String value, DialogMediator dialog) {
        super(dialog);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void click() {
        System.out.println("TextBox: " + value + ", was clicked");
        dialog.onEvent(value, value);
    }
}

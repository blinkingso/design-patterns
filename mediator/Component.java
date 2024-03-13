package mediator;

public abstract class Component {

    DialogMediator dialog;

    public Component(DialogMediator dialog) {
        this.dialog = dialog;
    }

    public abstract void click();
}

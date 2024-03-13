package composite;


public class CompositePattern {
    public static void main(String[] args) {
        final Div div = new Div("container");
        div.addComponent(new Button("Register"));
        div.addComponent(new Button("Login"));
        div.addComponent(new Label("Email"));
        div.show();
        div.onclick();
    }
}

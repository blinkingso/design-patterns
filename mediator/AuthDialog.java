package mediator;

public class AuthDialog implements DialogMediator {

    private Button loginBtn, registerBtn;
    private TextBox name, pwd;

    public Button getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(Button loginBtn) {
        this.loginBtn = loginBtn;
    }

    public Button getRegisterBtn() {
        return registerBtn;
    }

    public void setRegisterBtn(Button registerBtn) {
        this.registerBtn = registerBtn;
    }

    public TextBox getName() {
        return name;
    }

    public void setName(TextBox name) {
        this.name = name;
    }

    public TextBox getPwd() {
        return pwd;
    }

    public void setPwd(TextBox pwd) {
        this.pwd = pwd;
    }

    @Override
    public void onEvent(String msg, String event) {
        SimpleLogicProcessorFactory.getProcessor(event).process(msg);
    }
}

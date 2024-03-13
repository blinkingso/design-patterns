package mediator;

/**
 * 中介者模式： 相同角色的用户或者产品之间通过一个中介进行交互聚合交互。
 * <p>
 * 缺点： 系统不断扩展会导致中介者超级复杂
 */
public class MediatorPattern {
    public static void main(String[] args) {
        final AuthDialog dialog = new AuthDialog();
        final Button registerBtn = new Button("register", dialog);
        final Button loginBtn = new Button("login", dialog);
        final TextBox name = new TextBox("name",dialog);
        final TextBox pwd = new TextBox("pwd", dialog);
        dialog.setName(name);
        dialog.setPwd(pwd);
        dialog.setRegisterBtn(registerBtn);
        dialog.setLoginBtn(loginBtn);

        // check functional.
        name.click();
        registerBtn.click();
        loginBtn.click();
    }
}

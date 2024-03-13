package bridge.pay;

public class PasswordMode implements IPayMode {
    private final String password;

    public PasswordMode(String password) {
        this.password = password;
    }


    /**
     * 验证安全性： 模拟人脸识别，或者指纹验证，或者密码验证
     *
     * @param uId 用户id
     */
    @Override
    public boolean checkSecurity(String uId) {
        System.out.println("用户: " + uId + "输入密码： " + this.password);
        return "pass".equals(this.password);
    }
}

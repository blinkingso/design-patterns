package bridge.pay;

public class FingerMode implements IPayMode {
    private final int level;
    private final String finger;

    public FingerMode(int level, String finger) {
        this.level = level;
        this.finger = finger;
    }

    /**
     * 验证安全性： 模拟人脸识别，或者指纹验证，或者密码验证
     *
     * @param uId 用户id
     */
    @Override
    public boolean checkSecurity(String uId) {
        System.out.println("模拟用户： " + uId + ", 通过指纹识别验证，级别为： " + this.level + ", 指纹数： " + this.finger);
        if (0 == this.level) {
            return "simple".equals(this.finger);
        }
        return false;
    }
}

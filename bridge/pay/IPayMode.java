package bridge.pay;

public interface IPayMode {
    /**
     * 验证安全性： 模拟人脸识别，或者指纹验证，或者密码验证
     */
    boolean checkSecurity(String uId);
}

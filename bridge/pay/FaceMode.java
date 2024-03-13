package bridge.pay;

public class FaceMode implements IPayMode {
    /**
     * 验证安全性： 模拟人脸识别，或者指纹验证，或者密码验证
     *
     * @param uId 用户id
     */
    @Override
    public boolean checkSecurity(String uId) {
        System.out.println("模拟人脸识别， 默认直接通过楼： 用户id为： " + uId);
        return true;
    }
}

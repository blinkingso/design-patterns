package bridge.pay;

import java.math.BigDecimal;

public class AliPayService extends AbstractPayService {
    public AliPayService(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String pay(String uId, BigDecimal amount) {
        System.out.println("支付宝支付模拟开始执行");
        boolean security = this.payMode.checkSecurity(uId);
        System.out.println("支付宝支付安全认证结果为： " + security);
        if (security) {
            System.out.println("支付宝支付成功了, 用户id为: " + uId + ", 支付金额为: " + amount);
            return "0123123123";
        } else {
            System.out.println("支付宝支付失败, 用户id为:" + uId + ", 想要支付的金额为： " + amount);
        }
        return null;
    }
}

package bridge.pay;

import java.math.BigDecimal;

public class WxPayService extends AbstractPayService {
    public WxPayService(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String pay(String uId, BigDecimal amount) {
        System.out.println("微信支付模拟开始执行");
        boolean security = this.payMode.checkSecurity(uId);
        System.out.println("微信支付安全验证结果为: " + security);
        System.out.println("微信支付模拟支付成功: 用户id： " + uId + ", 支付金额： " + amount);
        return "o2124000123";
    }
}

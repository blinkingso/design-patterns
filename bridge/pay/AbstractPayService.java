package bridge.pay;


import bridge.AbstractDevice;

import java.math.BigDecimal;

public abstract class AbstractPayService {
    protected IPayMode payMode;

    protected AbstractPayService(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String pay(String uId, BigDecimal amount);
}

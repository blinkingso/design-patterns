package strategy;

import java.math.BigDecimal;

public class OneCouponDiscount implements ICouponDiscount<BigDecimal> {
    /**
     * 1元购
     * 件件1元 通通1元 全部1元
     *
     * @param couponInfo 折扣信息
     * @param skuPrice   总金额
     * @return 实付金额
     */
    @Override
    public BigDecimal discount(BigDecimal couponInfo, BigDecimal skuPrice) {
        return BigDecimal.ONE;
    }
}

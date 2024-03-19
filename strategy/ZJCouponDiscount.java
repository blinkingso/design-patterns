package strategy;

import java.math.BigDecimal;

public class ZJCouponDiscount implements ICouponDiscount<BigDecimal> {
    /**
     * 直减计算
     * <p>
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     *
     * @param couponInfo 直减金额
     * @param skuPrice   原金额
     * @return 实付金额
     */
    @Override
    public BigDecimal discount(BigDecimal couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(couponInfo);
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}

package strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ZKCouponDiscount implements ICouponDiscount<BigDecimal> {
    /**
     * 折扣后的金额
     * 1. 使用商品价格 * 折扣比例， 为最后实付金额
     * 2. 保留两位小数
     * 3. 最低支付1元
     *
     * @param couponInfo 折扣信息
     * @param skuPrice   总金额
     * @return 实付金额
     */
    @Override
    public BigDecimal discount(BigDecimal couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(couponInfo).setScale(2, RoundingMode.HALF_UP);
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}

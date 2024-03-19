package strategy;

import java.math.BigDecimal;
import java.util.Map;

public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {
    /**
     * 满减计算
     * 1. 判断满足x元后-N元， 否则不减
     * 2. 最低支付1元
     *
     * @param couponInfo 折扣信息
     * @param skuPrice   折扣金额
     * @return 实付金额
     */
    @Override
    public BigDecimal discount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;
        // minus coupon amount
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        // 折扣后的金额 <= 0
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}

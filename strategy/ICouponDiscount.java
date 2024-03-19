package strategy;

import java.math.BigDecimal;

public interface ICouponDiscount<T> {

    /**
     * 折扣后的金额
     *
     * @param couponInfo 折扣信息
     * @param skuPrice   总金额
     * @return 实付金额
     */
    BigDecimal discount(T couponInfo, BigDecimal skuPrice);
}

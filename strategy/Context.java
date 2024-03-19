package strategy;

import java.math.BigDecimal;

public class Context<T> implements ICouponDiscount<T> {

    private final ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    /**
     * 折扣后的金额
     *
     * @param couponInfo 折扣信息
     * @param skuPrice   总金额
     * @return 实付金额
     */
    @Override
    public BigDecimal discount(T couponInfo, BigDecimal skuPrice) {
        return this.couponDiscount.discount(couponInfo, skuPrice);
    }
}

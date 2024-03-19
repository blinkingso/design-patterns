package strategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式
 */
public class StrategyPattern {
    public static void main(String[] args) {
        final Context<Map<String, String>> context = new Context<>(new MJCouponDiscount());
        Map<String, String> couponInfo = new HashMap<>(2);
        // 满100减10元-
        couponInfo.put("x", "100");
        couponInfo.put("n", "10");
        final BigDecimal discount = context.discount(couponInfo, new BigDecimal("100"));
        System.out.println("满减优惠后实付金额为： " + discount);
    }
}
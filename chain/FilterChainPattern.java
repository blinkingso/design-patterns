package chain;

import chain.exa.LevelOneAudit;
import chain.exa.LevelThreeAudit;
import chain.exa.LevelTwoAudit;

import java.util.Calendar;
import java.util.Date;

/**
 * 责任链模式： 最典型的模式就是过滤器
 */
public class FilterChainPattern {

    public static void main(String[] args) {
        final DefaultFilterChain chain = new DefaultFilterChain();
        chain.addFilter(new AuthFilter());
        chain.addFilter(new LenFilter());
        boolean res = chain.doFilter("success", "world");
        System.out.println("res => " + res);

        final Calendar start = Calendar.getInstance();
        start.add(Calendar.DAY_OF_MONTH, -10);
        final Date startTime = start.getTime();
        start.add(Calendar.DAY_OF_MONTH, 20);
        final Date endTime = start.getTime();
        final LevelThreeAudit three = new LevelThreeAudit();
        final LevelTwoAudit two = new LevelTwoAudit(startTime, endTime, three);
        final LevelOneAudit one = new LevelOneAudit(two);
        start.add(Calendar.DAY_OF_MONTH, -15);
        final Date applyDate = start.getTime();
        one.audit("a123", applyDate);
    }
}

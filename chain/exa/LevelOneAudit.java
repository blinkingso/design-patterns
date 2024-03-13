package chain.exa;

import java.time.Instant;
import java.util.Date;

/**
 * 一级审核权限可以审核当天之前的申请单, 并提交给二级审核权限者
 */
public class LevelOneAudit extends AbstractAudit {
    public LevelOneAudit(AbstractAudit next) {
        super(next);
    }

    @Override
    public void audit(String applyId, Date applyDate) {
        Date now = Date.from(Instant.now());
        System.out.println("一级审批： " + applyId);
        if (applyDate.before(now)) {
            this.getNext().audit(applyId, applyDate);
        }
    }
}

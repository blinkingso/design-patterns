package chain.exa;

import java.util.Date;

public class LevelTwoAudit extends AbstractAudit {
    private final Date startDate;
    private final Date endDate;

    public LevelTwoAudit(Date startDate, Date endDate, AbstractAudit next) {
        super(next);
        this.startDate = startDate;
        this.endDate = endDate;
    }


    @Override
    public void audit(String applyId, Date applyDate) {
        System.out.println("二级审批开始");
        if (applyDate.after(startDate) && applyDate.before(endDate)) {
            this.getNext().audit(applyId, applyDate);
        }
    }
}

package chain.exa;

import java.util.Date;

public class LevelThreeAudit extends AbstractAudit {
    @Override
    public void audit(String applyId, Date applyDate) {
        System.out.println("三级审批开始");
        System.out.println("三级审批结束");
    }
}

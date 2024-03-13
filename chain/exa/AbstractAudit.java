package chain.exa;

import java.util.Date;

/**
 * 抽象审核责任功能, 逐级审核
 */
public abstract class AbstractAudit {

    private AbstractAudit next;

    public AbstractAudit() {
        this.next = null;
    }

    public AbstractAudit(AbstractAudit next) {
        assert next != null;
        // 必须是不同的实现类, 自己不能做自己的next
        assert !next.getClass().isInstance(this);
        this.next = next;
    }

    public void setNext(AbstractAudit next) {
        this.next = next;
    }

    public AbstractAudit getNext() {
        return next;
    }

    public abstract void audit(String applyId, Date applyDate);
}

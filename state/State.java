package state;

/**
 * 状态流转
 */
public abstract class State {

    /**
     * 提审活动
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    public abstract void arraignment(String activityId, Enum<Status> currentStatus);

    /**
     * 审批通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    public abstract void checkPass(String activityId, Enum<Status> currentStatus);

    /**
     * 审批拒绝
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    public abstract void checkRefuse(String activityId, Enum<Status> currentStatus);

    /**
     * 提审撤销
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    public abstract void checkRevoke(String activityId, Enum<Status> currentStatus);

    /**
     * 关闭活动
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    public abstract void close(String activityId, Enum<Status> currentStatus);

    /**
     * 活动开启
     *
     * @param activityId    活动ID
     * @param currentStatus 当期状态
     */
    public abstract void open(String activityId, Enum<Status> currentStatus);

    /**
     * 活动执行
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    public abstract void doing(String activityId, Enum<Status> currentStatus);
}

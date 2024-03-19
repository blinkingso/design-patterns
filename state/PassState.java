package state;

/**
 * 审批通过的状态
 */
public class PassState extends State {
    /**
     * 提审活动
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void arraignment(String activityId, Enum<Status> currentStatus) {
        System.out.println("审批通过的活动不可重新提审！！！");
    }

    /**
     * 审批通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkPass(String activityId, Enum<Status> currentStatus) {
        System.out.println("该活动已经审批通过！！！");
    }

    /**
     * 审批拒绝
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkRefuse(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Refuse);
        System.out.println("活动再次审批拒绝成功");
    }

    /**
     * 提审撤销
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkRevoke(String activityId, Enum<Status> currentStatus) {
        System.out.println("已经提审的活动不能撤审！！！");
    }

    /**
     * 关闭活动
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Closed);
        System.out.println("活动关闭成功！！！");
    }

    /**
     * 活动开启
     *
     * @param activityId    活动ID
     * @param currentStatus 当期状态
     */
    @Override
    public void open(String activityId, Enum<Status> currentStatus) {
        System.out.println("非关闭活动不能开启！！！");
    }

    /**
     * 活动执行
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void doing(String activityId, Enum<Status> currentStatus) {
        System.out.println("活动正在执行中。。。。。。");
    }
}

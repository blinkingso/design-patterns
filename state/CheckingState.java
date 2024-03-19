package state;

public class CheckingState extends State {
    /**
     * 提审活动
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void arraignment(String activityId, Enum<Status> currentStatus) {
        System.out.println("待审批状态， 不可重复提审!!!");
    }

    /**
     * 审批通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkPass(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Pass);
        System.out.println("活动审批通过完成");
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
        System.out.println("活动审批拒绝完成");
    }

    /**
     * 提审撤销
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkRevoke(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Editing);
        System.out.println("提审撤销完成");
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
        System.out.println("活动关闭成功");
    }

    /**
     * 活动开启
     *
     * @param activityId    活动ID
     * @param currentStatus 当期状态
     */
    @Override
    public void open(String activityId, Enum<Status> currentStatus) {
        System.out.println("非关闭活动不可开启!!!");
    }

    /**
     * 活动执行
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void doing(String activityId, Enum<Status> currentStatus) {
        System.out.println("待审批活动不可执行活动中的变更!!!");
    }
}

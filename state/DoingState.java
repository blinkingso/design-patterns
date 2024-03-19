package state;

public class DoingState extends State {
    /**
     * 提审活动
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void arraignment(String activityId, Enum<Status> currentStatus) {
        System.out.println("活动中， 只能关闭！！！");
    }

    /**
     * 审批通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkPass(String activityId, Enum<Status> currentStatus) {

        System.out.println("活动中， 只能关闭！！！");
    }

    /**
     * 审批拒绝
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkRefuse(String activityId, Enum<Status> currentStatus) {

        System.out.println("活动中， 只能关闭！！！");
    }

    /**
     * 提审撤销
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkRevoke(String activityId, Enum<Status> currentStatus) {

        System.out.println("活动中， 只能关闭！！！");
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
        System.out.println("活动关闭了");
    }

    /**
     * 活动开启
     *
     * @param activityId    活动ID
     * @param currentStatus 当期状态
     */
    @Override
    public void open(String activityId, Enum<Status> currentStatus) {

        System.out.println("活动中， 只能关闭！！！");
    }

    /**
     * 活动执行
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void doing(String activityId, Enum<Status> currentStatus) {
        System.out.println("活动执行中。。。。");
    }
}

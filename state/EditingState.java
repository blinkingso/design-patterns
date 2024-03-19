package state;

public class EditingState extends State {
    /**
     * 活动提审
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void arraignment(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Checking);
        System.out.println("活动提审成功!");
    }

    /**
     * 审批通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkPass(String activityId, Enum<Status> currentStatus) {
        System.out.println("编辑中, 审批通过 不可执行！！！");
    }

    /**
     * 审批拒绝
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkRefuse(String activityId, Enum<Status> currentStatus) {
        System.out.println("编辑中，审批拒绝 不可操作！！！");
    }

    /**
     * 提审撤销
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkRevoke(String activityId, Enum<Status> currentStatus) {
        System.out.println("编辑中， 提审撤销 不可操作！！！");
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
        System.out.println("非关闭活动不可开启！！！");
    }

    /**
     * 活动执行
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void doing(String activityId, Enum<Status> currentStatus) {
        System.out.println("编辑中， 活动不可执行变更！！！");
    }
}

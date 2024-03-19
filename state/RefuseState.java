package state;

public class RefuseState extends State {
    /**
     * 提审活动
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void arraignment(String activityId, Enum<Status> currentStatus) {
        System.out.println("审批拒绝的活动不能再次提审！！！");
    }

    /**
     * 审批通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkPass(String activityId, Enum<Status> currentStatus) {
        System.out.println("该活动无法在审核通过，请先撤审！！！");
    }

    /**
     * 审批拒绝
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void checkRefuse(String activityId, Enum<Status> currentStatus) {
        System.out.println("该活动已拒绝！！！");
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
        System.out.println("活动可重新编辑哦");
    }

    /**
     * 关闭活动
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     */
    @Override
    public void close(String activityId, Enum<Status> currentStatus) {
        System.out.println("撤审的活动无法关闭！！！");
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
        System.out.println("撤审的活动无法执行哦！！！");
    }
}

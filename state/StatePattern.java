package state;

/**
 * 状态模式： 状态流转 -> 活动状态
 * <---- cancel <-----------------
 * edit -> due_audit ---> audit ---> reject
 * pass               <---
 * active open ---> active ----> active closed
 */
public class StatePattern {
    public static void main(String[] args) {
        String activityId = "10001";
        ActivityService.init(activityId, Status.Editing);
        final ActivityContext context = new ActivityContext();
        context.arraignment(activityId, Status.Editing);
        context.checkPass(activityId, ActivityService.queryActivityStatus(activityId));
        context.doing(activityId, ActivityService.queryActivityStatus(activityId));
        context.close(activityId, ActivityService.queryActivityStatus(activityId));
        context.doing(activityId, ActivityService.queryActivityStatus(activityId));
        context.open(activityId, ActivityService.queryActivityStatus(activityId));
        context.doing(activityId, ActivityService.queryActivityStatus(activityId));
    }
}

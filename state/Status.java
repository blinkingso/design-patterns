package state;

/**
 * 活动状态
 */
public enum Status {
    // 创建编辑
    Editing, // 待审批
    Checking, // 审批通过（流转为活动中）
    Pass, // 审批拒绝， 可撤销到编辑状态
    Refuse, // 活动中
    Doing, // 活动关闭
    Closed, // 活动开启
    Opening
}

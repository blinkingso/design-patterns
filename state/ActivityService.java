package state;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActivityService {

    private static final Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<>();

    public static void init(String activityId, Enum<Status> status) {
        statusMap.put(activityId, status);
    }

    public static ActivityInfo queryActivityInfo(String activityId) {
        ActivityInfo info = new ActivityInfo();
        info.setActivityId(activityId);
        info.setActivityName("打卡领金豆");
        info.setStatus(statusMap.get(activityId));
        info.setStartTime(new Date());
        info.setEndTime(new Date());
        return info;
    }

    public static Enum<Status> queryActivityStatus(String activityId) {
        return statusMap.get(activityId);
    }

    public static synchronized void execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(activityId))) return;
        statusMap.put(activityId, afterStatus);
    }
}

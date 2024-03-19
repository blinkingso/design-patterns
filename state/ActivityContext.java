package state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActivityContext {

    private final Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<>();

    public ActivityContext() {
        stateMap.put(Status.Checking, new CheckingState());
        stateMap.put(Status.Editing, new EditingState());
        stateMap.put(Status.Refuse, new RefuseState());
        stateMap.put(Status.Pass, new PassState());
        stateMap.put(Status.Opening, new OpeningState());
        stateMap.put(Status.Closed, new ClosedState());
    }

    public void arraignment(String activityId, Enum<Status> currentStatus) {
        stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    public void checkPass(String activityId, Enum<Status> currentStatus) {
        stateMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    public void checkRefuse(String activityId, Enum<Status> currentStatus) {
        stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    public void checkRevoke(String activityId, Enum<Status> currentStatus) {
        stateMap.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    public void close(String activityId, Enum<Status> currentStatus) {
        stateMap.get(currentStatus).close(activityId, currentStatus);
    }

    public void open(String activityId, Enum<Status> currentStatus) {
        stateMap.get(currentStatus).open(activityId, currentStatus);
    }

    public void doing(String activityId, Enum<Status> currentStatus) {
        stateMap.get(currentStatus).doing(activityId, currentStatus);
    }
}

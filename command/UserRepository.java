package command;

public interface UserRepository {
    void save(String userId);

    void update(String userId);

    String query();
}

package command;

public class UserRepositoryImpl implements UserRepository {
    @Transactional
    @Override
    public void save(String userId) {
        System.out.println("保存用户: " + userId);
    }

    @Transactional
    @Override
    public void update(String userId) {
        System.out.println("更新用户： " + userId);
    }


    @Override
    public String query() {
        System.out.println("用户查询成功");
        return "u1000";
    }
}

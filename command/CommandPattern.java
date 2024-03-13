package command;

import java.lang.reflect.Proxy;

/**
 * 命令模式： 这里通过模拟数据库事务的提交和回滚做案例， 配合动态代理模式。
 */
public class CommandPattern {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserRepository proxy = (UserRepository) Proxy.newProxyInstance(userRepository.getClass().getClassLoader(), userRepository.getClass().getInterfaces(), new TransactionProxy(userRepository));
        proxy.save("u1000");
        System.out.println("======================================");
        proxy.update("u1001");
        System.out.println("======================================");
        proxy.query();
    }
}

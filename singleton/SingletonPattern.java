package singleton;

/**
 * 单例模式： 一般用于工具类, 推荐方式， 静态内部类或者枚举类型
 */
public class SingletonPattern {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().getUser());
        System.out.println(Singleton.getInstance().getUser());
    }
}

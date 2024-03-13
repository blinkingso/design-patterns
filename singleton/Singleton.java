package singleton;

public class Singleton {
    private Singleton() {
        System.out.println("Single instance initialized.");
    }

    private static class Inner {
        static {
            System.out.println("Inner loaded.");
        }
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Inner.INSTANCE;
    }

    public String getUser() {
        return "mu";
    }
}

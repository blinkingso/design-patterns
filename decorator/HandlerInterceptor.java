package decorator;

public interface HandlerInterceptor {
    boolean preHandle(String request, String response, Object handler);

    default boolean postHandle(String request, String response, Object handler) {
        return true;
    }
}

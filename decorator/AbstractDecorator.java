package decorator;

public abstract class AbstractDecorator implements HandlerInterceptor {
    private final HandlerInterceptor interceptor;

    protected AbstractDecorator(HandlerInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return interceptor.preHandle(request, response, handler);
    }
}

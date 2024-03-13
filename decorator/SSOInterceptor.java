package decorator;

public class SSOInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        String key = request.substring(1, 8);
        return "success".equals(key);
    }
}

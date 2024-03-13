package decorator;

import java.util.concurrent.ConcurrentHashMap;

public class LoginSSODecorator extends AbstractDecorator {
    private static final ConcurrentHashMap<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("hoho", "queryUserInfo");
    }

    protected LoginSSODecorator(HandlerInterceptor interceptor) {
        super(interceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) return false;

        String key = request.substring(8);
        final String method = authMap.get(key);
        return "queryUserInfo".equals(method);
    }
}

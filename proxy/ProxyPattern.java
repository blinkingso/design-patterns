package proxy;

import java.lang.reflect.Proxy;

/**
 * 代理模式： jdk基于接口的动态代理或者cglib基于MethodInterceptor的继承
 * java assistant 静态代理。。。。等等
 */
public class ProxyPattern {
    public static void main(String[] args) {
        HttpRequestHandler handler = new HttpRequestHandler();
        RequestHandler handlerProxy = (RequestHandler) Proxy.newProxyInstance(handler.getClass().getClassLoader(), handler.getClass().getInterfaces(), new HttpRequestHandlerProxy(handler));
        boolean status = handlerProxy.handle("success", "response");
        System.out.println("status: " + status);
    }
}

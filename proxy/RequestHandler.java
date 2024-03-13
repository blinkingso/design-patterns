package proxy;

/**
 * 请求处理器
 */
public interface RequestHandler {

    boolean handle(String request, String response);
}

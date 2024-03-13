package proxy;

public class HttpRequestHandler implements RequestHandler {
    @Override
    public boolean handle(String request, String response) {
        return "success".equals(request);
    }
}

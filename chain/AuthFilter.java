package chain;

public class AuthFilter implements Filter {

    @Override
    public boolean doFilter(String request, String response, FilterChain filterChain) {
        System.out.println("AuthFilter start");
        if (null != request && request.contains("suc")) {
            boolean result = filterChain.doFilter(request, response);
            System.out.println("AuthFilter end");
            return result;
        }
        System.out.println("AUthFilter auth filed, filter chain terminated.");
        System.out.println("AuthFilter end");
        return false;
    }
}

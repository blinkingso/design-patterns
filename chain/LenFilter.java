package chain;

public class LenFilter implements Filter {
    @Override
    public boolean doFilter(String request, String response, FilterChain filterChain) {
        System.out.println("LenFilter start");
        if (null != request) {
            if (request.length() > 8) {
                boolean result = filterChain.doFilter(request, response);
                System.out.println("LenFilter end");
                return result;
            }
        }
        System.out.println("LenFilter failed for len < 8");
        System.out.println("LenFilter End");
        return false;
    }
}

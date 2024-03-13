package chain;

public interface Filter {
    boolean doFilter(String request, String response, FilterChain filterChain);
}

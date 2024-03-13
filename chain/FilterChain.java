package chain;


public interface FilterChain {
    boolean doFilter(String request, String response);

    void addFilter(Filter filter);
}

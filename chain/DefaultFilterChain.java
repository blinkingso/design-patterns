package chain;

import java.util.LinkedList;

public class DefaultFilterChain implements FilterChain {
    private final LinkedList<Filter> filters;
    private int index = -1;

    public DefaultFilterChain() {
        this.filters = new LinkedList<>();
    }

    @Override
    public boolean doFilter(String request, String response) {
        index++;
        int len = filters.size();
        if (index < len) {
            return this.filters.get(index).doFilter(request, response, this);
        }
        return true;
    }

    @Override
    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }
}

package iterator;

public interface Collection<E> {

    void add(E element);

    boolean remove(E element);

    Iterator iter();

    int size();
}

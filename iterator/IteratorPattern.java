package iterator;

/**
 * 迭代器模式
 */
public class IteratorPattern {
    public static void main(String[] args) {
        final IntLinkList list = new IntLinkList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        boolean remove = list.remove(3);
        assert remove;
        final Iterator iter = list.iter();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}

package iterator;

import static iterator.IntLinkList.*;

public class Iterator implements Iterable<Integer> {
    Node head;
    int length;
    int pos;

    Iterator(Node head, int length) {
        this.head = head;
        this.length = length;
    }

    @Override
    public boolean hasNext() {
        return pos < length;
    }

    @Override
    public Integer next() {
        this.pos += 1;
        if (null == head) {
            return null;
        }
        int value = this.head.value;
        this.head = this.head.next;
        return value;
    }
}

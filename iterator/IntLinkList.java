package iterator;

public class IntLinkList implements Collection<Integer> {
    Node tail;
    Node head;
    int length;

    @Override
    public void add(Integer element) {
        assert element != null;
        Node newNode = new Node(element);
        if (null == this.tail) {
            this.tail = newNode;
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length += 1;
    }

    @Override
    public boolean remove(Integer element) {
        if (null == this.head) {
            return false;
        }
        Node current = this.head;
        Node prev = this.head;
        while (null != current && current.value != element) {
            prev = current;
            current = current.next;
        }
        if (null != current) {
            // find the value
            prev.next = current.next;
            this.length -= 1;
            return true;
        }
        return false;
    }

    @Override
    public Iterator iter() {
        return new Iterator(this.head, this.length);
    }

    @Override
    public int size() {
        return this.length;
    }


    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this(value, null);
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

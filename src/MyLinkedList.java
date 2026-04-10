public class MyLinkedList<T> {
    MyNode<T> head;
    private MyNode<T> tail;
    private int size = 0;

    private static class MyNode<E> {
        E data;
        MyNode<E> next;

        MyNode(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addhead(T newitem) {
        MyNode<T> newNode = new MyNode<>(newitem);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addtail(T newitem) {
        MyNode<T> newNode = new MyNode<>(newitem);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void deltail() {
        if (head == null) {
            System.out.println("there is no elements");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        else {
            MyNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
    }

    public void delhead() {
        if (head == null) {
            System.out.println("No elements");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void getall() {
        if (head == null) {
            System.out.println("No elements");
            return;
        }
        if (head == tail) {
            System.out.println(head);
            return;
        }
        MyNode<T> current = head;
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.next;
        }
        System.out.println();
    }

    public void find(T item) {
        MyNode<T> node = new MyNode<>(item);
        if (head == null) {
            System.out.println("No elements");
            return;
        }
        MyNode<T> current = head;
        int i = 0;
        while(current != null) {
            if (current.equals(node)) {
                System.out.println(i);
                return;
            }
            current = current.next;
            i++;
        }
    }

    public void append(T item, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index Out of Bounds");
            return;
        }
        if (index == 0) {
            addhead(item);
            return;
        }
        if (index == size) {
            addtail(item);
            return;
        }
        MyNode<T> node = new MyNode<>(item);
        MyNode<T> current = head;
        int i = 0;
        while (current != null) {
            if (i == index - 1) {
                node.next = current.next;
                current.next = node;
                break;
            }
            current = current.next;
            i++;
        }
        size++;
    }

    public void removebyid(T item) {
        MyNode<T> current = head;
        if (head.data.equals(item)) {
            head = head.next;
            size--;
            return;
        }
        while (current.next != null) {
            if (current.next.data.equals(item)) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void union(MyLinkedList<T> other) {
        if (other.head == null) {
            System.out.println("Empty list");
            return;
        }
        if (this.head == null) {
            this.head = other.head;
            this.tail = other.tail;
            this.size = other.size;
            return;
        }
        this.tail.next = other.head;
        this.tail = other.tail;
        this.size += other.size;
    }

    public void reverse() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        MyNode<T> current = head;
        MyNode<T> prev = null;
        MyNode<T> nextNode;
        MyNode<T> oldhead = head;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        tail = oldhead;
        head = prev;
    }

    public void onlyODD() {
        if (isEmpty()) { throw new RuntimeException("Empty"); }
        while (head != null && isEven(head.data)) {
            delhead();
        }
        MyNode<T> current = head;
        while (current != null && current.next != null) {
            if (isEven(current.next.data)) {
                current.next = current.next.next;
                size--;
                if (current.next == null) {
                    tail = current;
                }
            }
            current = current.next;
        }
    }

    public boolean isEven(T data) {
        if (isEmpty()) { throw new RuntimeException("Empty"); }
        if (data instanceof Number) {
            return ((Number) data).longValue() % 2 == 0;
        }
        return false;
    }
}
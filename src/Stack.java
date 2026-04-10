public class Stack<T> {
    private class Node<T> {
        private T data;
        private Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> top;

    public void appends(T data) {
        Node newnode = new Node(data);
        newnode.next = top;
        top = newnode;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T pop() {
        if (isEmpty()) { throw new RuntimeException("Stack is empty"); }
        T data = top.data;
        top = top.next;
        return data;
    }

    public void pop(T data) {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Node<T> current = top;
        if (current.data.equals(data)) {
            current.data = null;
            top = current.next;
            return;
        }
        while (current != null && current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void getstack() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Node<T> current = top;
        while (current != null) {
            System.out.printf("%s ", current.data, '\n');
            current = current.next;
        }
    }

    public void clear() {
        top = null;
    }

    public double stackavg() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        double sum = 0;
        double i = 0;
        Node<T> current = top;
        while (current != null) {
            if (current.data instanceof Number) {
                sum += ((Number) current.data).doubleValue();
                i++;
                current = current.next;
            }
        }
        return (sum/i);
    }

    public void stackmedium() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        double avg = stackavg();
        while (top != null && ((Number)top.data).doubleValue() < avg) {
            top = top.next;
        }
        Node<T> current = top;
        while (current != null && current.next != null) {
            if (((Number)current.next.data).doubleValue() < avg) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
    }
}

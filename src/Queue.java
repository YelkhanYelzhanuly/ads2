public class Queue<T extends Comparable<T>>{
    private MyLinkedList<T> list;

    public Queue() {
        this.list = new MyLinkedList<>();
    }

    public void enqueue(T data) {
        list.addtail(data);
    }

    public void dequeue() {
        if (list.isEmpty()) {
            throw new RuntimeException("Empty");
        }
        list.delhead();
    }

    public void clearqueue() {
        list.clear();
    }

    public void ODD() {
        list.onlyODD();
    }
}

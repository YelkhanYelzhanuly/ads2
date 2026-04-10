public class HashTable {
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new Node[size];
    }

    private int hash(int key) {
        return Math.abs(key) % size;
    }

    // 7. Добавление элемента
    public void put(int key, int value) {
        int index = hash(key);
        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    // 7. Удаление элемента
    public void remove(int key) {
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) table[index] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Вывод на экран
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            Node curr = table[i];
            while (curr != null) {
                System.out.print("[" + curr.key + ":" + curr.value + "] -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    // 8. Сумма элементов
    public int sum() {
        int total = 0;
        for (Node bucket : table) {
            Node curr = bucket;
            while (curr != null) {
                total += curr.value;
                curr = curr.next;
            }
        }
        return total;
    }

    // 9. Max и Min
    public void printMinMax() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean hasData = false;

        for (Node bucket : table) {
            Node curr = bucket;
            while (curr != null) {
                if (curr.value < min) min = curr.value;
                if (curr.value > max) max = curr.value;
                hasData = true;
                curr = curr.next;
            }
        }
        if (hasData) System.out.println("Min: " + min + ", Max: " + max);
        else System.out.println("Table is empty");
    }

    // 10. Четные и нечетные
    public void printEvenOdd() {
        System.out.print("Even: ");
        iterateAndPrint(true);
        System.out.print("\nOdd: ");
        iterateAndPrint(false);
        System.out.println();
    }

    private void iterateAndPrint(boolean even) {
        for (Node bucket : table) {
            Node curr = bucket;
            while (curr != null) {
                if ((curr.value % 2 == 0) == even) System.out.print(curr.value + " ");
                curr = curr.next;
            }
        }
    }
}

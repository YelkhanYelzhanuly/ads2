import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> node = new Stack<>();
        node.appends(15);
        node.appends(25);
        node.appends(35);
        node.getstack();
        System.out.println();

        Node root = new Node(50, 500);
        root.insert(root, 30, 300);
        root.insert(root, 70, 700);
        root.printTree(root);
        root.deletenode(root, 30);
        System.out.println();
        root.printTree(root);
        System.out.println(root.getHeight(root));
    }
}
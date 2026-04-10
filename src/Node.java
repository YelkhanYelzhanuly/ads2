import static java.lang.Math.*;

public class Node {
    private int key;
    private int value;
    private Node left;
    private Node right;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public boolean isEmpty(Node root) {
        return root == null;
    }

    public Node clearTree() {
        return null;
    }

    public int getHeight(Node node) {
        if (isEmpty(node)) { return 0; }
        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);
        return max(leftH, rightH) + 1;

    }

    public void insert(Node node, int key, int value) {
        if (key < node.key) {
            if (node.left == null) {
                node.left = new Node(key, value);
            } else {
                insert(node.left, key, value);
            }
        } else if (key > node.key) {
            if (node.right == null) {
                node.right = new Node(key, value);
            } else {
                insert(node.right, key, value);
            }
        }
    }

    public Node getMAXNode(Node node) {
        if (node == null) return null;
        if (node.right == null) return node;
        return getMAXNode(node.right);
    }

    public Node deletenode(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = deletenode(node.left, key);
        } else if (key > node.key) {
            node.right = deletenode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node maxNode = getMAXNode(node.left);
            node.key = maxNode.key;
            node.value = maxNode.value;
            node.left = deletenode(node.left, maxNode.key);
        }
        return node;
    }

    public void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        System.out.printf("%s ", node.value);
        printTree(node.right);
    }
}

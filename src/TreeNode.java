public class TreeNode<T> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    private TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    private class QueueNode{
        TreeNode<T> node;
        QueueNode next;
        public QueueNode(TreeNode node) { this.node = node; }
    }

    public void insert() {

    }
}

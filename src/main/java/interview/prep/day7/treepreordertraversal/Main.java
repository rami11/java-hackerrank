package interview.prep.day7.treepreordertraversal;

public class Main {

    private static <T> void preOrderTraversal(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static <T extends Comparable<T>> TreeNode<T> insert(TreeNode<T> root, T data) {
        if (root == null) {
            return new TreeNode<>(data);
        }
        TreeNode<T> current;
        if (data.compareTo(root.data) <= 0) {
            current = insert(root.left, data);
            root.left = current;
        } else {
            current = insert(root.right, data);
            root.right = current;
        }
        return root;
    }
}

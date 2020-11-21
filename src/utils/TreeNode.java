package utils;

public class TreeNode<T> {

    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

}

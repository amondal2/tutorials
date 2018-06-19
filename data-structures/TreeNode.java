// tree implementation in java
import java.util.ArrayList;
import java.util.List;

public class TreeNode<T>{
    private T data = null;
    private List<TreeNode> children = new ArrayList<>();
    private TreeNode parent = null;

    public TreeNode(T data) {
        this.data = data;
    }

    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        TreeNode<T> newChild = new TreeNode<>(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChildren(List<TreeNode> children) {
        for(TreeNode t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(5);
        assert root.isRoot() == true;
        root.addChild(10);
        assert root.getChildren().size() == 1;
        root.addChild(new TreeNode(5));
        assert root.getChildren().size() == 2;
        TreeNode<Integer> child = new TreeNode(14);
        child.setParent(root);
        assert root.getChildren().size() == 3;

    }
}

public class Tree<T extends Comparable<T>> {

    private TreeNode root;
    private int size;

    private class TreeNode {
        T val;
        TreeNode left;
        TreeNode right;

        TreeNode(T obj, TreeNode l, TreeNode r) {
            val = obj;
            left = l;
            right = r;
        }

        TreeNode(T obj) {
            val = obj;
            left = right = null;
        }

        void visit() {
            System.out.println(" " + val + " ");
        }


    }

    public Tree() {
        root = null;
        size = 0;
    }

    public void insert(T obj) {
        if (root == null) {
            root = new TreeNode(obj);
        } else {
            TreeNode curr = root;
            TreeNode par;
            while (true) {
                par = curr;
                if (obj.compareTo(curr.val) < 0) {
                    curr = curr.left;
                    if (curr == null) {
                        par.left = new TreeNode(obj);
                        return;
                    }
                } else {
                    curr = curr.right;
                    if (curr == null) {
                        par.right = new TreeNode(obj);
                        return;
                    }
                }
            }
        }
    }

    public void preorder(TreeNode n) {
        n.visit();
        if (n.left != null) {
            preorder(n.left);
        }
        if (n.right != null) {
            preorder(n.right);
        }
    }

    public void inorder(TreeNode n) {
        if (n.left != null) {
            inorder(n.left);
        }
        n.visit();
        if (n.right != null) {
            inorder(n.right);
        }
    }

    public void postorder(TreeNode n) {
        if (n.left != null) {
            postorder(n.left);
        }
        if (n.right != null) {
            postorder(n.right);
        }
        n.visit();
    }



}

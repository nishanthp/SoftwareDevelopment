/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;


/**
 * TODO Administrator (May 29, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class BT {

    void preorder(final Node root) {
        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }


    void inorder(final Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    void postorder(final Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);

        }
    }

    int size(final Node root) {
        if (root != null) {
            final int left = size(root.left);
            final int right = size(root.right);
            return left + right + 1;

        } else {
            return 0;
        }

    }

    int height(final Node root) {
        if (root != null) {
            final int left = height(root.left);
            final int right = height(root.right);
            return 1 + Math.max(left, right);

        } else {
            return 0;
        }

    }


    int heightDiff(final Node root) {
        if (root != null) {
            final int left = heightDiff(root.left);
            final int right = heightDiff(root.right);
            final int heightDiff = left - right;
            if (Math.abs(heightDiff) > 1) {
                return -1;
            } else {
                return 1 + Math.max(left, right);

            }

        } else {
            return 0;
        }

    }

}


class Node {

    Node left;
    Node right;
    int data;

    Node(final int d,
         final Node l,
         final Node r) {
        this.data = d;
        this.left = l;
        this.right = r;
    }
}

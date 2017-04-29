/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;


/**
 * TODO Administrator (May 29, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class AVL {

    Node1 leftRotate(final Node1 root) {
        final Node1 newNode = root.right;
        root.right = root.right.left;
        newNode.left = root;
        root.height = setHeight(root);
        newNode.height = setHeight(newNode);
        return newNode;

    }

    Node1 rightRotate(final Node1 root) {
        final Node1 newNode = root.left;
        root.left = root.left.right;
        newNode.right = root;
        root.height = setHeight(root);
        newNode.height = setHeight(newNode);
        return newNode;

    }

    int height(final Node1 root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    int setHeight(final Node1 root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(root.left != null ? root.left.height : 0, root.right != null ? root.right.height : 0);

    }

    int balance(final Node1 leftHeight,
                final Node1 rightHeight) {
        return height(leftHeight) - height(rightHeight);
    }

    Node1 insert(Node1 root,
                 final int data) {

        if (root == null) {
            return new Node1(data);

        }
        if (root.data <= data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        final int balance = balance(root.left, root.right);
        if (balance > 1) {
            if (height(root.left.left) >= height(root.left.right)) {
                rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        } else if (balance < -1) {
            if (height(root.right.right) >= height(root.right.left)) {
                root = leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }

        } else {
            root.height = setHeight(root);
        }
        return root;
    }
}


class Node1 {

    Node1 left;
    Node1 right;
    int data;
    int height;

    Node1() {

    }

    Node1(final int dat) {
        this.data = dat;
    }

    Node1(final int d,
          final Node1 l,
          final Node1 r) {
        this.data = d;
        this.left = l;
        this.right = r;
    }
}

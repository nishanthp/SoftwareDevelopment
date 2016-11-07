/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * TODO Administrator (May 10, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class BFS {

    public void createGraph() {
        final ArrayList<Node> list = new ArrayList<BFS.Node>();

        final BFS.Node root0 = new Node(0);
        final BFS.Node root8 = new Node(8);
        final BFS.Node root4 = new Node(4);
        final BFS.Node root1 = new Node(1);
        final BFS.Node root2 = new Node(2);
        final BFS.Node root5 = new Node(5);
        final BFS.Node root6 = new Node(6);
        final BFS.Node root7 = new Node(7);
        final BFS.Node root3 = new Node(3);


        root0.addAdjacentNodes(root8);
        root0.addAdjacentNodes(root3);
        list.add(root0);
        root8.addAdjacentNodes(root4);
        list.add(root8);
        /*
         * root4.addAdjacentNodes(root3); root4.addAdjacentNodes(root8);
         */list.add(root4);
        // root1.addAdjacentNodes(root7);
        // root1.addAdjacentNodes(root0);
        list.add(root1);
        root2.addAdjacentNodes(root5);
        root2.addAdjacentNodes(root7);
        list.add(root2);
        root5.addAdjacentNodes(root6);
        list.add(root5);
        // root6.addAdjacentNodes(root5);
        list.add(root6);
        /*
         * root7.addAdjacentNodes(root2); root7.addAdjacentNodes(root1);
         */
        root3.addAdjacentNodes(root2);
        root3.addAdjacentNodes(root1);


        // bfs(root0);
        dfs(root0);

    }

    public void bfs(final Node root) {
        final Queue<Node> q = new LinkedList<Node>();
        root.isVisited = true;
        System.out.println("ROOT NODE" + root.data);
        q.add(root);
        while (!q.isEmpty()) {
            final Node current = q.remove();
            for (final Node n : current.getAdjacentNode()) {
                if (!n.isVisited) {
                    n.isVisited = true;
                    System.out.println(n.data);
                    q.add(n);
                }
            }
        }

    }

    public void dfs(final Node root) {
        if (root == null) {
            return;
        }
        if (root.isVisited == false) {
            root.isVisited = true;
            System.out.println(root.data);
        }
        for (final Node n : root.getAdjacentNode()) {
            if (!n.isVisited) {
                System.out.println(n.data);
                n.isVisited = true;
                dfs(n);
            }
        }

    }

    public class Node {

        ArrayList<Node> adjacent = new ArrayList<Node>();
        int data;
        Boolean isVisited = false;

        Node(final int d) {
            this.data = d;
        }

        public void addAdjacentNodes(final Node n) {

            this.adjacent.add(n);
        }

        public ArrayList<Node> getAdjacentNode() {

            return this.adjacent;
        }
    }

}

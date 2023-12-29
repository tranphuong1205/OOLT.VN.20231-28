package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {


    public void DFS(Node rootNode) {
        if (rootNode == null) return;

        visit(rootNode);
        DFS(rootNode.getLeftChild());
        DFS(rootNode.getRightChild());
    }

    public void BFS(Node rootNode) {
        if (rootNode == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visit(current);

            if (current.getLeftChild() != null) {
                queue.add(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                queue.add(current.getRightChild());
            }
        }
    }

    private void visit(Node node) {
        System.out.print(node.getValue() + " ");
    }
}

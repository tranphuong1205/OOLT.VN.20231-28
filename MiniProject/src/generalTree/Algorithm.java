package generalTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Algorithm {

    public void DFS(Node rootNode) {
        if (rootNode == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            visit(node);

            for (Node child : node.getChildren()) {
                stack.push(child);
            }
        }
    }
    
    public void BFS(Node rootNode) {
        if (rootNode == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visit(node);

            for (Node child : node.getChildren()) {
                queue.add(child);
            }
        }
    }

    private void visit(Node node) {
        System.out.print(node.getValue() + " ");
    }
}

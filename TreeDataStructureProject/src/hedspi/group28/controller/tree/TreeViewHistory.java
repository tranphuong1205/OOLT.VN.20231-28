package hedspi.group28.controller.tree;

import javafx.scene.layout.Pane;
import java.util.Stack;

public class TreeViewHistory {
    private Stack<Pane> history;
    private Stack<Pane> forwardHistory;

    public TreeViewHistory() {
        history = new Stack<>();
        forwardHistory = new Stack<>();
    }

    public void addToHistory(Pane pane) {
        history.push(pane);
        forwardHistory.clear(); // Clear forward history when a new pane is added
    }

    public Pane navigateBack() {
        if (!history.isEmpty()) {
            forwardHistory.push(history.peek());
            return history.pop();
        }
        return null;
    }

    public Pane navigateForward() {
        if (!forwardHistory.isEmpty()) {
            history.push(forwardHistory.peek());
            return forwardHistory.pop();
        }
        return null;
    }
}

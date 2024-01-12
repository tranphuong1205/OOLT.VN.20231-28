package hedspi.group28.controller.tree;

import javafx.scene.layout.Pane;
import java.util.LinkedList;
import java.util.ArrayList;
import javafx.scene.Node;

public class TreeViewHistory {
    private LinkedList<PaneWithChildren> history;
    private int currentIndex;

    public TreeViewHistory() {
        history = new LinkedList<>();
        currentIndex = -1;
    }

    public void addToHistory(Pane pane) {
        PaneWithChildren paneWithChildren = new PaneWithChildren(pane);
        history.addLast(paneWithChildren);
        currentIndex = history.size() - 1;
    }

    public Pane navigateBack() {
        if (currentIndex > 0) {
            currentIndex--;
            return history.get(currentIndex).getPane();
        }
        return null;
    }

    public Pane navigateForward() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            return history.get(currentIndex).getPane();
        }
        return null;
    }

    public void clearHistory() {
        history.clear();
        currentIndex = -1;
    }

    private static class PaneWithChildren {
        private final Pane pane;
        private final ArrayList<Node> children;

        public PaneWithChildren(Pane pane) {
            this.pane = pane;
            this.children = new ArrayList<>(pane.getChildren());
        }

        public Pane getPane() {
            return pane;
        }

        public ArrayList<Node> getChildren() {
            return children;
        }
    }
}

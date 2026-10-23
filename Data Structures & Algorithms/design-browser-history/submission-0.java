class BrowserHistory {
    private final LinkedList<String> history = new LinkedList<>();
    private int currentIndex;

    public BrowserHistory(String homepage) {
        history.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        // we need to remove all forward history
        while (currentIndex < history.size() - 1) {
            history.removeLast();
        }

        // we add and increment
        history.add(url);
        currentIndex += 1;
    }

    public String back(int steps) {
        while (steps > 0 && currentIndex > 0) {
            steps--;
            currentIndex--;
        }

        return history.get(currentIndex);
    }

    public String forward(int steps) {
        while (steps > 0 && currentIndex < history.size() - 1) {
            steps--;
            currentIndex++;
        }

        return history.get(currentIndex);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
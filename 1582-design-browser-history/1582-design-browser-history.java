class BrowserHistory {

    public static class Node {
        public String data;
        public Node next;
        public Node before;

        public Node(String data) {
            this.data = data;
        }
    }

    Node start;
    Node current;

    public BrowserHistory(String homepage) {
        Node node = new Node(homepage);
        start = node;
        current = node;
    }

    public void visit(String url) {
        Node node = new Node(url);
        current.next = node;
        node.before = current;
        current = node;
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (current.before == null)
                return current.data;

            current = current.before;
        }

        return current.data;
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (current.next == null)
                return current.data;

            current = current.next;
        }
        return current.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

/**
브라우저 -> homepage 에서 시작 , 다른 url 방문 가능, steps 만큼 방문 기록에서 이동 가능 

BrowserHistory  구현하기 

생성자 : 파라미터로 홈페이지 받아서 초기화 




 */
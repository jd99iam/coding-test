class Solution {
    /**
    n 개 node로 구성된 네트워크를 얻는다. 
    node는 1~n 로 번호가 매겨져 있다.
    
    times 도 주어진다. 
    u -> v 로 가는데 필요한 시간 w 가 time[i] =  [u,v,w] 형태로 주어진다.  
    
    k 에서 시작해서 signal을 보낼 때 n 개의 모든 node 에서 신호를 수신하는데 필요한 최소 시간을 구하라. 
    만약 모든 n개의 node에 도달하는게 불가능하다면 -1을 리턴하라. 
    
    # 
    1 <= k <= n <= 100
    노드는 최대 10^2 개
    times.length 는 최대 6000 개 
    따라서 다익스트라 사용 시  O(6000*log(10^2)) 
    log(10^2) 가 6 - 7 사이니까 7이라고 치면 
    42000 -> 10^8 보다 작으니까 다익스트라로 풀어도 된다. 
    
    # 
    먼저 Node 클래스를 만든다 -> (인덱스, 비용)
    
    time 이 간선을 쭉 담고 있다. 
    time을 순회하면서 그래프를 만든다 
    HashMap<Integer, List<Node>> 
    시작 노드 인덱스, 도착 노드 (인덱스, 비용)
    
    k 에서 시작해서 다익스트라를 한다. 
    HashMap<Integer, Integer> cost 
    에 비용을 담는다. 
    
    끝나고 cost.size() == n 인지 확인 
    맞으면 cost 에서 최고비용 찾아서 리턴 
    아니면 -1 리턴 
    */
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];

            List<Node> adjNodes = graph.get(time[0]);

            if (adjNodes == null) {
                List<Node> newList = new ArrayList<>();
                newList.add(new Node(time[1], time[2]));
                graph.put(time[0], newList);
            } else {
                adjNodes.add(new Node(time[1], time[2]));
            }
        }

        return dijkstra(k, graph, n);
    }

    public int dijkstra(int start, HashMap<Integer, List<Node>> graph, int n) {
        PriorityQueue<Node> heap = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
        heap.offer(new Node(start, 0));

        HashMap<Integer, Integer> costs = new HashMap<>();

        while (!heap.isEmpty()) {
            Node current = heap.poll();
            if (!costs.containsKey(current.index)) {
                costs.put(current.index, current.cost);
                List<Node> adjNodes = graph.get(current.index);
                if (adjNodes != null) {
                    for (Node adjNode : adjNodes) {
                        heap.offer(new Node(adjNode.index, adjNode.cost + current.cost));
                    }
                }
            }
        }

        if (costs.size() != n) {
            return -1;
        }

        int max = -1;
        for (Integer index : costs.keySet()) {
            int cost = costs.get(index);
            if (cost > max)
                max = cost;
        }
        return max;

    }

    public class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
class Solution {
    /**
    n * n  grid 가 주어짐
    좌상단 -> 우하단 최단경로의 길이를 구하라. 길이는 거쳐 간 칸의 수다. 
    이 때 0으로만 갈 수 있고 상하좌우대각선 8방향 가능하다.
    
    # 시간복잡도 
    n <= 10^2 니까 칸수는 최대 10^4 이므로 순회 O(n)은 괜찮다. 
    
    # 어떻게 풀까 ? 
    bfs 로 8방향 노드 큐에 넣기, 이 때 거리 d도 같이 넣기
    
    
    
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;

        return bfs(grid);
    }

    public int bfs(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 1));
        int[] dx = new int[] { 0, 0, 1, 1, 1, -1, -1, -1 };
        int[] dy = new int[] { 1, -1, 0, 1, -1, 0, 1, -1 };

        while (!q.isEmpty()) {
            Node current = q.poll();
            int x = current.x;
            int y = current.y;
            int d = current.d;

            if (x == n - 1 && y == n - 1 && grid[x][y] == 0)
                return d;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[i];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == false && grid[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny, d + 1));
                    }
                }
            }
        }

        return -1;
    }

    public class Node {
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
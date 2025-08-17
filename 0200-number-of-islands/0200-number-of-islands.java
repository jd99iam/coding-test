/*
M X N  grid 가 주어진다 
grid 는 1 (땅) 0 (물) 로 구성
섬의 개수를 반환하라 

섬 : 4면 (상하좌우) 이 물로 둘러쌓인 땅

# 시간복잡도
m,n <= 300 으로 최대 90000칸 = 약 10^5 으로 순회 O(n) 가능 

# 어떻게 풀까 ? 
bfs : 
0,0 에서 시작해서 1인 노드를 찾으면 상하좌우 인접노드 체크하면서 1이면 큐에 넣으면서 진행 
bfs 를 진행하다가 끝나면 거기가 섬 1개인 것이다. 

다시 grid를 탐색하면서 1을 발견하면 bfs 
이 때 visited에 없는 경우에만 시작해야 한다. 

이렇게 해서 bfs를 n번 하게 되면 n개의 섬이 있는 것이다. 
 */
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 방문 여부 확인용 
        boolean[][] visited = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    bfs(i, j, grid, visited);
                    count +=1;
                }
            }
        }

        return count;
    }

    public void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.offer(new Node(i, j));

        while (!q.isEmpty()) {
            Node current = q.poll();
            int x = current.x;
            int y = current.y;

            // 상
            if (x - 1 >= 0 && grid[x - 1][y] == '1' && visited[x-1][y] == false) {
                q.offer(new Node(x - 1, y));
                visited[x-1][y] = true;
            }
            // 하
            if (x + 1 < grid.length && grid[x + 1][y] == '1' && visited[x+1][y] == false) {
                q.offer(new Node(x + 1, y));
                visited[x+1][y] = true;
            }
            // 좌
            if (y - 1 >= 0 && grid[x][y - 1] == '1' && visited[x][y-1] == false) {
                q.offer(new Node(x, y - 1));
                visited[x][y-1] = true;
            }
            // 우 
            if (y + 1 < grid[0].length && grid[x][y + 1] == '1' && visited[x][y+1] == false) {
                q.offer(new Node(x, y + 1));
                visited[x][y+1] = true;
            }
        }
    }

    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
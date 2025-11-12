
/**

가중치 없는 최단거리 문제이므로 bfs 사용 
시간복잡도는 O(N), N 최대 10^4이므로 문제 X 

visited 2차원 배열 
- 방문하지 않은 곳 : -1 (생성 후 -1로 fill)
- 방문한 곳 : level 값 (이동 거리)

4방향 표현 위해 dx, dy 배열 사용 

**/

import java.util.*;


class Solution {
    
    private static class Node {
        int x;
        int y;
        
        public Node(int x, int y, int level){
            this.x = x; 
            this.y = y; 
        }
    }
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps){
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] visited = new int[n][m];
        
        for (int i=0; i<n; i++){
                  Arrays.fill(visited[i],-1);
        }

        q.offer(new Node(0,0,1));
        visited[0][0] = 1;
        
        // 4방향 표현 위함
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
                
        while (!q.isEmpty()){
            Node current = q.poll();
            int x = current.x;
            int y = current.y;
            int l = visited[y][x];
            
            
            for (int i=0; i<4; i++){
                int nX = x+dx[i];
                int nY = y+dy[i];
                int nL = l+1;
                
                if (checkValid(nX,m) && checkValid(nY, n) && visited[nY][nX] == -1 && maps[nY][nX]==1){
                    visited[nY][nX] = nL;
                    q.offer(new Node(nX,nY,nL));
                }   
            }
        }
          
        return visited[n-1][m-1];
    }
                
    boolean checkValid(int target, int max){
        if (target<0 || target>(max-1)) return false;
        return true;
    }
            
}
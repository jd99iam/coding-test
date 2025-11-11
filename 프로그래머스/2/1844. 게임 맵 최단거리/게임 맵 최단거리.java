
/**

최단거리 : bfs 일거같음 

최대 10^4 칸 
순회는 O(n) -> 시간복잡도 문제 X 

bfs사용 

bfs 하면서 level 값 사용하면 몇번 이동했는지 알수있고 

visited 는 2차원 배열로 넣고 
cost도 2차원 배열에 넣고 ?? 읭 ? 



슈도코드


queue Node 
visited 2차원 배열 (값은 방문안했으면 -1, 방문했으면 level : 이동 횟수)
Arrays.fill(-1)

큐에 시작노드 넣고
visited에 시작점 값 0으로 바꾸고


while문에서는 level 값 관리 해야하고 
나머지는 그냥 bfs랑 똑같이 하면 되고 

(n,m) 위치 

그런데 equals 오버라이딩 해야하나 ? 흠 .. 
안해도 되네... 왜냐면 ? 어차피 중복 여부는 visited로 검사하니까 ! 


**/

import java.util.*;


class Solution {
    
    private static class Node {
        int x;
        int y;
        int level;
        
        public Node(int x, int y, int level){
            // System.out.println("x : "+x+" y : "+y);
            this.x = x; 
            this.y = y; 
            this.level = level;
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
        visited[0][0] = 0;
        
        int level = 0;
                
        while (!q.isEmpty()){
            Node current = q.poll();
            int x = current.x;
            int y = current.y;
            int l = current.level;
            
            // x가 가로, y가 세로 
            // m이 가로, n이 세로
            // 상하좌우 
            // 상 x , y-1
            if (checkValid(x, m) && checkValid(y-1, n) && visited[y-1][x]==-1 && maps[y-1][x]==1){
                visited[y-1][x] = l+1;
                q.offer(new Node(x,y-1,l+1));
            }
            // 하 x , y+1
            if (checkValid(x, m) && checkValid(y+1, n) && visited[y+1][x]==-1 && maps[y+1][x]==1){
                visited[y+1][x] = l+1;
                q.offer(new Node(x,y+1,l+1));
            }
            // 좌 x-1, y 
            if (checkValid(x-1, m) && checkValid(y, n) && visited[y][x-1]==-1 && maps[y][x-1]==1){
                visited[y][x-1] = l+1;
                q.offer(new Node(x-1,y,l+1));
            }
            // 우 x+1, y 
            if (checkValid(x+1, m) && checkValid(y, n) && visited[y][x+1]==-1 && maps[y][x+1]==1){
                visited[y][x+1] = l+1;
                q.offer(new Node(x+1,y,l+1));
            }
        }
          
        return visited[n-1][m-1];
    }
                
    boolean checkValid(int target, int max){
        if (target<0 || target>(max-1)) return false;
        return true;
    }
            
}
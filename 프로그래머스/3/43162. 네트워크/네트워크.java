/**
컴퓨터 개수 n (1 - 200)
연결에 대한 정보 2차원 배열 computers 

네트워크의 개수 리턴 

컴퓨터는 0부터 n-1 정수로 표현 

주어지는 computer는 인접리스트 형태네 

i 번째 컴퓨터가 연결된 컴퓨터들은 computers[i]를 보면 되네 

bfs나 dfs를 하면서 
네트워크의 개수를 센다는 것은 
그래프의 개수를 세는것임 

bfs 라고 하고 
0 번째가 연결된걸 순회 연결된 것들을 visited에 넣어 -> 1개의 그래프 

어차피 연결된 건 방문하면서 다 큐에 들어가게 되어있다 


----- 정리 -----
n개의 컴퓨터에 대해
bfs를 n번 돌면 되는데 
만약에 visited에 있는 컴퓨터면 넘어가고 
없는 컴퓨터면 bfs 돌고, 네트워크 수 1 추가하면된다. 

시간복잡도는 어차피 컴퓨터 개수만큼만 순회하니까 O(n) 이다 





**/

// 메모리 초과 ... ? 왜 ? ???... -> bfs 에서 방문여부 검사하고 visited.add를안해줘서 무한루프 돌았네 
import java.util.*;

class Solution {
    
    // 네트워크 개수만 알면 되니까 (방문 순서 필요 X) visited는 Set 써서 contains의 시간 복잡도를 줄이자 
    static HashSet<Integer> visited = new HashSet<>();    
    
    public int solution(int n, int[][] computers) {
    
        int answer = 0;

        for (int i=0; i<n; i++){
            if (!visited.contains(i)){
                answer+=1;
                // bfs 
                bfs(i, computers, n);
            }
        }
        return answer;
    }
    
    public static void bfs(int computer, int[][] computers, int n){
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited.add(computer);
        queue.offer(computer);
        
        while (!queue.isEmpty()){
            int currentComputer = queue.poll();
            int[] adjComputers = computers[currentComputer];
            
            for (int i=0; i<n; i++){
                if (adjComputers[i]==1 && !visited.contains(i)){
                    visited.add(i);
                    queue.offer(i);
                }
            }
        }
    }
}


























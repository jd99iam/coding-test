import java.util.*;

class Solution {
    
    /**
    progresses 와 speeds 로 
    각 기능별로 몇 일 걸리는지 계산이 가능하다
    
    -> progresses 를 순회 (10^2)
    순회하면서 계산은 
    left = (100 - progress)
    need = left/speed + (나머지 있는 경우 1 더하기) -> O(1)

    ex 
    4 1 3 2 5 4    -> Queue<Integer>   -> 10^2 
    맨 앞에걸 꺼내고 
    자신보다 같거나 작은 애들이 나오는 동안 계속 꺼내면서 더한다 
    더해서 나온 수를 배열에 넣는다. 
    -> Queue offer, poll -> O(1)
    
    그 다음도 마찬가지 
    
    **/
    public int[] solution(int[] progresses, int[] speeds) {        
        Queue<Integer> q = new ArrayDeque<>();
        
        int length = progresses.length;
        for (int i=0; i<length; i++){
            int left = 100 - progresses[i];
            int speed = speeds[i];
            int need = left/speed + (left%speed==0?0:1);
            q.offer(need);
        }
        
        ArrayList<Integer> deploys = new ArrayList<>();
        
        while(!q.isEmpty()){
            int now = q.poll();
            int deploy = 1; 
            
            while (!q.isEmpty()){
                int peek = q.peek();
                if (peek<=now){
                    q.poll();
                    deploy+=1;
                } else {
                    break;
                }
            }
            
            deploys.add(deploy);
        }
        
        int[] answer = new int[deploys.size()];
        
        for (int i=0; i<deploys.size(); i++){
            answer[i] = deploys.get(i);
        }
        
        return answer;
    }
}
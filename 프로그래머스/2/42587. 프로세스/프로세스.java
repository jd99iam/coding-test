import java.util.*;

/**

priorities[location] 을 p 라 하자

priorities 순회하면서 process의 우선순위 P 라 하면 
count = 0 시작   -> 현재 큐에 p 보다 높은 우선순위인 애들이 몇개 있는지 나타내기 위한 변수

ArrayDeque<Process>
Process(index, priority)


**/

class Solution {
    public int solution(int[] priorities, int location) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=1; i<=9; i++){
            map.put(i,0);
        }

        int p = priorities[location];
        
        Queue<Process> q = new ArrayDeque<>();
        
        for (int i=0; i<priorities.length; i++){
            int priority = priorities[i];
            if (priority>=p){
                q.offer(new Process(i,priority));
                map.put(priority, map.get(priority)+1);
            }
        }
        
        
        int count = 0;
        
        while (!q.isEmpty()) { 
            Process now = q.poll();
            // System.out.println("idx : "+now.index+" , priority : "+now.priority);
            
            
            int np = now.priority;
            boolean flag = false;
            for (int i=np+1; i<=9; i++){
                if (map.get(i)!=0) {
                    flag = true;
                    break; 
                }
            }
            
            if (flag){
                q.offer(now);
            } else {
                count += 1;
                map.put(np, map.get(np)-1);
                if (now.index == location) return count;
            }
        }
        
        return count;
    }
    
    public static class Process {
        int index;
        int priority;
        
        public Process(int i, int p){
            this.index = i;
            this.priority = p;
        }
    }
}
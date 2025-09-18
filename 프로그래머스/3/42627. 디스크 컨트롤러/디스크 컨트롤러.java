import java.util.*;

/**
우선순위 큐 
우선순위 큐 생성 시 조건을 문제에서 제시한 대로 넣고 

대기 큐에 한번에 다 넣어놓으면 대기 큐에 실제로 없어야 하는데도 있을 수 있다 

그리고 문제에 jobs 가 요청 시간에 따라 순서대로 제공된다는 말도 없다 

따라서 요청 시간 오름차순으로 꺼내는 PriorityQueue 가 하나 더 있어야 한다.

먼저 jobs -> 요청시간 pq -> peek 해서 요청 시간에 도달했으면 poll -> 대기 큐에 offer 


job 은 최대 500 개 


int l = jobs.length;

jobs -> 잡 큐 : 500 * log500 

int totalTime = 0; 

while (잡 큐 notEmpty) { -> 500 

    while 잡큐 notEmpty (){
        잡큐요청시간 : 잡큐.peek.요청시간 

        if (잡큐요청시간<=현재시간) : 
            잡큐 poll -> 대기 큐 offer  
    }   -> 대기 큐에 현재 시점에 있어야 할 작업 다 넣음 
    
    // 만약 작업큐가 안 비었으면 꺼내서 하면되고 
    // 작업큐가 비었으면 시간에 따라 넣을건 넣어줘야 함
    
    if (대기큐 isnotempty) {
     대기큐.poll 
     현재시간이 대기큐 요청시간보다 빠르면 현재시간 대기큐 요청시간까지 이동
     현재시간 += 작업 소요시간
     totalTime 에 (재시간 - 대기큐 요청시간) 더하기 
    }
}

리턴 totalTime/작업개수



**/

class Solution {
    public int solution(int[][] jobs) {
        
        int count = jobs.length;
        
        // jobs 큐 
        PriorityQueue<Work> jobQ = new PriorityQueue<>((w1,w2)->w1.reqTime-w2.reqTime);
        
        
        // -> log500
        for (int i=0; i<count; i++){
            jobQ.offer(new Work(i, jobs[i][0], jobs[i][1]));
        }
        
        
        // 작업 대기 큐
        PriorityQueue<Work> waitQ = new PriorityQueue<>((w1,w2)->{
            if (w1.needTime == w2.needTime){ // 소요시간이 같으면 
                if (w1.reqTime == w2.reqTime){ // 요청시각이 같으면 
                    // 작업 번호 낮은 것부터
                    return w1.number-w2.number;
                }
                return w1.reqTime - w2.reqTime; // 요청시각이 빠른 것부터 
            }
            return w1.needTime - w2.needTime; // 소요시간이 빠른 것부터 
        });
        
        int totalTime = 0;
        int time = 0;
        
        
        // 최대 500 
        while (!jobQ.isEmpty()||!waitQ.isEmpty()){
            
            // 대기 큐에 작업이 있다 
            if (!waitQ.isEmpty()){     // log500 
                
                Work w = waitQ.poll();
                
                // 현재 시간을 작업 끝나는 시점으로 조정
                time += w.needTime;
                
                // 평균 구하기 위함
                totalTime += (time - w.reqTime); 
                
            } else {  // 대기 큐에 작업이 없다 
                
                // 지금 시간과 작업 큐의 가장 앞에 있는 작업 요청 시간을 비교 
                if (!jobQ.isEmpty()){
                    
                    Work w = jobQ.peek();
                    
                    if (time < w.reqTime){
                    // 대기 큐가 비었고, 작업 큐의 맨 앞 시간도 지금 시간보다 늦어서 넣을 수 없으면 지금 시간을 조정 
                        time = w.reqTime;
                    }
                    
                }
            }            
                            
            // 지금 시간 기준 대기 큐에 넣을 수 있는 만큼 넣기 
            while (!jobQ.isEmpty()){ // jobQ -> watiQ 넣기 -> 500 이라고 해도 
                Work job = jobQ.peek();
                if (job.reqTime<=time){
                    waitQ.offer(jobQ.poll());        // log500 
                } else {
                    break;
                }
            }
            
            // 500*500*log500 이라고 쳐도 거기서 넉넉하게 쳐서 250000*10 로 쳐도
            // 2500000 이니까 10^7 미만이다      
        }
        
        return totalTime/count;
        

    }
    
    public static class Work{
        int number;
        int reqTime;
        int needTime;
        
        public Work(int n, int r, int nT){
            this.number = n;
            this.reqTime = r;
            this.needTime = nT;
        }
    }
}
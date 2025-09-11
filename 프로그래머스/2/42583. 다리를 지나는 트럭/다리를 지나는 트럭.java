import java.util.*;

/**
트럭이 올라가서 1초에 한칸씩 가고 
bridge_length 만큼 가야 함

완전히 넘어오는데는 bridge_length + 1 초 걸림 

--

그냥 푼다고 생각하면 

- 다리 위에 있는 트럭 1칸 전진 (나올 수 있는 트럭은 나오고)
- 다리가 버틸 수 있는 무게 확인 , 남은 칸 있는지 확인 
- 다음 트럭 올릴 수 있으면 올리기 
- 모든 트럭이 넘어올 때 까지 반복

큐에 bridge_length 만큼 0 을 넣고 시작 
time = 0
totalWeight = 0 
count = 0 

time +=1 하면서 1초씩 진행 
조건을 충족하면 (무게, 공간 있는지) -> 공간은 굳이 생각 안해도 될듯 
if 충족 : 맨 앞 poll, 새 트럭 offer, totalWeight += weight; 
else : 맨 앞 poll, 0 offer, poll 한 값을 totalWeight 에서 빼주기
poll 한 값이 0이 아니라면 count +=1 

truck_weights.length 얻어 놓고
count 랑 트럭 수 같아지면 모든 트럭 이동, time 리턴

최악의 경우 
다리에 한번에 하나의 트럭만 올라갈 수 있다고 생각하면 
다리 길이 : 최대 10^4 
트럭 최대 수 : 10^4 
10^8 인데 
반복문 내에서는 queue poll, offer O(1) 인 연산만 진행하므로 최대 10^8 의 시간복잡도를 갖는다 

**/

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int count = 0;
        int time = 0;
        int totalWeight = 0;
        
        Queue<Integer> bridge = new ArrayDeque<>();
        
        Queue<Integer> trucks = new ArrayDeque<>();
        
        // 비어있는 다리로 시작 
        for (int i=0; i<bridge_length; i++){
            bridge.offer(0);
        }
        
        for (int i=0; i<truck_weights.length; i++){
            trucks.offer(truck_weights[i]);
        }
        
        // count 가 다리에서 나온 트럭들, truck_weights.length 총 트럭 수 
        /**
        0 3 
        
        **/
        while (count < truck_weights.length){
            time += 1;
            
            // 트럭 전진
            Integer out = bridge.poll();
            if (out != 0){
                totalWeight -= out;
                count += 1; 
            }
            
            // 다음 트럭 다리 진입 가능 
            if (!trucks.isEmpty()&&(totalWeight + trucks.peek())<=weight){
                int in = trucks.poll();
                bridge.offer(in);
                totalWeight += in;
            }  else { // 불가능일 경우 0을 넣어서 빈칸임을 표시
                bridge.offer(0);
            }
        }
        
        return time;
    }
}
import java.util.*;

/**
명령어 최대 10^6 개 

실제로 한다면 ? 

음... 

일렬로 세우겠지 
그리고 앞에서 꺼내고 뒤에서 꺼내고 하겠지 
그렇지 ? 

이런 자료구조가 있었던거 같은데 자바에 컬렉션 

doublylinkedlist 
-> 정렬 X 

정렬 nlogn 이니까 안될거고 

어떻게.. ? 

그럼 우선순위 큐를 쓰고 
발생하는 문제를 해결해야지 

우선순위 큐를 2개 쓰는건 맞는 거 같아. 
왜냐면 우선순위 큐는 단순 poll 을 하는거지 조건에 따라 우선순위를 바꾸는 기능은 없으니까 

그럼 2개 썼을때 발생하는 문제점은 

최대값 제거 연산 -> 최대 큐에서는 제거 -> 최소 큐에서는 ? 
최소 큐에서 제거를 안해서 발생하는 문제 
- 만약 최소 큐에 원소가 많으면 당장 문제 X 
- 원래는 제거되었어야 할 원소가 최소 큐에 남아있게 되고 , 이 원소를 나중에 리턴해서 오답이 될 수 있다.
--> 없어야 할 원소가 있으면 안된다. 
그렇다면 원소 개수 카운팅에 Set 을 쓰자
Set 의 contains 나 remove 등은 O(1) 이니까 카운팅에만 사용하면 문제 X
그리고 공통 length 사용할 필요 없이 
set.isEmpty로 검사할 수도 있다. 

**/


class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> MQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mq = new PriorityQueue<>();
        
        HashSet<Integer> set = new HashSet<>();
        
        // 10^6 
        for (int i=0; i<operations.length; i++){
            String operation = operations[i];
            String[] split = operation.split(" ");
            
            String type = split[0];
            Integer value = Integer.valueOf(split[1]);
        
            
            // 삽입
            if (type.equals("I")){    // logN 
                MQ.offer(value);
                mq.offer(value);
                set.add(value);
            }
            
            // 삭제 
            if (type.equals("D")){
                if (set.isEmpty()){ // 비었으면  // O(1)
                    continue;
                }
        
                if (value==1){ // 최대값 삭제 
                    
                    // 
                    while (true){
                        
                        // logN
                        Integer target = MQ.poll();
                        
                        // O(1)
                        if (set.contains(target)){
                            set.remove(target);
                            break;
                        }
                    }
                }
                if (value==-1){    // 최소값 삭제
                    while (true){
                        Integer target = mq.poll();
                        if (set.contains(target)){
                            set.remove(target);
                            break;
                        }
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        
        if (set.isEmpty()){ // set이 빈 경우 원소가 더이상 없음 
            answer[0] = 0;
            answer[1] = 0;
        } else { // 아닌 경우 
            // answer[0] = MQ.poll();
            // if (MQ.isEmpty()){
            //     answer[1] = answer[0];
            // } else {
            //     answer[1] = mq.poll();
            // }
            
                        // 최대값 
            while (true){
                int max = MQ.poll();
                if (set.contains(max)){
                    answer[0] = max;
                    break;
                }
            }

            // 최소값 
            while (true){
                int min = mq.poll();
                if (set.contains(min)){
                    answer[1] = min;
                    break;
                }
            }   
        }
        return answer;
    }
}
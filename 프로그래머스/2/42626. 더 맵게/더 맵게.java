import java.util.*;

/**

PriorityQueue 사용 
스코빌 지수 낮은게 우선순위 높게 해서 

poll 해서 K 이상인지 검사 
K 이상이면 count 리턴 

K 미만일 경우 count +=1 
하나 더 poll 해서 섞은 후 offer 

-> 절대 K 이상이 될 수 없는 케이스 
가장 작은 값 2개가 0, 0 일경우 값이 커지지 않음 
0 + 0*0 = 0 인데 
세번쨰 작았던 값이 이제는 두번째가 되니까 커지긴 하네 
그럼 이건 isEmpty 까지 반복하고 안 될 경우 return -1 하는게 맞는듯 

1개 꺼냈는데 K 미만이고 다음 음식이 없으면 -1 리턴 

시간복잡도 
scoville 길이 10^6

최악의 경우 
원소 1개 남을 때까지 한다면 
사실상 모든 원소에 대해 한거니까

O(n) * O(logn)
nlogn

10^5 * log10^5 -> 약 10^5 * 16 -> 어쨌든 10^8 언더 !! 

**/

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i=0; i<scoville.length; i++){
            heap.offer(scoville[i]);
        }
        
        while(!heap.isEmpty()){
            int first = heap.poll();
            
            if (first>=K) return answer;
            
            answer += 1;
            
            if (heap.isEmpty()) return -1;
            
            int second = heap.poll();
            
            heap.offer(first+2*second);
            
        }
        
        
        
        return answer;
    }
}
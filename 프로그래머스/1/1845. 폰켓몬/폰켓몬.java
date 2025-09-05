import java.util.*;

/**
포켓몬 N마리 중 N/2 마리 선택 
종류별로 변호를 붙인다 
같은 종류가 여러개 있을 수 있다. 

N/2 마리를 선택할 때 가장 많은 종류가 들어가게 선택하고 그 때 종류의 수 리턴


nums.lenght/2 만큼 선택해야 한다. (항상 짝수)
N 은 최대 10^4

map.keySet();

keySet 크기가 N/2 보다 크면 N/2 리턴 
아니면 keySet 크기 리턴 

HashMap < 종류, 수 > map = new HashMap<>()

**/
class Solution {
    public int solution(int[] nums) {        
        int n = nums.length;
        int choose = n/2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            map.put(nums[i], (map.getOrDefault(nums[i],0)+1));
        }
        
        Set<Integer> keySet = map.keySet();
        int size = keySet.size();
        if (size>choose) return choose;
        return size; 
        }
}
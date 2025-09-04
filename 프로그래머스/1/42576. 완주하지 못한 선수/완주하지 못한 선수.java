import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        
        /**
        최대 10^5 명 
        
        participant 돌면서 HashMap < 이름, 수>  만들기 
        
        
        completion 돌면서 get(이름) 해서 수 -1 해주기 
        
        
        map 돌면서 값 > 0이면 리턴 
        
        
        **/
        
        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0; i<participant.length; i++){
            Integer val = map.getOrDefault(participant[i],0);
            map.put(participant[i],val+1);
        }
        
        for (int i=0; i<completion.length; i++){
            map.put(completion[i], map.get(completion[i])-1);
        }
        
        for (String name : map.keySet()){
            if (map.get(name)>0) return name;
        }
        
        return null;

    }
}
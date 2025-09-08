import java.util.*;


/**
코니는 매일 옷을 다르게 입음 (전날과 무언가는 달라야함)

종류별로 1가지 의상만 착용 가능 

하루에 최소 1개 종류는 입는다 

의상이 담긴 2차원 배열 clothes -> 서로 다른 조합의 수를 리턴하라 

clothes[i] = [의상 이름, 의상 종류]
1 <= 의상의 수 <= 30

의상 이름이 같은 경우 X 

clothes 를 순회하면서
HashMap <String, Integer> 에 담기 
<종류, 그 종류의 의상 개수> (1씩 더하면서)

넣을 때 중복검사 필요 X (어차피 중복 이름 없기 때문) 
-> 그래서 수만 value 로 가져도 되기 때문에 value 에 Integer 사용 

map 의 key 를 순회하면서 값 + 1 한 값끼리 전부 곱하고, (안입는 경우)
전부 안입는 경우 제외 (-1) 해준다. 


**/


class Solution {
    public int solution(String[][] clothes) {        
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i=0; i<clothes.length; i++){
            String type = clothes[i][1];
            String name = clothes[i][0];
            
            map.put(type, map.getOrDefault(type, 0)+1);
        }
        
        
        int answer = 1; 
        
        for (String type : map.keySet()){
            // System.out.println(type);
            // System.out.println(map.get(type));
            answer = answer*(map.get(type)+1);
        }
        
        answer = answer-1;
        
        return answer;
    }
}
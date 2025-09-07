import java.util.*;

/**
phone_book 의 전화번호들 중 
한 번호가 다른 번호의 접두어인 경우가 있으면 false
아니면 true 리턴 

phone_book.length 최대 10^6 

String 2개가 있어 
"119" "119112"
앞에게 뒤의것의 접두어인지 어떻게 확인하지 ? 

더 짧은 걸 가지고 긴거에서 subString 을 하고 
두개가 같은지 비교하면 된다. 

---

해시맵을 사용하면

번호를 넣을 때 
각 번호의 1번째
1-2번째
1-3번째
를 전부 해시맵에 넣는다면 ? 
즉 번호가 123 이면 1 , 12, 123 전부 해시맵에 넣는다. 이 때 번호의 앞부분이 아닌 번호인지는 value 로 구분 

phone_book 은 최대 10^6 이고 
전화번호 길이는 최대 20 이니까 
약 10^7이 된다. 
해시맵의 put, get 은 O(1) 이므로 약 10^7

**/
class Solution {
    public boolean solution(String[] phone_book) {
        
        int length = phone_book.length;
        
        // string : 전화번호 , boolean : 주어진 전체 전화번호인지 
        HashMap<String, Boolean> map = new HashMap<>();
        
        for (int i=0; i<length; i++){
            
            String phone = phone_book[i];
            
            
            for (int j=1; j<=phone.length(); j++){
                
                String subString = phone.substring(0,j);
                
                // map 에 들어있는 값이 전체 문자열이거나, 현재 phone 이 전체 문자열이거나
                if (map.containsKey(subString) && (map.get(subString)==true||j==phone.length())){
                    return false;
                } 
                
                if (j==phone.length()){
                    map.put(subString, true);
                } else {
                    map.put(subString,false); 
                }
                
            }
        }
        
        return true;
    }
}
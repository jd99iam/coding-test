/**
( 로 열리고 ) 로 닫혀야 올바른 괄호이다 
올바른 괄호 -> true 
올바르지 않은 -> false 리턴 

s 를 앞부터 한 글자씩 보면서 
( -> q 에 넣기 
) -> q 에서 ( 꺼내기 -> 이 때 q.isEmpty() 일 경우 false 반환 

전부 봤는데, !q.isEmpty() 면 false 반환

s 최대 10^5 , 큐 offer poll 은 O(1) -> 10^5

-> 생각해보니까 큐 굳이 필요 없음
**/

class Solution {
    boolean solution(String s) {
        // Queue<Character> q = new ArrayDeque<>();
        int count = 0; 
        
        for (int i=0; i<s.length(); i++){
            Character now = s.charAt(i);
            if (now=='('){
                count += 1;
            } else if (now == ')'){
                if (count<=0) return false; 
                count -= 1;
            }
        }
        if (count == 0) return true;
        return false;
    }
}
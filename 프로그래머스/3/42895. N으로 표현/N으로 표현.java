/**

최대 8개의 N 사용 가능 

N을 n개 사용해서 만들 수 있는 수는 
n = i + j 라고 할 때 

N n 개 나열 NNNN 형태 
(N i개) + (N j개)
(N i개) - (N j개)
(N i개) * (N j개)
(N i개) / (N j개)

이렇게 만든 것 중 number 가 있는지 확인 

n은 최대 8이라는 제약이 있기 때문에 가능

**/

import java.util.*;

class Solution {
    
    public int solution(int N, int number) {
        
        System.out.printf("N : %d , number : %d", N, number);
        
        List<Set<Integer>> memo = new ArrayList<>(); 
        // 인덱스 편하게 구성하기 위해 0번째는 사용하지 않고 초기화만 하고 1~8번째 사용
        
        for (int i=0; i<=8; i++){
            memo.add(new HashSet<>());
        }
        
        // memo.get(i) 는 N을 i개 사용해서 만들 수 있는 수들의 리스트 
        for (int i=1; i<=8; i++){
            Set<Integer> currentSet = memo.get(i);
            
            // NNN 형태로 숫자 이어붙이는 경우 
            StringBuilder sb = new StringBuilder();
            for (int j=1; j<=i; j++){
                sb.append(String.valueOf(N));
            }
            currentSet.add(Integer.parseInt(sb.toString()));
            
            for (int j=1; j<i; j++){
                int k = i-j;
                
                Set<Integer> jList = memo.get(j);
                Set<Integer> kList = memo.get(k);
                
                for (Integer jNum : jList){
                    for (Integer kNum : kList){
                        currentSet.add(jNum+kNum);
                        currentSet.add(jNum-kNum);
                        currentSet.add(jNum*kNum);
                        if (kNum>0){
                            currentSet.add(jNum/kNum);    
                        }
                    }
                }
            }
            
            if (currentSet.contains(number)) {
                return i;
            }
            
        }
        
        return -1;
    }
}
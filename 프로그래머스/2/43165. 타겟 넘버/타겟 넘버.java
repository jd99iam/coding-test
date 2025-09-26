import java.util.*;

/**
# 문제 이해 
n개의 음이 아닌 정수를 순서를 바꾸지 않고 더하거나 빼서 타겟 넘버를 만든다 
만드는 방법의 수 리턴 

# 풀이 방법 
숫자의 개수 만큼 연산자를 넣어야한다 

이진 트리라고 생각한다면 
루트노드 
더하기 빼기 
더하기 빼기 더하기 빼기 

이진 트리 순회 

숫자는 최대 20개 
2^20 가지 가능 
-> 1024 * 1024 -> 10^6 정도
순회 : O(n) -> 10^8 미만이니까 문제 X 

dfs 가 더 구현하기 편하니까 dfs 로

numbers -> 

1
2 3 
4 5 6 7 

왼쪽자식 -> 자신*2
오른쪽자식 -> 자신*2+1 
루트노드 번호 1로시작

이진트리 레벨은
루트 레벨이 0이면 
간선 하나로 넘어갈 때 마다 즉 레벨 1 증가할 때 마다 연산자 하나인 것임 
생각해보니까 맨 앞 숫자에도 연산자 + 나 - 나 붙으니까 
맨 앞에 숫자를 0이라고 가상으로 생각하고 

0     레벨 0
numbers[0] numbers[0]  레벨 1 
numbers[1] numbers[1] numbers[1] numbers[1] 레벨 2 

인덱스
0
1 2 
3 4 5 6 

이러면 왼쪽자식 : 자신*2+1 , 오른쪽자식 자신*2+2

자신의 레벨 == numbers.length 랑 같은지 확인 
-> 다르면 다음 호출 
-> 같으면 재귀 종료, 결과값이랑 target 비교 후 카운트

---

앞에 0 있다고 생각하지 말고 

num[0]          0    레벨 0 
num[1] num[1]   1    레벨 1 
num[2] num[2] num[2] num[2]  2  레벨 2 

인덱스는 다음 dfs 호출로 넘어가면서 1씩 더하면 되고 
solution 에서 호출할 때는 초기 level 값은 1로 왜냐하면 루트노드 쪽은 한거고 
레벨 1 노드로 넘어가는 것 부터 시작이니까 
(맨 위 가상의 0은 없는걸로 하기로 했으니까)

**/

class Solution {
    public static int[] numbers;
    public static int target; 
    public static int answer; 
    public static int length;
    
    public int solution(int[] numbers, int target) {
        this.length = numbers.length;
        this.numbers = numbers;
        this.target = target; 
        
        // // 실제론 없는 숫자 0을 맨 앞에 있다고 가정함 -> 이것때문 인덱스 초과 발생 
        // dfs(0, 0, 0);
        // -> 그게 아니라 인덱스는 1씩 더해야 하네 다음 숫자는 현재 인덱스 + 1 임
        
        // 어차피 answer에 한번에 관리하니까 그냥 2개 하면된다  
        dfs(numbers[0], 0, 1);
        dfs(-numbers[0], 0, 1);
        
        return answer;
    }
    
    public void dfs(int value, int index, int level){
        // 주어진 모든 숫자에 대해 연산 끝, 이제 결과값이 target과 같은지 비교
        if (level == length){
            if (value == target){
                answer+=1;
            }
            return;
        }
        
        dfs(value+numbers[index+1],index+1, level+1);
        dfs(value-numbers[index+1],index+1, level+1);
    }
}
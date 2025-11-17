/**
꼭대기에서 바닥까지 이어지는 경로
거쳐간 숫자의 합이 가장 큰 경우 

맨 밑의 어떤 칸에 도착했다면 
그 칸의 대각선 왼쪽위까지 최대값 , 오른쪽위까지 최대값중에서 큰 값을 선택 

현재칸 
행 i 
열 j
라고 한다면, 

대각선 왼쪽위는 [i-1][j-1]
대각선 오른쪽위 [i-1][j]

경계값 처리 해주고 

base case는 
맨 위칸 [0][0] 은 자기 값  


**/

import java.util.*;
import java.math.*;

class Solution {
    
    static int height;
    static int width;
    static int[][] memo;
    
    public int solution(int[][] triangle) {
        
        height = triangle.length;
        width = triangle[height-1].length;
        
        memo = new int[height][width];
        // 삼각형 이루는 숫자가 0도 있어서 비용이 0이면 값 기록하지 않은거랑 구분 불가해서 -1로 초기화
        for (int i=0; i<height; i++){
            Arrays.fill(memo[i], -1);
        }
        
        
        Set<Integer> values = new HashSet<>();
        
        for (int i=0; i<width; i++){
            values.add(dp(height-1, i, triangle));
        }
        
        int answer = values.stream()
            .reduce((a,b) -> Math.max(a,b))
            .orElseThrow(()->new RuntimeException("no value in values"));
        
        return answer;
    }
    
    public int dp(int i, int j, int[][] triangle){
        if (i<0 || j<0 || j>triangle[i].length-1){
            return 0;
        }
        if (memo[i][j]!=-1) {
            return memo[i][j];
        }
        int left = dp(i-1,j-1, triangle);
        int right = dp(i-1,j, triangle);
        
        memo[i][j] = Math.max(left,right) + triangle[i][j];
        return memo[i][j];
    }
}
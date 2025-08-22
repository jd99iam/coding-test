class Solution {

    /**
    계단을 오르는데, 꼭대기까지 n step 이 필요하다. 
    한번에 1 또는 2 계단을 오를 수 있다. 
    꼭대기까지 오를 수 있는 서로 다른 방법의 개수를 반환하라. 

    n 에 오를려면 
    n-1 에서 1칸 가는거, 
    n-2 에서 2칸 가는거 

    2가지 방법이 있다.

    점화식 : step(n) = step(n-1) + step(n-2);


     */
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n>=2) dp[2] = 2;

        return topDown(n, dp);
    }

    // top down 
    public int topDown(int n, int[] dp){
        if (dp[n]!=0) return dp[n];

        dp[n] = topDown(n-1, dp) + topDown(n-2, dp);

        return dp[n];
    }
}
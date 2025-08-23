class Solution {

    /**
    m*n grid 에 로봇이 있다. 
    로봇은 grid[0][0] 에서 grid[m-1][n-1] 로 이동하낟 
    아래 또는 오른쪽으로만 이동할 수 있다. 
    
    m,n 이 주어지면 우하단에 도착할 수 있는 가능한 서로다른 경로들의 개수를 반환해라 
    
    m,n <= 10^2 
    최대 10^4 칸
    
    목표 칸까지 가는 방법 개수 : 목표 칸의 위 칸까지 가는 방법 개수 + 목표 칸의 왼쪽 칸까지 가는 방법 개수 
    
    
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        return path(m, n, dp);
    }

    public int path(int m, int n, int[][] dp) {
        if (m < 1 || n < 1)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        if ((m == 1 && n == 2) || (m == 2 && n == 1))
            return 1;

        if (dp[m][n] != 0)
            return dp[m][n];

        dp[m][n] = path(m - 1, n, dp) + path(m, n - 1, dp);
        return dp[m][n];
    }
}
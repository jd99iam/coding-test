import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[][] elec;
    static int[] dp;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        elec = new int[N][2];
        dp = new int[N];

        for (int i=0; i<N; i++){
            elec[i][0] = in.nextInt();
            elec[i][1] = in.nextInt();
        }

        // A 전봇대 기준으로 정렬
        Arrays.sort(elec,(arr1,arr2)->arr1[0]-arr2[0]);

        int max = 0;
        for (int i=0; i<N; i++){
            max = Math.max(recur(i),max);
        }

        System.out.println(N-max);

    }

    public static int recur(int n){
        if (dp[n]==0){
            dp[n]=1;
            for (int i=n+1; i<dp.length; i++){
                if (elec[n][1]<elec[i][1]){
                    dp[n] = Math.max(dp[n],recur(i)+1);
                }
            }
        }
        return dp[n];
    }
}
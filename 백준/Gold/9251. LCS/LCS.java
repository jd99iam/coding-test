import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char[] str1;
    static  char[] str2;
    static Integer[][] dp;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        str1 = in.next().toCharArray();
        str2= in.next().toCharArray();

        dp = new Integer[str1.length][str2.length];

        System.out.println(LCS(str1.length-1,str2.length-1));

    }

    static int LCS(int x,  int y){
        if (x==-1 || y==-1){
            return 0;
        }
        // 탐색하지 않은 인덱스라면
        if (dp[x][y]==null){
            dp[x][y] = 0;

            if (str1[x]==str2[y]){
                dp[x][y] = LCS(x-1,y-1)+1;
            }
            else {
                dp[x][y] = Math.max(LCS(x-1,y),LCS(x,y-1));
            }

        }
        return dp[x][y];
    }

}
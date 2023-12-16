
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main{
	
	static Integer [][][] dp = new Integer[21][21][21];

	
	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(System.in);
		int a,b,c;
		
		while (true) {
			a=in.nextInt();
			b=in.nextInt();
			c=in.nextInt();
			if (a==-1&&b==-1&&c==-1) {
				break;
			}
			System.out.println(String.format("w(%d, %d, %d) = %d", a,b,c,get(a,b,c)));
		}
		
	}
	
	private static int get(int a, int b, int c) {

		if (a<=0||b<=0||c<=0) {
			return 1;
		}
		if (a>20 || b>20 || c>20) {
			return dp[20][20][20]=get(20,20,20);
		}
		if (dp[a][b][c]!=null) {
			return dp[a][b][c];
		}
		if (a<b&&b<c) {
			return dp[a][b][c]=get(a,b,c-1)+get(a,b-1,c-1)-get(a,b-1,c);
		}
		return dp [a][b][c]=get(a-1,b,c)+get(a-1,b-1,c)+get(a-1,b,c-1)-get(a-1,b-1,c-1);
	}
}









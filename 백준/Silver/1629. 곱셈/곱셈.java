
import java.util.*;
import java.io.*;

public class Main{
	
	static long c;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		System.out.println(divide(a,b));
		
	}
	
	public static long divide(long a, long b) {
		if (b==1) return a%c;
		long temp = divide(a,b/2);
		if (b%2==0) {
			return temp%c*temp%c;
		}
		return temp%c*temp%c*a%c;
	}

	
}
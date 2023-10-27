
import java.util.*;
import java.io.*;

public class Main{
	
	static int N;
	static int k;
	static int[][] arr;
	
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		long lo = 1;
		long hi = k;
		
		while (lo<hi) {
			
			long mid = (lo+hi)/2;
			long count = 0;
			
			for (int i=1; i<=N; i++) {
				count += Math.min(mid/i,N);
			}
			
			if (k<=count) {
				hi = mid;
			}
			else {
				lo = mid+1;
			}
		}
		
		System.out.println(lo);
		
	}

}
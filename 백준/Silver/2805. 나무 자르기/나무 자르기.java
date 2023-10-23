
import java.util.*;
import java.io.*;

public class Main{

	static int N;
	static long[] arr;
	static long M;
	
	public static void main(String[] args) throws IOException {	
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		arr = new long[N];
		long max = -1;
		for (int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if (max<arr[i]) {
				max = arr[i];
			}
		}
		
		long lo=0;
		long hi=max;
		long sum = 0;
		
		while (lo<hi) {
			sum = 0;
			
			long mid = (lo+hi)/2;
			
			for (int i=0; i<N; i++) {
				if (arr[i]>mid) {
					sum+=arr[i]-mid;
				}
			}
			
			
			if (sum<M) {
				hi=mid;
			}else {
				lo = mid+1;
			}
			
		}
		
		System.out.println(lo-1);
		
			
	}
}
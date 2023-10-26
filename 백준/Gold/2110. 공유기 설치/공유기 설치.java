
import java.util.*;
import java.io.*;

public class Main{
	
	
	static int N;
	static int C;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);

		

		
		
		
		int lo = 1;
		int hi = arr[N-1]-arr[0]+1;
		while (lo<hi) {
			int mid = (lo+hi)/2;
			if (check(mid)) {
				lo = mid+1;
			} else {
				hi = mid;
			}
		}
		
		System.out.println(lo-1);
		
		
		
		
	}
	
	private static boolean check(int length) {
		int now = 0;
		int count = 1;
		int distance = 0;
		while (count<C) {
			if (now==N-1) break;
			distance += arr[now+1]-arr[now];
			if (distance>=length) {
				count+=1;
				distance = 0;
			} 
			now+=1;
		}
		if (count<C) return false;
		return true;
	}
}
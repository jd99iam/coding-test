
import java.util.*;
import java.io.*;

public class Main{
	
	static int N;
	static int K;
	static Integer[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new Integer[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr,Collections.reverseOrder());
		
		int sum = 0;
		int count = 0;
		for (int i=0; i<N; i++) {
			while (sum+arr[i]<=K) {
				sum+=arr[i];
				count+=1;
			}
			if (sum>=K) break;
		}
		
		System.out.println(count);
		
		
	}
}
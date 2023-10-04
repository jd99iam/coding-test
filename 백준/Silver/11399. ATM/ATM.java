
import java.util.*;
import java.io.*;

public class Main{
	
	static int N;
	static int[] arr;
	static int[] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sum = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		sum[0] = arr[0];
		
		for (int i=1;i <N; i++) {
			sum[i]=sum[i-1]+arr[i];
		}

		int result = 0;
		for (int i=0; i<N; i++) {
			result+=sum[i];
		}
		
		System.out.println(result);
	}
}
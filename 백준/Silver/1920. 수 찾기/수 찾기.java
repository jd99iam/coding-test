
import java.util.*;
import java.io.*;

public class Main{

	static int N;
	static int M;
	static int[] A;
	static int[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		
		M = Integer.parseInt(br.readLine());
		B = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			System.out.println(binarySearch(A,0,N-1,B[i]));
		}
		
		
		
		
		
	}
	
	public static int binarySearch(int[] arr, int start, int end, int target) {
		if (start>end) {
			return 0;
		}
		
		int mid = (start+end)/2;
		
		if (arr[mid]==target) return 1;
		
		if (arr[mid]<target) {
			return binarySearch(arr,mid+1,end,target);
		}
		return binarySearch(arr,start,mid-1,target);
		
	}
	

	

}
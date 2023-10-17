
import java.util.*;
import java.io.*;

public class Main{
	
	public static int[][] A;
	static int N;
	static int M;
	static int K;
	public static int[][] B;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		K = Integer.parseInt(st.nextToken());
		


		
		B = new int[M][K];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// int[][] R = new int[N][K];
		for (int i=0; i<N; i++) {
			for (int j=0; j<K; j++) {
				int sum = 0;
				for (int k=0; k<M; k++) {
					sum += A[i][k]*B[k][j];
				}
				System.out.print(sum+" ");
			}
			System.out.println();
		}
		
		
		
	}
	

}
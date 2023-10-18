
import java.util.*;
import java.io.*;

public class Main{
	
	final static int D = 1000;
	static long[][] arr;
	static int N;
	static long B;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		arr = new long[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken())%D;
			}
		}
		
//		for (int i=0; i<N; i++) {
//			for (int j=0; j<N; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		// 입력 : 정상적으로 됨 
		
		
		long[][] answer = matrix(arr,B);
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
	}
	public static long[][] matrix(long[][] input, long up) {
		if (up==1) {
//			for (int i=0; i<N; i++) {
//				for (int j=0; j<N; j++) {
//					input[i][j]%=D;
//				}
//			}
			return input;
		}
		
		long[][] mat = matrix(input,up/2);


		long[][] ret = new long[N][N];
		
		if (up%2==0) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					for (int k=0; k<N; k++) {
						ret[i][j] += mat[i][k]*mat[k][j];
						ret[i][j]%=D;
					}
				}
			}
			return ret;
		}
		
		
		long[][] ret2 = new long[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				for (int k=0; k<N; k++) {
					ret[i][j] += mat[i][k]*mat[k][j];
					ret[i][j]%=D;				}
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				for (int k=0; k<N; k++) {
					ret2[i][j] += ret[i][k]*arr[k][j];
					ret2[i][j]%=D;
					}
			}
		}
		return ret2;
	}
	
}
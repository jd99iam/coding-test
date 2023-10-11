
import java.util.*;
import java.io.*;

public class Main{
	
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<N; j++) {
				arr[i][j] = (int)line.charAt(j)-48;
			}
		}
		

		
		check(0,0,N);
		
		
	}
	public static void check(int x, int y, int l) {
		boolean zero = true;
		boolean one = true;
		for (int i=x; i<x+l; i++) {
			for (int j=y; j<y+l; j++) {
				if (arr[i][j]==1) {
					zero = false;
				}
				if (arr[i][j]==0) {
					one = false;
				}
			}
		}
		if (zero) {
			System.out.print(0);
			return;
		}
		if (one) {
			System.out.print(1);
			return;
		}
		System.out.print("(");
		check(x,y,l/2);
		check(x,y+l/2,l/2);
		check(x+l/2,y,l/2);
		check(x+l/2,y+l/2,l/2);
		System.out.print(")");	
	}
	
}
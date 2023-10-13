
import java.util.*;
import java.io.*;

public class Main{
	
	static int N;
	static int[][] arr;
	
	static int mo=0;
	static int z = 0;
	static int o = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(0,0,N);
		System.out.println(mo);
		System.out.println(z);
		System.out.println(o);
		
	}
	
	public static void check(int x, int y, int l) {
		boolean mot = true;
		boolean zt = true;
		boolean ot = true;
		
		for (int i=x; i<x+l; i++) {
			for (int j=y; j<y+l; j++) {
				if (arr[i][j]==-1) {
					zt = false;
					ot = false;
				}
				if (arr[i][j]==0) {
					mot = false;
					ot = false;
				}
				if (arr[i][j]==1) {
					mot = false;
					zt = false;
				}
			}
		}
		if (mot) {
			mo+=1;
			return;
		}
		if (zt) {
			z +=1;
			return;
		}
		if (ot) {
			o+=1;
			return;
		}
		int nl = l/3;
		
		check(x,y,nl);
		check(x,y+nl,nl);
		check(x,y+nl*2,nl);
		check(x+nl,y,nl);
		check(x+nl,y+nl,nl);
		check(x+nl,y+nl*2,nl);
		check(x+nl*2,y,nl);
		check(x+nl*2,y+nl,nl);
		check(x+nl*2,y+nl*2,nl);
	}
	
}
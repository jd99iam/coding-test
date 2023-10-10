
import java.util.*;
import java.io.*;

public class Main{

	
	static int[][] arr;
	static int blue = 0;
	static int white = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		arr = new int[l][l];
		for (int i=0; i<l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<l; j++) {
				if (st.hasMoreTokens()) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		

		
		check(0,0,l);
		
		System.out.println(white);
		System.out.println(blue);
		
		
	}
	
	static void check(int x, int y, int l) {

		
		boolean w = true;
		boolean b = true; 
		
		for (int i=x; i<x+l; i++) {
			for (int j=y; j<y+l; j++) {
				if (arr[i][j]==1) w = false;
				else b = false;
			}
		}
		
		if (w) {
			white +=1; 
			return;
		}
		if (b) {
			blue +=1;
			return;
		}
		check(x,y,l/2);
		check(x,y+l/2,l/2);
		check(x+l/2,y,l/2);
		check(x+l/2,y+l/2,l/2);
	}
	
}
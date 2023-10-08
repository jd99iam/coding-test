
import java.util.*;
import java.io.*;

public class Main{
	
	static int N;
	static int[] price;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		price = new int[N];
		distance = new int[N];
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<N; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int answer = 0;
		int distanceSum = 0;
		int priceNow = price[0];
		for (int i=1; i<N; i++) {
			distanceSum += distance[i];
			if (priceNow>=price[i]) {
				answer += priceNow*distanceSum;
				distanceSum = 0;
				priceNow = price[i];
			}
		}
		
		System.out.println(answer);
		
	}
}
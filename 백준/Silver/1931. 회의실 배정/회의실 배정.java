
import java.util.*;
import java.io.*;

public class Main{
	
	static long[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new long[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Long.parseLong(st.nextToken());
			arr[i][1] = Long.parseLong(st.nextToken());
		}
		
		// 끝나는 시간 오름차순으로 정렬 
	//	Arrays.sort(arr,(arr1,arr2)->(int)(arr1[1]-arr2[1]));
		
		Arrays.sort(arr, (arr1,arr2)->{
			if (arr1[1]==arr2[1]) {
				return (int)(arr1[0]-arr2[0]);
			}
			return (int)(arr1[1]-arr2[1]);
		});
		
//		for (int i=0; i<N; i++) {
//			System.out.println(arr[i][0]+" ~ "+arr[i][1]);
//		}
		
		// 정렬 성공 
		
		// 제일 빨리 끝나는 애를 고르고 
		// 남은 애들 중 또 제일 빨리 끝나느 애를 고르고 .. 
		
		long end = 0;
		int count = 0;
		
		for (int i=0; i<N; i++) {
			if (end<=arr[i][0]) {
				count+=1;
				end = arr[i][1];
			}
		}
		
		System.out.println(count);
		
	}
}
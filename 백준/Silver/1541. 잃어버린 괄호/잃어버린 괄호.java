import java.util.*;
import java.io.*;

public class Main{		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// - 기준으로 나눈다 
		String[] arr = br.readLine().split("\\-");
		
		int[] sum = new int[arr.length];
		
		for (int i=0; i<arr.length; i++) {
			String[] part = arr[i].split("\\+");
			if (part.length==1) {
				sum[i]=Integer.parseInt(part[0]);
			} else {
				for (int j=0; j<part.length; j++) {
					sum[i]+=Integer.parseInt(part[j]);
				}
			}
		}
		
		int result = sum[0];
		for (int i=1; i<sum.length; i++) {
			result -= sum[i];
		}
		
		System.out.println(result);
		
	}
}

import java.util.*;
import java.io.*;

public class Main{
	
	final static long P = 1000000007L;	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		// 분자 
		long son = facto(N);
	
		// 분모
		long mom = facto(K)*facto(N-K)%P;
		
		//분모의 역원
		long momReverse = pow(mom,P-2);
		
		System.out.println(son*momReverse%P);
		
	}
	
	public static long facto(long n) {
		long result = 1L;
		while (n>=1) {
			result=result*n%P;
			n--;
		}
		return result;
	}
	
	public static long pow(long base, long expo) {
		if (expo==1) {
			return base%P;
		}
		long temp = pow(base,expo/2);
		if (expo%2==0) {
			return temp*temp%P;
		}
		return temp*temp%P*base%P;
	}
}
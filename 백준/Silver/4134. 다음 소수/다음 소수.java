
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int totalCount = Integer.parseInt(br.readLine());
		
		for (int i=0; i<totalCount; i++) {
			BigInteger n = new BigInteger(br.readLine());
			
			if (isPrime(n)) {
				System.out.println(n);
		
			}
			else {
				System.out.println(n.nextProbablePrime());
				
			}
		}		
	}
	
	private static boolean isPrime(BigInteger bigInteger) {
		if (bigInteger.isProbablePrime(10)) {
			return true;
		}
		return false;
	}
}
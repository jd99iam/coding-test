import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int i=0; i<count; i++){
            int N = in.nextInt();
            int M = in.nextInt();
            System.out.println(leg(N,M));
        }
    }

    public static BigInteger leg(int N, int M){
        // M 개에서 N개 뽑 기 순서 없음  m C n
        BigInteger answer = BigInteger.ONE;
        for (int i=M; i>M-N; i--){
            answer = answer.multiply(new BigInteger(String.valueOf(i)));
        }
        for (int i=N; i>1; i--){
            answer = answer.divide(new BigInteger(String.valueOf(i)));
        }
        return answer;
    }

}
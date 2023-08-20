import java.io.IOException;
import java.util.*;

public class Main{

    public static long euc(long a, long b){
        if (a%b==0) return b;
        else {
            return euc(b,a%b);
        }
    }
    public static void main(String[] args) {

        long a = 0;
        long b= 0;

        Scanner in = new Scanner(System.in);

        a = in.nextLong();
        b = in.nextLong();

        if (a>=b){
            System.out.println((a*b)/euc(a,b));
        }
        else {
            System.out.println((a*b)/euc(b,a));
        }



    }
}
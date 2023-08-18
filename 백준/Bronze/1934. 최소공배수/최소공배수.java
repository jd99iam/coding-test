import java.io.IOException;
import java.util.*;

public class Main{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        for (int i=0; i<count; i++){
            int a =in.nextInt();
            int b = in.nextInt();
            if (a>=b){
                System.out.println((a*b)/euclid(a,b));
            } else {
                System.out.println((a*b)/euclid(b,a));
            }
        }
    }


    public static int euclid(int a,int b){
        if (a%b==0) return b;
        else {
            return euclid(b,a%b);
        }
    }
}
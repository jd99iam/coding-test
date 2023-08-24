import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        long N = in.nextLong();

        long count = 0;
        for (int i=1; i*i<=N; i++){

                    count+=1;

            
        }
        System.out.print(count);


    }

}
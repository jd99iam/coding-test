import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

      Scanner in = new Scanner(System.in);
      int N = in.nextInt();
      int K = in.nextInt();

      int answer = 1;
      for (int i=N; i>N-K; i--){
          answer *=i;
      }
      for (int i=K; i>1; i--){
          answer /= i;
      }
        System.out.println(answer);

    }

}
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

      Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int answer = 1;
        for (int i=0; i<input; i++){
            answer*=2;
        }
        System.out.println(answer);

    }
}
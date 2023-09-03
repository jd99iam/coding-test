import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

      Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int answer = 1;
        for (int i=input; i>=2; i--){
            answer *= i;
        }
        System.out.println(answer);


    }

//    public static int facto(int num){
//        if (num==1) return 1;
//        else {
//            return num*facto(num-1);
//        }
//    }
}
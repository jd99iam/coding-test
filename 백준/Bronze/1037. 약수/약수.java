import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        int min = 1000000;
        int max = 2;

        for (int i=0; i<count; i++){
            int input = in.nextInt();
            if (min>input){
                min = input;
            }
            if (max<input){
                max = input;
            }
        }

        System.out.println(min*max);
        

    }

}
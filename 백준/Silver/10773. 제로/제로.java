import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i=0; i<K; i++){
            int input = in.nextInt();
            if (input==0){
                count -= stack.pop();
            }
            else {
                count += input;
                stack.push(input);
            }
        }
        System.out.println(count);
    }
}
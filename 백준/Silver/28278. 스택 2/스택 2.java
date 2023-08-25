import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = in.nextInt();
        for (int i=0; i<N; i++){
            int input = in.nextInt();
            switch (input) {
                case 1: {
                    int num = in.nextInt();
                    stack.push(num);
                    break;
                }
                case 2:{
                    if (!stack.isEmpty()){
                        bf.write(String.valueOf(stack.pop())+"\n");
                    } else {
                        bf.write(String.valueOf(-1)+"\n");
                    }
                    break;
                }
                case 3:{
                    bf.write(String.valueOf(stack.size())+"\n");
                    break;
                }
                case 4:{
                    if (stack.isEmpty()){
                        bf.write(String.valueOf(1)+"\n");
                    } else {
                        bf.write(String.valueOf(0)+"\n");
                    }
                    break;
                }
                case 5:{
                    if (!stack.isEmpty()){
                        bf.write(String.valueOf(stack.peek())+"\n");
                    } else {
                        bf.write(String.valueOf(-1)+"\n");
                    }
                    break;
                }
            }

        }
        bf.flush();
        bf.close();
    }
}
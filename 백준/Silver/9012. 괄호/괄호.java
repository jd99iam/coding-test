import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i=0; i<T; i++){
            String input = in.next();
            for (char c : input.toCharArray()){
                if (c=='('){
                    stack.push(c);
                } else {
                    if (stack.isEmpty()){
                        flag = false;
                        System.out.println("NO");
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (flag){
                if (stack.isEmpty()){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            flag = true;
            stack.clear();
        }
    }
}
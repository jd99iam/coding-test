import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Stack<Character> s1 = new Stack<>();
        boolean flag = true;
        while (true){
            s1.clear();
            flag = true;
            // 입력받기
            String input = in.nextLine();
            // .을 입력받으면 종료
            if (input.equals(".")) break;
            for (Character c : input.toCharArray()){
                if (c.equals('(')){
                    s1.push(c);

                } else if (c.equals(')')){
                    if (s1.empty()||s1.peek()==('[')){
                        flag = false;
                        break;
                    }
                    s1.pop();
                }
                else if (c.equals('[')){
                    s1.push(c);
                }
                else if (c.equals(']')){
                    if (s1.isEmpty()||s1.peek()==('(')){
                        flag = false;
                        break;
                    }
                    s1.pop();
                }
        }
            if (flag&&s1.isEmpty()){
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }

    }
    }
}
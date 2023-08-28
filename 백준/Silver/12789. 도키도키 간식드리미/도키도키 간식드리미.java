import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        Queue<Integer> s1 = new LinkedList<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        // 입력받기
        for (int i=0; i<count; i++){
            s1.offer(in.nextInt());
        }

        while (!s1.isEmpty()){

            // s2 비었다
            if (s2.isEmpty()){
                // s1에서 꺼냄
                int out = s1.poll();

                // s1 peek이랑 비교한다
                if (!s1.isEmpty()&&out>s1.peek()){
                    s2.push(out);
                } else {
                    s3.push(out);
                }
            }
            // s2 안비었다
            else {
                // s1이랑 s2에서 비교해서 꺼냄
                if (!s1.isEmpty()&&s1.peek()>s2.peek()){
                    // s2에서 꺼낸다
                    s3.push(s2.pop());

                } else {
                    // s1에서 꺼낸다
                    int out =s1.poll();
                    if (!s1.isEmpty()&&out>s1.peek()){
                        s2.push(out);
                    }
                    else {
                        s3.push(out);
                    }
                }
            }
        }


        while (!s2.isEmpty()){
            s3.push(s2.pop());
        }

      //   printStack(s3);

        int save = 1001;
        while (!s3.isEmpty()){
            int out = s3.pop();
            if (save-out<0){
                System.out.println("Sad");
                return;
            } else {
                save = out;
            }
        }
        System.out.println("Nice");





    }


    public static void printStack(Stack<Integer> stack){
        for (Integer integer : stack) {
            System.out.print(integer);
        }
        System.out.println();
    }

}
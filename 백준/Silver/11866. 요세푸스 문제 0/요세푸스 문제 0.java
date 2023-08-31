import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i<=N; i++){
            q.offer(i);
        }

        int count = 0;
        System.out.print("<");
        while (!q.isEmpty()){
            count+=1;
            if (count!=K){
                q.offer(q.poll());
            } else {
                System.out.print(q.poll());
                if (q.isEmpty()){
                    System.out.print(">");
                } else {
                    System.out.print(", ");
                }
                count = 0;
            }
        }





    }
}
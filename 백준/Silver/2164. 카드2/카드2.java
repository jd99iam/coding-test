import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Deque<Integer> d = new LinkedList<>();
        for (int i=1; i<=num; i++){
            d.offerLast(i);
        }
        while (d.size()!=1){
            d.pollFirst();
            d.offerLast(d.pollFirst());
        }
        System.out.println(d.poll());
    }
}
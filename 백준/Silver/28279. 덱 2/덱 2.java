import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Deque<Integer> dq = new LinkedList<>();
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = in.nextInt();
        for (int i=0; i<count; i++){
           int  input = in.nextInt();
           switch (input) {
               case 1 : dq.offerFirst(in.nextInt()); break;
               case 2: dq.offerLast(in.nextInt()); break;
               case 3: {
                   if (dq.isEmpty()){
                       bf.write(-1+"\n");
                   } else {
                       bf.write(dq.pollFirst()+"\n");
                   }
               }
                 break;
               case 4:
                   if (dq.isEmpty()){
                   bf.write(-1+"\n");
               } else {
                   bf.write(dq.pollLast()+"\n");
               }
                   break;
               case 5:
                   bf.write(dq.size()+"\n"); break;
               case 6:{
                   if (dq.isEmpty()) {
                       bf.write(1 + "\n");
                   } else {
                       bf.write(0 + "\n");
                   }
                   break;
           }
               case 7:{
                   if (!dq.isEmpty()){
                       bf.write(dq.peekFirst() + "\n");
                   } else {
                       bf.write(-1 + "\n");
                   }
                   break;
               }
               case 8:{
                   if (!dq.isEmpty()){
                       bf.write(dq.peekLast() + "\n");
                   } else {
                       bf.write(-1 + "\n");
                   }
                   break;
               }

           }

        }

        bf.flush();
        bf.close();
    }
}
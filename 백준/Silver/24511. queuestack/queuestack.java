import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> qs = new LinkedList<>();
        int[] isQ = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<count; i++){
            isQ[i] = Integer.valueOf(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<count; i++){
            int input = Integer.valueOf(st2.nextToken());
            if (isQ[i]==0){
                qs.offerLast(input);
            }
        }


        int inputCount = Integer.valueOf(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i=0; i<inputCount; i++){
            qs.offerFirst(Integer.valueOf(st3.nextToken()));
            bw.write(String.valueOf(qs.pollLast())+" ");
        }

        bw.flush();
        bw.close();

    }

}
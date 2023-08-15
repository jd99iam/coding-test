import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<num; i++){
            int input = in.nextInt();
            hm.put(input,hm.getOrDefault(input,0)+1);
        }

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = in.nextInt();
        for (int i=0; i<m; i++){
            int input = in.nextInt();
            Integer result = hm.getOrDefault(input, 0);
            bf.write(String.valueOf(result+" "));
            // System.out.print(result+" ");
        }
        bf.flush();
        bf.close();

    }
}
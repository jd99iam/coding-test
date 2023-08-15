import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        int[] origin = new int[count];

        for (int i=0; i<count; i++){
            origin[i] = in.nextInt();
        }

        int[] sorted = new int[count];
        for (int i=0; i<count; i++){
            sorted[i] = origin[i];
        }

        Arrays.sort(sorted);

        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<count; i++){
            if (!map.containsKey(sorted[i])){
                map.put(sorted[i],map.size());
            }
        }

        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i=0; i<count; i++){
            br.write(map.get(origin[i])+" ");
        }
        br.flush();
        br.close();
    }
}
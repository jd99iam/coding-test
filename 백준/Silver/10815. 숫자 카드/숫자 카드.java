import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)  throws IOException{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for (int i=0; i<n; i++){
            hm.put(in.nextInt(),0);
        }
        
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int m = in.nextInt();
        for (int i=0; i<m; i++){
            int input = in.nextInt();
            if (hm.containsKey(input)){
                br.write(1+" ");
            } else {
                br.write(0+" ");
            }
        }
        br.flush();
        br.close();

    }
}
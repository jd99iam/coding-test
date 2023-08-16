import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        HashMap<String,Integer> hm = new HashMap<>();
        for (int i=0; i<input.length(); i++){
            for (int j=i+1; j<=input.length(); j++){
                String sub = input.substring(i,j);
                if (!hm.containsKey(sub)){
                    hm.put(sub,0);
                    // System.out.println("sub = " + sub);
                }
            }
        }

        System.out.println(hm.size());

    }
}
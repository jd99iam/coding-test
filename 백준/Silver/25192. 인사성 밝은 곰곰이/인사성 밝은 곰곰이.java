import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        HashMap<String,Integer> hm = new HashMap<>();

        int inputCount = in.nextInt();

        int gomCount = 0;
        for (int i=0; i<inputCount; i++){
            String input = in.next();
            if (input.equals("ENTER")){
                hm.clear();
            } else {
                if (!hm.containsKey(input)){
                    gomCount+=1;
                    hm.put(input,1);
                }
            }
        }

        System.out.println(gomCount);

    }

}
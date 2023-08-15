import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int num1 = in.nextInt();
        int num2 = in.nextInt();


        HashMap<String,Integer> dm = new HashMap<>();
        HashMap<String,Integer> bm = new HashMap<>();

        for (int i=0; i<num1; i++){
            dm.put(in.next(),0);
        }
        for (int i=0; i<num2; i++){
            bm.put(in.next(),0);
        }

        List<String> list = new ArrayList<>();

        int count = 0;
        for (String s: dm.keySet()){
            if (bm.containsKey(s)){
                count+=1;
                list.add(s);
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }



    }
}
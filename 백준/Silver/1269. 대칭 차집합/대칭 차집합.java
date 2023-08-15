import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int num1 = in.nextInt();
        int num2 = in.nextInt();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i=0; i<num1; i++){
            set1.add(in.nextInt());
        }
        for (int i=0; i<num2; i++){
            set2.add(in.nextInt());
        }

        int count = 0;

        for (Integer i : set1){
            if (!set2.contains(i)){
                count+=1;
           
            }
        }

        for (Integer i : set2){
            if (!set1.contains(i)){
                count+=1;
         
            }
        }

        System.out.println(count);


    }
}

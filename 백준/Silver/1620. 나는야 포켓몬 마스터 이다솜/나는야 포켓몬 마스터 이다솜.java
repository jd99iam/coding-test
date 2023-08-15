import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        HashMap<String,Integer> hm1 = new HashMap<>();
        HashMap<Integer,String> hm2 = new HashMap<>();

        for (int i=1; i<=n; i++){
            String input = in.next();
            hm1.put(input,i);
            hm2.put(i,input);
        }

        for (int i=0; i<m; i++){
            String input = in.next();
            if (input.matches("\\d+")){
                int num = Integer.parseInt(input);
                System.out.println(hm2.get(num));
            } else {
                System.out.println(hm1.get(input));
            }
        }


    }
}
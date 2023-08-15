import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        HashMap<String, Integer> hm = new HashMap<>();


        for (int i=0; i<input; i++){
            String s1 = in.next();
            String s2 = in.next();
            if (s2.equals("enter")){
                hm.put(s1,1);
            } else {
                hm.put(s1,0);
            }
        }


        Set<String> strings = hm.keySet();
        List<String> sL = new ArrayList<>();

        for (String  s: hm.keySet()) {
            if (hm.get(s)==1){
               sL.add(s);
            }
        }
        Collections.sort(sL,Collections.reverseOrder());
        for (String s : sL) {
            System.out.println(s);
        }

    }
}
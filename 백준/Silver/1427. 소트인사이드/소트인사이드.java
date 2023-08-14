import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (input!=0){
            list.add(input%10);
            input = input/10;
        }
        Collections.sort(list,Collections.reverseOrder());
        for (Integer i : list){
            System.out.print(i);
        }
    }
}

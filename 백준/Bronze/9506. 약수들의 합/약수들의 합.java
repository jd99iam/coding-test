import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true){
            int a = in.nextInt();
            if (a==-1){
                return;
            }
            int sum = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i=1;i<a;i++){
                if (a%i==0){
                    sum+=i;
                    arr.add(i);
                }
            }
            if (sum==a){
                System.out.print(a+" =");
                for (int i=0; i<arr.size(); i++){
                    if (i==0){
                        System.out.print(" "+arr.get(i));
                    } else {
                        System.out.print(" + "+arr.get(i));
                    }
                }
                System.out.println();
            } else {
                System.out.println(a+" is NOT perfect.");
            }
        }

    }
}

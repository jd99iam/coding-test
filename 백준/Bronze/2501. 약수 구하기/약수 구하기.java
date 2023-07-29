import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int count = 0;
        for (int i=1;i<=a;i++){
            if (a%i==0){
                count+=1;
            }
            if (count==b){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
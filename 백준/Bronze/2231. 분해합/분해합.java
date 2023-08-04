import java.util.*;
public class Main {

    public static int divSum(int num){
        int sum = 0;
        while (num!=0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        // 입력받기
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i=1;i<=n;i++){
            if ((i+divSum(i))==n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);


    }
}

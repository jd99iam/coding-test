import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[3];

        int max = 0;
        int maxIdx = 0;
        for (int i=0; i<3; i++){
            arr[i] = in.nextInt();
            if (arr[i]>max){
                max = arr[i];
                maxIdx = i;
            }
        }
        int sum = 0;
        for (int i=0; i<3; i++){
            if (i!=maxIdx){
                sum+= arr[i];
            }
        }
        if (sum>max){
            System.out.println(sum+max);
            return;
        }

        System.out.println(sum+sum-1);






    }
}

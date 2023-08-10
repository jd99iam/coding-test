import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
        int sum = 0;
        int[] arr = new int[5];
        for (int i=0; i<5; i++){
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        System.out.println(sum/5);
        System.out.println(arr[2]);

    }
}
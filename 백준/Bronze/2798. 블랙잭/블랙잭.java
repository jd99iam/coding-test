import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 입력받기
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[count];
        for (int i=0; i<count; i++){
            arr[i] = in.nextInt();
        }

        int sum = 0;
        int minus = 100000;
        for (int i=0; i<count; i++){
            for (int j=i+1; j<count; j++){
                for (int k=j+1; k<count; k++){
                    int now = arr[i]+arr[j]+arr[k];
                    if (m-now<minus&&m-now>=0){
                        minus = m-now;
                        sum = arr[i]+arr[j]+arr[k];
                    }
                }
            }
        }

        System.out.println(sum);

    }
}

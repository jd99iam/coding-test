import java.io.IOException;
import java.util.*;

public class Main{

    public static int euc(int a, int b){
        if (a%b==0) return b;
        else {
            return euc(b,a%b);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 심어져 있는 가로수의 개수 3
        int count = in.nextInt();

        // 심어져 있는 가로수 개수 - 1 = 간격의 개수      2
        int disCount = count-1;

        // 가로수 배열
        int[] ar = new int[count];

        // 가로수 입력받기     8    16   23
        for (int i=0; i<count; i++){
            ar[i] = in.nextInt();
        }

        // 간격 배열
        int[] arr = new int[disCount];

        // 간격 입력 i+1번째 가로수 좌표 - i번째 가로수 좌표       8    7
        for (int i=0; i<disCount; i++){
            arr[i] = ar[i+1]-ar[i];
        }


        int min = arr[0];      // 8
        for (int i=0; i<disCount; i++){
            if (min>arr[i]){     //1
                min = euc(min,arr[i]);
            }
            else {
                min = euc(arr[i],min);
            }
        }

        System.out.print((ar[count-1]-ar[0])/min-arr.length);

    }
}
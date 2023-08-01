import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[3];


        while (true){

            int max = 0;

            arr[0] = in.nextInt();
            arr[1] = in.nextInt();
            arr[2] = in.nextInt();

            // 0 일 경우 종료
            if (arr[0]==0) return;

            // invalid인지 확인
            int sum = 0;
            int maxIndex = -1;
            for (int i=0; i<3; i++){
                if (max<arr[i]) {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            for (int i=0; i<3; i++){
                if (i!=maxIndex){
                    sum+=arr[i];
                }
            }
            if (sum<=arr[maxIndex]){
                System.out.println("Invalid");
                continue;
            }



            int count = 0;
            for (int i=0; i<3; i++){
                for (int j=i+1; j<3; j++){
                    if (arr[i]==arr[j]){
                        count+=1;
                    }
                }
            }

            switch (count){
                case 0 :
                    System.out.println("Scalene"); break;
                case 1:
                    System.out.println("Isosceles" ); break;
                case 3:
                    System.out.println("Equilateral"); break;
            }



        }


    }
}

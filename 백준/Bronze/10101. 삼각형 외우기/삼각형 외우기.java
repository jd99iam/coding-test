import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[3];

        int sum = 0;

        for (int i=0;i<3;i++){
            arr[i] = in.nextInt();
            sum+=arr[i];
        }
        if (sum!=180) System.out.println("Error");
        else {
            /*
            세 각이 모두 60
            두 각이 같음
            같은 각이 없음
             */

            int sameCount = 0;
            for (int i=0; i<3; i++){
                for (int j=i+1; j<3; j++){
                    if (arr[i]==arr[j]){
                        sameCount+=1;
                    }
                }
            }
            switch (sameCount){
                case 0:
                    System.out.println("Scalene"); break;
                case 1:
                    System.out.println("Isosceles"); break;
                case 3:
                    System.out.println("Equilateral"); break;
            }


        }



    }
}

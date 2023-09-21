import java.util.Scanner;

public class Main {

    static int[] larger;
    static int[] lesser;
    static int[] input;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        input = new int[N];
        larger = new int[N];
        lesser = new int[N];
        for (int i=0; i<N; i++){
            input[i] = in.nextInt();
        }

        for (int i=0; i<N; i++){
            largeDp(i);
            lessDp(i);
        }

//        for (int a : larger){
//            System.out.print(a+" ");
//        }
//        System.out.println();
//        for (int a : lesser){
//            System.out.print(a+" ");
//        }
//        System.out.println();


        int max = -1;
        for (int i=0; i<N; i++){
            if (larger[i]+lesser[i]>max){
                max = larger[i]+lesser[i];
            }
        }

        System.out.println(max-1);

    }

    private static int largeDp(int n) {
        
        if (larger[n]==0){
            
            larger[n]=1;

            for (int i=n-1; i>=0; i--){
                if (input[i]<input[n]){
                     larger[n] = Math.max(larger[n],largeDp(i)+1);
                }
            }
        }
        return larger[n];
    }

    private static int lessDp(int n) {
        if (lesser[n]==0){
            lesser[n]=1;

            for (int i=n+1; i<lesser.length; i++){
                if (input[i]<input[n]){
                    lesser[n] =  Math.max(lesser[n],lessDp(i)+1);
                }
            }
        }
        return lesser[n];
    }

}
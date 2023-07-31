import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int w = in.nextInt();
        int h = in.nextInt();

        int[] arr = new int[4];
        arr[0] = getDistance(x,0);
        arr[1]= getDistance(x,w);
        arr[2]=getDistance(y,0);
        arr[3] =getDistance(y,h);

        int min = 9999999;
        for (int i : arr){
            if(min>i){
                min = i;
            }
        }
        System.out.println(min);




    }

    public static int getDistance(int a, int b){
        if (a-b>=0){
            return a-b;
        } else return b-a;
    }
}

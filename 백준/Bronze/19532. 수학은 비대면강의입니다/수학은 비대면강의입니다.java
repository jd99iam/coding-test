import java.util.*;
public class Main {

    public static void main(String[] args) {
        // 입력받기
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int e = in.nextInt();
        int f = in.nextInt();
        int x = 0;
        int y = 0;
        for (int i=-999; i<=999; i++){
            for (int j=-999; j<=999; j++){
                x = i;
                y= j;
                if ((a*x+b*y)==c&&(d*x+e*y)==f){
                    System.out.println(x+" "+y);
                }
            }
        }

    }
}

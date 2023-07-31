import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public boolean isDiff(Point p){
        if (this.x!=p.x&&this.y!=p.y) return true;
        else return false;
    }
}

public class Main {

    public static int distance(int a, int b){
        if (a-b>0) return a-b;
        else return b-a;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Point[] arr = new Point[4];

        for (int i=1; i<=3; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            arr[i] = new Point(x,y);
        }

        int p1 = 0;
        int p2 = 0;

        for (int i=1; i<=3; i++){
            for (int j=i+1; j<=3; j++){
                if (arr[i].isDiff(arr[j])) {
                    if (arr[i].x<arr[j].x){
                        p1=i;
                        p2=j;
                    } else {
                        p1 = j;
                        p2 = i;
                    }
                    break;
                }
            }
            if (p1!=0) break;
        }

        int x = distance(arr[p1].x,arr[p2].x);
        int y = distance(arr[p1].y,arr[p2].y);

        for (int i=1; i<=3; i++){
            if (i!=p1&&i!=p2){
                if (arr[i].x==arr[p1].x){
                    System.out.print(arr[p1].x+x+" "+arr[p1].y);
                } else {
                    System.out.print(arr[p2].x-x+" "+arr[p2].y);
                }
            }
        }


    }
}

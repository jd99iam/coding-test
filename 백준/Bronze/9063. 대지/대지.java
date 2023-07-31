import java.util.*;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int inputNum = in.nextInt();
        ArrayList<Point> list = new ArrayList<>();
        for (int i=0;i<inputNum;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            Point p = new Point(x,y);
            list.add(p);
        }

        int left=10000;
        int right = -10000;
        int top = -10000;
        int bottom = 10000;

        for (Point p : list){
            if (p.x<left) left = p.x;
            if (p.x>right) right = p.x;
            if (p.y>top) top = p.y;
            if (p.y<bottom) bottom = p.y;
        }
        System.out.println((right-left)*(top-bottom));

    }
}
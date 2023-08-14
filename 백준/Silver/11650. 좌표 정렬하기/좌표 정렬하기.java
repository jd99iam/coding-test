import java.util.*;

class Point implements Comparable{
    
    int x;
    int y;
    
    public int compareTo(Object o){
        Point p = (Point)o;
        if (x==p.x) return y-p.y;
        else return x-p.x;
    }
    
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] arr = new Point[n];
        for (int i=0; i<n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            Point p = new Point(x,y);
            arr[i] = p;
        }
        Arrays.sort(arr);
        for (Point p : arr){
            System.out.println(p.x+" "+p.y);
        }

    }
}
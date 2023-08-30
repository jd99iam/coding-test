import java.io.*;
import java.util.*;

public class Main{

    static int front = -1;
    static int rear = -1;
    static int[] q = new int[2000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    bf.write(String.valueOf(pop()));
                    bf.write("\n");
                    break;
                case "size":
                    bf.write(String.valueOf(size()));
                    bf.write("\n");
                    break;
                case "empty":
                    bf.write(String.valueOf(empty()));
                    bf.write("\n");
                    break;
                case "front":
                    bf.write(String.valueOf(front()));
                    bf.write("\n");
                    break;
                case "back":
                    bf.write(String.valueOf(back()));
                    bf.write("\n");
                    break;
            }
        }
        bf.flush();
        bf.close();
    }

    public static void push(int input){
        q[++rear] = input;
    }
    public static int pop(){
        if (empty()==1) return -1;
        return q[++front];
    }

    public static int size(){
        return rear-front;
    }

    public static int empty(){
        if (size()==0){
            return 1;
        } else {
            return 0;
        }
    }

    public static int front(){
        if (empty()==1){
            return -1;
        } else {
            return q[front+1];
        }
    }

    public static int back(){
        if (empty()==1){
            return -1;
        } else {
            return q[rear];
        }
    }
}
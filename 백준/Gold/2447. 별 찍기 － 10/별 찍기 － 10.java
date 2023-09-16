import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int input  = in.nextInt();

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[input][input];
        starIn(arr,0,0,input);

        for (int i=0; i<input; i++){
            for (int j=0; j<input; j++){
                if (arr[i][j]==1){
                    bf.write("*");
                } else {
                    bf.write(" ");
                }
            }
            bf.write("\n");
        }


        bf.flush();
        bf.close();

    }

    private static void starIn(int[][] arr, int xs, int ys, int length){

        if (length==1){
            arr[xs][ys]=1;
            return;
        }
        int count = 0;
        for (int i=xs; i<xs+length; i+=length/3){
            for (int j=ys; j<ys+length; j+=length/3){
                count+=1;
                if (count!=5){
                    starIn(arr,i,j,length/3);
                }
            }
        }
    }

}
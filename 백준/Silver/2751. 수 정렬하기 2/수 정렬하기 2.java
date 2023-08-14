import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        for (int i=0; i<n; i++){
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();

    }
}
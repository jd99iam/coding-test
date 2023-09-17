import java.io.*;
import java.util.*;

public class Main{

    public static int[] arr = {1,2,3};
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        // 원판의 개수 입력받기
        int count = in.nextInt();

        // 총 이동 횟수 (공식 2^n-1)
        bf.write(String.valueOf(hanoiCount(count))+"\n");

        // 과정 출력
        hanoi(1,2,3,count, bf);
        
        bf.flush();
        bf.close();
    }

    public static void hanoi(int start, int mid, int end, int count, BufferedWriter bf) throws IOException {

        if (count==1){
            bf.write(start+" "+end+"\n");
            return;
        }
        hanoi(start,end,mid,count-1, bf);

        hanoi(start,mid,end,1, bf);

        hanoi(mid,start,end,count-1, bf);
    }

    public static int hanoiCount(int count){
        int answer = 1;
        for (int i=1; i<=count; i++){
            answer *=2;
        }
        return answer-1;
    }

}
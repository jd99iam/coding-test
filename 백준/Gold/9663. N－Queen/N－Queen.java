import java.util.*;


public class Main{

    public static int N=0;
    public static int count=0;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();

        // 열 정보만 담는 1차원 배열
        int[] chess = new int[N];

        nQueen(0,chess);
        System.out.println(count);

    }

    // 백트래킹 하는 함수
    public static void nQueen(int row, int[] chess){
        if (row==N){
            count+=1;
            return;
        }

        for (int i=0; i<N; i++){
            chess[row] = i;
            if (promising(row,chess)){
                nQueen(row+1,chess);
            }
        }
    }

    // 유망성 판단하는 함수
    private static boolean promising(int row, int[] chess) {
        for (int i=0; i<row; i++){
            if (chess[row]==chess[i]||(row-i==Math.abs(chess[row]-chess[i]))){
                return false;
            }
        }
        return true;
    }


}
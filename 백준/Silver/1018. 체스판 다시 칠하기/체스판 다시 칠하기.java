import java.util.*;
public class Main {

    public static void main(String[] args) {
        // 입력받기
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] arr = new char[n][m];
        for (int i=0; i<n; i++){
            String input = in.next();
            for (int j=0; j<m; j++){
                arr[i][j] = input.charAt(j);
            }
        }
        // 입력받기 끝

        // 모범 체스판 2개 만들기
        char[][] case1 = new char[8][8];
        char[][] case2 = new char[8][8];
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if ((i+j)%2==0){
                    case1[i][j]='B';
                    case2[i][j]='W';
                } else {
                    case1[i][j]='W';
                    case2[i][j]='B';
                }
            }
        }
        // 모범 체스판 끝


        // 주어진 체스판에서 8*8 형태를 고르고 모범 체스판과 비교해서 칠해야 할 개수를 구한다

        int count = 2500;

        for (int i=0; i<=n-8; i++){
            for (int j=0; j<=m-8; j++){
                int count1 = 0;
                int count2 = 0;
                for (int k=i; k<i+8; k++){
                    for (int l=j; l<j+8; l++){
                        if (arr[k][l]!=case1[k-i][l-j]) count1+=1;
                        if (arr[k][l]!=case2[k-i][l-j]) count2+=1;
                    }
                }
                if (count>count1) count=count1;
                if (count>count2) count=count2;
            }
        }
        System.out.println(count);

    }
}

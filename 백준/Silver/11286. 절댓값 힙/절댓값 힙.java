
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;



public class Main{
	public static void main(String[] args) throws IOException {
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				int r1=o1,r2=o2;
				if (o1<0) {
					r1=-o1;
				} 
				if (o2<0) {
					r2=-o2;
				}
				if (r1==r2) {
					return o1-o2;
				}
				return r1-r2;
			}
		};
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comp);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input!=0) {
				pq.offer(input);
			} else {
				if (pq.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(pq.poll());
				}
			}
		}
	}
}
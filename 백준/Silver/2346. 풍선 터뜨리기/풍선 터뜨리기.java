
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Balloon{
	public int value;
	public int order;
	
	public Balloon(int value, int order) {
		this.value = value;
		this.order = order;
	}
}


public class Main{
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Deque<Balloon> dq = new ArrayDeque<Balloon>();
				
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			int val = Integer.parseInt(st.nextToken());
			dq.offer(new Balloon(val, i));
		}
		

		
		Balloon bal = dq.pollFirst();
		System.out.println(bal.order);


		while (!dq.isEmpty()) {
			if (bal.value>0) {
				for (int i=1; i<bal.value; i++) {
					Balloon out = dq.pollFirst();
					dq.offerLast(out);
				}
				bal = dq.pollFirst();
				System.out.println(bal.order);

				continue;
			}
			if (bal.value<0) {
				for (int i=-1; i>bal.value; i--) {
					Balloon out = dq.pollLast();
					dq.offerFirst(out);
				}
				bal = dq.pollLast();
				System.out.println(bal.order);

				continue;
			}
		}
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				if(a==b) {
					return o1 - o2;
				}
				return a-b;
			}
		});
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());
				} else {
					System.out.println(0);
				}
				continue;
			}
			pq.offer(input);
		}
	}

}
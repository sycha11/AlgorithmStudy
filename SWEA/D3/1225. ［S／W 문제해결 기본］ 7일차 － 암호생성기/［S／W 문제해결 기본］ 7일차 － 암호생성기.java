import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			Queue<Integer> q = new LinkedList<>();
			
			for(int i=0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
	outer: while(true) {
				for(int i=1; i<=5; i++) {
					int out = q.poll();
					int in = out - i;
					
					if(in <= 0) {
						q.add(0);
						break outer;
					} else {
						q.add(in);
					}
				}
			}
			System.out.print("#" + tc + " ");
			
			for(int i=0; i<8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
		
	}

}
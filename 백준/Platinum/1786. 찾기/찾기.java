
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();

		ArrayList<Integer> ans = new ArrayList<>();
		
		int[] pi = new int[P.length];
		pi[0] = 0;
		
		int idx = 0;
		//pi
		for(int i=1; i<P.length; i++) {
			while(idx>0 && P[i] != P[idx]) {
				idx = pi[idx-1];
			}
			
			if(P[i] == P[idx]) {
				idx++;
				pi[i] = idx;
			}
		}
		
		idx = 0;
		for(int i=0; i<T.length; i++) {
			while(idx>0 && T[i] != P[idx]) {
				idx = pi[idx-1];
			}
			if(T[i] == P[idx]) {
				if(idx == P.length-1) {
					ans.add(i-idx+1);
					idx = pi[idx];
				} else {
					idx += 1;
				}
			}
		}
		System.out.println(ans.size());
		for(Integer i : ans) {
			System.out.println(i);
		}
		
	}

}

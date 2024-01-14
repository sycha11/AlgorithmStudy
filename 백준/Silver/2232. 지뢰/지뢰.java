import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	static int n;
	static int[] bomb;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		bomb = new int[n];
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<n; i++) {
			bomb[i] = Integer.parseInt(br.readLine());
		}
		if(n == 1) {
			answer.add(1);
		} else {
			if(bomb[0] >= bomb[1]) {
				answer.add(1);
			}
			for(int i=1; i<n-1; i++) {
				if(bomb[i] >= bomb[i-1] && bomb[i] >= bomb[i+1]) {
					answer.add(i+1);
				}
			}
			if(bomb[n-1] >= bomb[n-2]) {
				answer.add(n);
			}
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

}
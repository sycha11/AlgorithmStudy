import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int n;
	static boolean flag = false;
	
	static void make() {
		parent = new int[n];
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA != parentB) {
			parent[parentB] = parentA;
		} else {
			flag = true;
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		make();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
			if(flag) {
				answer = i+1;
				break;
			}
		}
		System.out.println(answer);
		
		
	}

}
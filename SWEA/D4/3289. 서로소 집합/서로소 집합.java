import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static int N,M;
	static int parents[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		

		
		for (int i = 1; i < TC+1; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st2.nextToken());
			M = Integer.parseInt(st2.nextToken());
			make();
			bw.write("#" + i + " ");
			for (int j = 0; j < M; j++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st3.nextToken());
				int a = Integer.parseInt(st3.nextToken());
				int b = Integer.parseInt(st3.nextToken());
				
				if (cal==0) {
					union(a,b);
				}
				else {
					if (check(a,b)) {
						bw.write(1 + "");
					}
					else {
						bw.write(0 + "");
					}
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void make() {
		parents = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static boolean check(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return true;
		}
		else {
			return false;
		}
		
	}
	

}
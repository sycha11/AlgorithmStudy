import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static StringBuilder sb; 
	
	public static void main(String[] args) throws IOException{
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int n = Integer.parseInt(br.readLine());
		 
		 map = new int[n][n];
		 sb = new StringBuilder();
		 
		 for(int i=0; i<n; i++) {
			 String str = br.readLine();
			 for(int j=0; j<n; j++) {
				 map[i][j] = str.charAt(j) - '0';
			 }
		 }
		 
		 recu(0,0,n);
		 System.out.println(sb);
	}

	static boolean check(int x, int y, int n) {
		int k = map[x][y];
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(k != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void recu(int x, int y, int n) {
		int half = n/2;
		
		// 모두 1이나 0으로만 되어 있다면 return
		if(check(x,y,n)) {
			sb.append(map[x][y]);
			return;
		}
		sb.append('(');
		recu(x,y, half); // 왼쪽위
		recu(x,y+half, half); // 오른쪽위
		recu(x+half,y,half); // 왼쪽아래
		recu(x+half,y+half,half); // 오른쪽아래
		sb.append(')');
	}
	
}
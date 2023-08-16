import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N,r,c;
	static int[][] map;
	static int cnt =0;
	static int answer = 0;
	static boolean flag;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		r = Integer.parseInt(s[1]);
		c = Integer.parseInt(s[2]);
		
		int n = (int)Math.pow(2, N);
		
		
		square(0,0,n,0);
		
	}
	
	private static void square(int x, int y, int size, int num) {
		if(r < x || c < y || r > x+size || c > y+size ) return;
		if(size == 1) {
			if(x==r && y==c) System.out.println(num);
			return;
		}
		
		int half = size/2;
		
		square(x,y,half, num);
		square(x,y+half, half, num + half*half);
		square(x+half, y, half, num + 2*(half*half));
		square(x+half, y+half, half, num + 3*(half*half));
	}

}
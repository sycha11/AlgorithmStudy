
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N,M;
	static int[][] map;
	static ArrayList<Point> person;
	static ArrayList<Point> chicken;
	static int min;
	static boolean[] open;
	
	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		person = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = sc.nextInt();
				// 집 좌표 저장
				if(map[i][j] == 1) {
					person.add(new Point(i,j));
				}
				// 치킨 집 좌표 저장
				if(map[i][j] == 2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		min = Integer.MAX_VALUE;
		open = new boolean[chicken.size()];
		
		DFS(0,0);
		System.out.println(min);
		
	}
	
	public static void DFS(int start, int depth) {
		if(depth == M) {
			int sum = 0;
			
			for(int i=0; i<person.size(); i++) {
				int disMin = Integer.MAX_VALUE;
				
				for(int j=0; j <chicken.size(); j++) {
					if(open[j] == true) {
						int distance = Math.abs(person.get(i).x -chicken.get(j).x) + Math.abs(person.get(i).y - chicken.get(j).y);
						disMin = Math.min(disMin, distance);
					}
				}
				sum += disMin;
			}
			min = Math.min(min, sum);
			return;
		}
	
		for(int i=start;i<chicken.size();i++) {
			open[i] = true;
			DFS(i+1, depth+1);
			open[i] = false;
		}
	}
	
}

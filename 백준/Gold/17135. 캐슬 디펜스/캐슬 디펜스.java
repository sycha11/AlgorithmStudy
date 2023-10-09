import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n,m,d;
	static int[][] map;
	static int[][] save;
	static int[] gungsu;
	static int max;
	static ArrayList<int[]> list;
	static int res;
	
	static class Node implements Comparable<Node>{
		int x,y,dist;
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			if(this.dist == o.dist) { // 거리가 같으면 왼쪽 거 먼저
				return this.y - o.y;
			} else {
				return this.dist - o.dist; // 거리가 더 작은 거
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m];
		save = new int[n+1][m];
		gungsu = new int[3]; // 궁수리스트
		list = new ArrayList<>(); // 적들 리스트
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					list.add(new int[] {i,j});
				}
				save[i][j] = map[i][j];
			}
		}
		res=0;
		combi(0,0);
		System.out.println(res);
	}
	
	private static void combi(int cnt, int start) {
		if(cnt == 3) {
			// 죽임
			ArrayList<int[]> data = copy(list);
			kill(data);
			return;
		}
		
		for(int i=start; i<m; i++) {
			gungsu[cnt] = i;
			combi(cnt+1, start+1);
		}
	}
	
	private static void kill(ArrayList<int[]> list) {
		int cnt = 0; // 공격한 적 수
		
		while(true) {
			if(list.size() == 0) { // 적들이 없으면 탈출
				break;
			}
			ArrayList<int[]> target = new ArrayList<>(); // 궁수 3명이 공격하고자 하는 적의 좌표
			
			for(int k=0; k<3; k++) {
				PriorityQueue<Node> pq = new PriorityQueue<>();
				
				for(int i=0; i<list.size(); i++) {
					int[] cur = list.get(i);
					int distance = manhatten(cur[0], cur[1], n, gungsu[k]);
					if(distance <= d) { // 사정거리 안에 있는 적들을 pq에 넣음
						pq.add(new Node(cur[0], cur[1], distance));
					}
				}
				
				if(!pq.isEmpty()) {
					Node enemy = pq.poll(); // 가장 가까운 적임
					boolean flag = false;
					for(int i=0; i<target.size(); i++) {
						int[] cur2 = target.get(i);
						// 다른 궁수가 잡은걸 체크
						if(enemy.x == cur2[0] && enemy.y == cur2[1]) {
							flag = true;
						}
					}
					if(flag == false) {
						target.add(new int[] {enemy.x, enemy.y});
					}
				}
			}
			
			// target 리스트에 있는 애들 list에서 제거
			for(int i=0; i<target.size(); i++) {
				for(int j=list.size()-1; j>=0; j--) {
					if (target.get(i)[0] == list.get(j)[0] && target.get(i)[1] == list.get(j)[1]) {
						list.remove(j);
						cnt++;
						break;
					}
				}
			}
			// 적들 아래로 이동
			for(int i=list.size()-1; i>=0; i--) {
				list.get(i)[0] += 1;
				if(list.get(i)[0] == n) { // n으로 넘어가면 삭제
					list.remove(i);
				}
			}
		}
		res = Math.max(res, cnt);
	}
	
	private static int manhatten(int x1, int x2, int y1, int y2) {
		return Math.abs(x1-y1) + Math.abs(x2-y2);
	}
	
	// 적들 좌표 리스트 원복
	private static ArrayList<int[]> copy(ArrayList<int[]> lists){
		ArrayList<int[]> tmp = new ArrayList<>();
		for(int i=0; i<lists.size(); i++) {
			int[] cur = lists.get(i);
			tmp.add(new int[] {cur[0], cur[1]});
		}
		return tmp;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int S;
	static boolean[][] visited;
	
	static class Node{
		int screenEmo; // 화면에 있는 이모티콘
		int clipboardEmo; // 클립보드에 있는 이모티콘
		int time; // 누적 시간
		
		public Node(int screenEmo, int clipboardEmo, int time) {
			this.screenEmo = screenEmo;
			this.clipboardEmo = clipboardEmo;
			this.time = time;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Integer.parseInt(br.readLine());
		
		bfs();
	}
	
	static void bfs() {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1,0,0)); // 화면이모티콘, 클립보드이모티콘, 시간
		
		visited = new boolean[1001][1001];
		visited[1][0] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			int se = node.screenEmo;
			int ce = node.clipboardEmo;
			int time = node.time;
			
			// 기저조건
			if(se == S) {
				System.out.println(time);
				return;
			}
			
			// 1번조건 : 화면에 클립보드 저장
			if(se != 0 && !visited[se][se]) {
				visited[se][se] = true;
				q.add(new Node(se, se, time+1));
			}
			
			// 2번조건 : 클립보드에 있는거 화면에 추가
			if(ce != 0 && se+ce <= 1000 && !visited[se+ce][ce]) {
				visited[se+ce][ce] = true;
				q.add(new Node(se + ce, ce, time+1));
			}
			
			// 3번조건 : 화면 - 1
			if(se >= 1 && !visited[se-1][ce]) {
				visited[se-1][ce] = true;
				q.add(new Node(se-1, ce, time+1));
			}
		}
	}

}
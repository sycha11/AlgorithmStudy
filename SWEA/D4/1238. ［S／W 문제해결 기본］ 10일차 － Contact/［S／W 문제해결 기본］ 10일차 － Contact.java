import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, start;
	static int from, to;
	static int max_cnt, max_num;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		for (int TC = 1; TC <= 10; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			visited = new boolean[101];
			for (int i = 0; i <= 100; i++)
	            graph.add(new ArrayList<>()); //각 노드 별 리스트를 만들어준다.
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				putEdge(graph,from,to);
			}
			
			Queue<Integer> queue = new LinkedList<>();
			max_num = start;
			max_cnt = 0;
			queue.add(start);
			queue.add(0);
			visited[start] = true;
			while (!queue.isEmpty()){
				int a = queue.poll();
				int cnt = queue.poll();
				if (max_cnt<cnt){
					max_cnt = cnt;
					max_num = a;
				}
				if ((max_cnt==cnt) && (max_num<a)) {
					max_num = a;
				}
				for (Integer i : graph.get(a)) {
					if (visited[i] == false) {
						visited[i] = true;
						queue.add(i);
						queue.add(cnt+1);	
					}

				}
			}
			
			System.out.println("#"+TC+" "+max_num);
		}
		
	}
	
	public static void putEdge(ArrayList<ArrayList<Integer>> graph, int x, int y) {
        if (!graph.get(x).contains(y)) {
        	graph.get(x).add(y);
        }
    }
	
	

}
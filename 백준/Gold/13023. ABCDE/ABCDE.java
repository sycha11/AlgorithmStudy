import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
 
	static int N,M;
	static boolean[] visited;
	static boolean flag = false;
	static ArrayList<ArrayList<Integer>> graph;

    public static void putEdge(ArrayList<ArrayList<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
 
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>()); //각 노드 별 리스트를 만들어준다.
        
        for (int i = 0; i < M; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st2.nextToken());
    		int b = Integer.parseInt(st2.nextToken());
        	putEdge(graph, a, b);
		}
        
        for (int i = 0; i < N; i++) {
			if (!flag) {
				visited[i] = true;
				dfs(i,1);
				visited[i] = false;
			}
		}
        
        if (flag) {
        	System.out.println(1);
        }
        else {
        	System.out.println(0);
        }
        
    }
    
    public static void dfs(int i, int cnt) {
		for (Integer b : graph.get(i)) {
    		if (visited[b] == false) {
    			if (cnt == 4) {
    				flag =true;
    			}
    			else {
        			visited[b] = true;
        			dfs(b, cnt+1);
        			visited[b] = false;
    			}
			
    		}
    	}
    	
    	
    }
}
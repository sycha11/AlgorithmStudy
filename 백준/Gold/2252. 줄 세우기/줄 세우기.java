import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        for (int i = 0; i < N+1; i++) {
			indegree[i] = 0;
	        graph.add(new ArrayList<Integer>());
		}
        for (int i = 0; i < M; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st2.nextToken());
        	int B = Integer.parseInt(st2.nextToken());
        	graph.get(A).add(B);
        	indegree[B] +=1;
        }
        
        topologysort();
	}
	
	public static void topologysort() {
		Queue<Integer> q = new LinkedList<>();
		Deque<Integer> result = new ArrayDeque<>();
		
		for (int i = 1; i < N+1; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();
			result.add(now);
			for (int g : graph.get(now)) {
				indegree[g] -=1;
				if (indegree[g] == 0) {
					q.add(g);
				}
					
			}
		}
		
		for (Integer i : result) {
			System.out.print(i+" " );
		}
		
	}

}
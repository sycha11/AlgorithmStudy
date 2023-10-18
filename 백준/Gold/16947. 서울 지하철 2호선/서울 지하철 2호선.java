

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


// 순환선을 찾고
// 거리를 구한다.
public class Main {

	static int n;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean f;
	static boolean[] isCycle;
	static int[] dist;
	static Stack<Integer> st;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		isCycle = new boolean[n+1];
		dist = new int[n+1];
		st = new Stack<>();
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
			isCycle[i] = false;
		}
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i, 1);
            }
        }
		
		// 순환선 찾기
		for(int i=1; i<=n; i++) {
			if(isCycle[i]) {
				System.out.print("0 ");
			} else { 
				Queue<Integer> q = new LinkedList<>();
				int[] d = new int[n+1];
				q.add(i);
				while(!q.isEmpty()) {
					int tmp = q.poll();
					if(isCycle[tmp]) { // 순환이면
						System.out.print(d[tmp] + " ");
						break;
					}
					for(Integer target : list[tmp]) {
						if(d[target] == 0) {
							d[target] = d[tmp] + 1;
							q.add(target);
						}
					}
				}
			}
		}
		System.out.println();
	}

	static int dfs(int x, int start) {
		st.push(x);
		dist[x] = start;
		visited[x] = true;
		
		int res = -1;
		 for (int target : list[x]) {
	            if (!visited[target]) { // 방문한 역	          
	                res = dfs(target, start + 1);
	            } else if (start - dist[target] >= 2) { // 거리가 2차이 나면
	                isCycle[target] = true;
	                res = target; // 타겟저장
	            } else {
	                continue;
	            }
	          
	            if (res != -1) {
	                while (st.size() > 0) {                    
	                    int temp = st.pop();
	                    isCycle[temp] = true;
	                    if (temp == res) {
	                        res = -1;
	                        break;
	                    }
	                }
	            }
	        }	     
	        if (st.size() > 0) {
	            st.pop();
	        }

	        return res;
	}
	
	
}

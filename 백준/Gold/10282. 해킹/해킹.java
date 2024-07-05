import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int idx,dis;
        public Node(int idx, int dis){
            this.idx = idx;
            this.dis = dis;
        }
        @Override
        public int compareTo(Node o){
            return this.dis - o.dis;
        }

    }

    static int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] list;
    static int n;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list = new ArrayList[n+1];
            dist = new int[n+1];
            visited = new boolean[n+1];

            for(int i=0; i<=n; i++){
                list[i] = new ArrayList<>();
                dist[i] = INF;
            }
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Node(a,s));
            }

            dijkstra(c);
            int computer = 0;
            int time = 0;

            for(int i=1; i<=n; i++){
                if(dist[i] != INF){
                    computer++;
                    time = Math.max(time, dist[i]);
                }
            }
            System.out.println(computer + " " + time);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            int cur = pq.poll().idx;

            if(!visited[cur]){
                visited[cur] = true;

                for(Node node : list[cur]){
                    if(dist[node.idx] > dist[cur] + node.dis){
                        dist[node.idx] = dist[cur] + node.dis;
                        pq.add(new Node(node.idx, dist[node.idx]));
                    }
                }
            }
        }
    }
}
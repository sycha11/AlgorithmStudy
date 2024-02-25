import java.io.*;
import java.util.*;
public class Main {

    static int n,m,x;
    static LinkedList<Node>[] list;

    static class Node implements Comparable<Node>{
        int num;
        int time;
        public Node(int num, int time){
            this.num = num;
            this.time = time;
        }
        @Override
        public int compareTo(Node o){
            return time - o.time;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new LinkedList[n+1];
//        visited = new boolean[n+1];


        for(int i=1; i<=n; i++){
            list[i] = new LinkedList<>();
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e,time));
        }


        int max = 0;
        for(int i=1; i<=n; i++){
            if(i == x){
                continue;
            }
            int tox = dijkstra(i,x);
            int toi = dijkstra(x,i);

            max = Math.max(max, tox+toi);

        }
        System.out.println(max);
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));


        while(!pq.isEmpty()){ // 비어 있지 않다면
            Node node = pq.poll();
            int num = node.num;
            int time = node.time;
//            System.out.println(node + " " + time);
            if(!visited[num]){
                visited[num] = true;
                for(int i=0; i<list[num].size(); i++){
                    int a = list[num].get(i).num;
                    int t = list[num].get(i).time;
//                    System.out.println(dist[a] + " " + dist[num] + " " + t);

                    if(!visited[a] && dist[a] > (dist[num] + t)){
                        dist[a] = dist[num] + t;
                        pq.add(new Node(a, dist[a]));
                    }
                }
            }
        }
        return dist[end];

    }

}
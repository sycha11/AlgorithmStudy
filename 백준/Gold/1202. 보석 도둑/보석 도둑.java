import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N,K;

    static class Node implements Comparable<Node>{
        int m,v;
        public Node(int m, int v){
            this.m = m;
            this.v = v;
        }
        @Override
        public int compareTo(Node o){
            if(this.m - o.m == 0){
                return o.v - this.v;
            }
            return this.m - o.m;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Node[] node = new Node[N];
        int[] bag = new int[K];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            node[i] = new Node(n1, n2);
        }

        for(int i = 0; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(node);
        Arrays.sort(bag);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long answer = 0;
        for(int i = 0, level = 0; i < K; i++){
            while (level < N){
                if(bag[i] >= node[level].m){
                    pq.offer(node[level++].v);
                } else{
                    break;
                }
            }
//            System.out.println(level + " " + pq.peek());
            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
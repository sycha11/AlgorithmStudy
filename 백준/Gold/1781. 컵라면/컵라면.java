import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static class Node implements Comparable<Node>{
        int deadline;
        int cup;

        public Node(int deadline, int cup){
            this.deadline = deadline;
            this.cup = cup;
        }

        // 데드라인은 오름차순
        // 데드라인이 같다면 컵라면 내림차순
        @Override
        public int compareTo(Node o){
            if(this.deadline - o.deadline < 0){
                return -1;
            } else if(this.deadline == o.deadline){
                if(this.cup - o.cup > 0){
                    return -1;
                } else if(this.cup == o.cup){
                    return 0;
                } else{
                    return 1;
                }
            } else{
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Node[] nodeList = new Node[N];
        long answer = 0;

        for(int i = 0; i < nodeList.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            nodeList[i] = new Node(n1, n2);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.parallelSort(nodeList);

        for(int i = 0; i < N; i++){
            if(pq.size() < nodeList[i].deadline){
                pq.add(nodeList[i].cup);
//                System.out.println(nodeList[i].deadline + " " + nodeList[i].cup);
            } else{
                int cup = pq.peek();
                if(cup < nodeList[i].cup){
//                    System.out.println(nodeList[i].deadline + " " + nodeList[i].cup);
                    pq.poll();
                    pq.add(nodeList[i].cup);
                } else{
//                    System.out.println("나가리: " + nodeList[i].deadline + " " + nodeList[i].cup);
                }
            }
//            System.out.println();
        }
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
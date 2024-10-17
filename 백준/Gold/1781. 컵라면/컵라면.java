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

        @Override
        public int compareTo(Node o){
            if(this.cup < o.cup){
                return 1;
            } else if(this.cup == o.cup){
                if(this.deadline > o.deadline){
                    return 1;
                } else if(this.deadline == o.deadline){
                    return 0;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Node[] nodeList = new Node[N];
        int answer = 0;

        for(int i = 0; i < nodeList.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            nodeList[i] = new Node(n1, n2);
        }

        Arrays.sort(nodeList, new Comparator<>(){
            @Override
            public int compare(Node o1, Node o2){
                if(o1.deadline < o2.deadline){
                    return 1;
                } else if(o1.deadline == o2.deadline){
                    return 0;
                } else{
                    return -1;
                }
            }
        });

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int cnt = 0;
        int sum = 0;

        for(int i = 200000; i >=1 ; i--){
            while(cnt < nodeList.length && nodeList[cnt].deadline == i){
                pq.add(nodeList[cnt++]);
            }
            if(pq.isEmpty()){
                continue;
            }

            sum += pq.poll().cup;

        }
        System.out.println(sum);

    }
}
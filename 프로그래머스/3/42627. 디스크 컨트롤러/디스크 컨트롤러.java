import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int start;
        int time;
        
        public Node(int start, int time){
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo(Node o){
            return this.time - o.time;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 정렬
        
         Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 테케 8, 18번
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        int len = jobs.length;
        int idx = 0;
        int end = 0;
        int cnt = 0;
            
        int totalTime = 0;
        
        // List<Integer> list = new ArrayList<>();
        
        while(cnt < len){
            
            // 현재 시간을 기준으로 작업할 수 있는 요청을 우선순위 큐에 추가
            if(idx < len){
                while(jobs[idx][0] <= end){
                    pq.add(new Node(jobs[idx][0], jobs[idx][1]));
                    idx++;
                    if(idx == len) break; // 
                }
            }
            
            // 현재 시간으로 작업할 요청이 없을 때
            if(pq.isEmpty()){
                if(idx < len){
                    pq.add(new Node(jobs[idx][0], jobs[idx][1]));
                    end = jobs[idx][0];
                    idx++;
                }
            }
            
            if(!pq.isEmpty()){
                Node node = pq.poll();
                totalTime += (end - node.start + node.time);
                end += node.time;
                cnt++;
            }
            
        
        }
        
        
        return totalTime/len;
    }
}
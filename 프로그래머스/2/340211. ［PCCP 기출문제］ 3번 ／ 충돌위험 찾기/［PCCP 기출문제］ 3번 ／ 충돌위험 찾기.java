import java.util.*;
class Solution {
    
    static class Node implements Comparable<Node>{
        int r,c,data;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        @Override
        public int compareTo(Node o){
            return this.data - o.data;
        }
    }
    
    int[] dx = {-1,1,0,0}; // 상하좌우
    int[] dy = {0,0,-1,1};
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        bfs(points);
        
        return answer;
    }
    
    static void bfs(int[][] points){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        
    }
}
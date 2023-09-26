
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{

	static class Node{
		int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] map;
	static ArrayList<Node> list =new ArrayList<>();
	static boolean flag;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 0) {
					list.add(new Node(i,j));
				}
			}
		}
		flag = false;
		sudoku(0);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static void sudoku(int idx) {
		// 0인것을 다 채우면 끝
		if(idx == list.size()) {
			flag = true;
			return;
		}
		
		Node cur = list.get(idx);
		
		for(int i=1; i<=9; i++) {
			map[cur.x][cur.y] = i;
			if(check33(cur.x, cur.y) && checkRow(cur.x, cur.y) && checkCol(cur.x, cur.y)) {
				sudoku(idx + 1);
			}
			if(flag) { // 다 돌았으면
				return;
			}
			
			map[cur.x][cur.y] = 0; // 원복
		}
	}
	
	// 영역 검사 3*3
	static boolean check33(int x, int y) {
		int sx = (x/3) * 3;
		int sy = (y/3) * 3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(sx+i != x || sy+j != y) {
					if(map[sx+i][sy+j] == map[x][y]) { // 같은게 있으면 X
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	// 가로 검사
	static boolean checkRow(int x, int y) {
		for(int i=0; i<9; i++) {
			if(y != i) {
				if(map[x][i] == map[x][y]) { // 같은게 있으면 x
					return false;
				}
			}
		}
		
		return true;
	}
	
	// 세로 검사
	static boolean checkCol(int x, int y) {
		for(int i=0; i<9; i++) {
			if(x != i) {
				if(map[i][y] == map[x][y]) { // 같은게 있으면 실패
					return false;
				}
			}
		}
		
		return true;
	}

}

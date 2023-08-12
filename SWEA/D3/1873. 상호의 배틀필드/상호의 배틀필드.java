import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] st = br.readLine().split(" ");
			int h = Integer.parseInt(st[0]);
			int w = Integer.parseInt(st[1]);
			char[][] map = new char[h][w];
			
			int nowX = 0;
			int nowY = 0;
			int dir = 0;
			for(int i=0; i<h; i++) {
				String s = br.readLine();
				for(int j=0; j<w; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '^' || map[i][j] == '>' || map[i][j] == '<' || map[i][j] == 'v') {
						nowX = i;
						nowY = j;
						if(map[i][j] == '^') dir = 1;
						else if(map[i][j] == '>') dir = 2;
						else if(map[i][j] == 'v') dir = 3;
						else if(map[i][j] == '<') dir = 4;
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for(int i=0; i<str.length(); i++) {
				char mode = str.charAt(i);
				
				if(mode == 'U') {
					dir = 1;
					map[nowX][nowY] = '^';
					if(nowX - 1 < 0) continue;
					if(map[nowX-1][nowY] == '#' || map[nowX-1][nowY] == '-' || map[nowX-1][nowY] == '*') continue;
					map[nowX][nowY] = '.';
					nowX = nowX-1;
					map[nowX][nowY] = '^';
				} else if(mode == 'D') {
					dir = 3;
					map[nowX][nowY] = 'v';
					if(nowX + 1 >= h) continue;
					if(map[nowX+1][nowY] == '#' || map[nowX+1][nowY] == '-' || map[nowX+1][nowY] == '*') continue;
					map[nowX][nowY] = '.';
					nowX = nowX+1;
					map[nowX][nowY] = 'v';
				} else if(mode == 'L') {
					dir = 4;
					map[nowX][nowY] = '<';
					if(nowY - 1 < 0) continue;
					if(map[nowX][nowY-1] == '#' || map[nowX][nowY-1] == '-' || map[nowX][nowY-1] == '*') continue;
					map[nowX][nowY] = '.';
					nowY = nowY-1;
					map[nowX][nowY] = '<';
				} else if(mode == 'R') {
					dir = 2;
					map[nowX][nowY] = '>';
					if(nowY + 1 >= w) continue;
					if(map[nowX][nowY+1] == '#' || map[nowX][nowY+1] == '-' || map[nowX][nowY+1] == '*') continue;
					map[nowX][nowY] = '.';
					nowY = nowY+1;
					map[nowX][nowY] = '>';
				} else if(mode == 'S') {
					if(dir == 1) {
						a:for(int k=nowX-1; k>=0; k--) {
							if(map[k][nowY] == '#') break a;
							if(map[k][nowY] == '*') {
								map[k][nowY] = '.';
								break a;
							}
						}
					} else if(dir == 2) {
						a:for(int k=nowY+1; k<w; k++) {
							if(map[nowX][k] == '#') break a;
							if(map[nowX][k] == '*') {
								map[nowX][k] = '.';
								break a;
							}
						}
					} else if(dir == 3) {
						a:for(int k=nowX+1; k<h; k++) {
							if(map[k][nowY] == '#') break a;
							if(map[k][nowY] == '*') {
								map[k][nowY] = '.';
								break a;
							}
						}
					} else if(dir == 4) {
						a:for(int k=nowY-1; k>=0; k--) {
							if(map[nowX][k] == '#') break a;
							if(map[nowX][k] == '*') {
								map[nowX][k] = '.';
								break a;
							}
						} 
					}
			}
//				System.out.println(nowX + " " + nowY + " " + dir + " " + mode);
			
		}
			System.out.print("#" + tc + " ");
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		
	}

	}
}
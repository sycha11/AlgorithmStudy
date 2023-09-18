
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int row,col;
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			row = 5;
			col = n/5;
			int idx = 0;
			
			char[][] ch = new char[row][col];
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					ch[i][j] = str.charAt(idx++);
				}
			}
			
			int len = 0;
			int gongbak = 0;
			String s = "";
			String answer = "";
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<col; i++) {
				int cnt = 0;
				for(int j=0; j<row; j++) {
					if(ch[j][i] == '#') {
						cnt++;
					}
				}
				
				if(cnt != 0) { // 빈 공백이 아니라면
					len++;
					gongbak = 0;
					s += String.valueOf(cnt);
				} else { // 빈공백 열이라면 초기화
					len = 0;
					gongbak++;
					s = "";
				}
				
				if(len == 3) { // 3가지 연속
					sb.append(numCheck(ch, Integer.parseInt(s), i));
					s = "";
					len = 0;
				} else if(len == 1) { // 1줄일때
					if(cnt == 5) {
						if(col > 1) {
							boolean b =checkOne(ch, i);
							if(b) {
								sb.append("1");
							}
						} else {
							sb.append("1");
						}
					}
				}
			}
			System.out.println(sb);
		}
		
		// 1 check
		private static boolean checkOne(char[][] ch, int j) {
			if(j == 0){
				for(int i=0; i<5; i++) {
					if(ch[i][j+1] == '#') { // 앞에 #이 있다면 1이 아님
						return false;
					}
				}
			}
			else if(j == col-1) {
				for(int i=0; i<5; i++) {
					if(ch[i][j-1] == '#') { // 뒤에 #이 있다면 1이 아님
						return false;
					}
				}
			} else {
				for(int i=0; i<5; i++) {
					if(ch[i][j-1] == '#' || ch[i][j+1] == '#') { // 앞뒤로 #이 있다면 1이 아님
						return false;
					}
				}
			}
			return true;
		}
		
		// 2 check
		private static boolean checkTwo(char[][] ch, int j) {
			if(ch[3][j] == '.') {
				return true;
			}
			return false;
		}

		private static String numCheck(char[][] ch, int s, int i) {
			if(s == 525) {
				return "0";
			}
			else if(s == 434) { // 2와5가 같으므로 둘이 판별
				boolean b = checkTwo(ch, i);
				if(b) {
					return "2";
				}
				return "5";
			}
			else if(s == 335) {
				return "3";
			}
			else if(s == 315) {
				return "4";
			}
//			else if(s.equals("434")) {
//				return "5";
//			}
			else if(s == 534) {
				return "6";
			}
			else if(s == 115) {
				return "7";
			}
			else if(s == 535) {
				return "8";
			}
			else if(s == 435) {
				return "9";
			}
			
			return "1";
		}

}

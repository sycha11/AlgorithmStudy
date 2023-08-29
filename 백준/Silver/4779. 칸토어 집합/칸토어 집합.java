import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		while((s = br.readLine()) != null) {
			n = Integer.parseInt(s);
			sb = new StringBuilder();
			int len = (int) Math.pow(3, n);
			for (int i = 0; i < len; i++) {
				sb.append("-");
			}
			
			cut(0, len); // 시작 인덱스, 시작 길이
			System.out.println(sb);
		}
	}

	private static void cut(int start, int size) { // 시작위치, 크기  27
		if(size == 1) { //  기저조건
			return;
		}
		int cutSize = size/3; // 9
		// 가운데 공백
		for(int i=start+cutSize; i<start+2*cutSize; i++) {
			sb.setCharAt(i, ' ');
		}
		cut(start, cutSize);
		cut(start+2*cutSize, cutSize);
	}
	
}
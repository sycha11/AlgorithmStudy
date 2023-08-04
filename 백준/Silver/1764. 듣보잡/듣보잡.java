import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		ArrayList<String> answer = new ArrayList<>();
		// 듣도
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		// 보도 입력 받으면서 비교
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				answer.add(str);
			}
		}
		Collections.sort(answer);
		
		System.out.println(answer.size());
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		
	}

}


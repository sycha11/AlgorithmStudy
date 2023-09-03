import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, List<String>> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			String team = br.readLine();
			int num = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			for(int j=0; j<num; j++) {
				String memberName = br.readLine();
				list.add(memberName);
			}
			map.put(team, list);
		}
		
		for(int i=0; i<m; i++) {
			String qname = br.readLine();
			int mode = Integer.parseInt(br.readLine());
			
			if(mode == 1) {
				for(String s : map.keySet()) {
					if(map.get(s).contains(qname)) {
						sb.append(s + "\n");
					}
				}
			} else if(mode == 0) {
				List<String> list = map.get(qname);
				Collections.sort(list);
				for(String str : list) {
					sb.append(str + "\n");
				}
			}
		}
		System.out.println(sb);
		
		
		
	}

}
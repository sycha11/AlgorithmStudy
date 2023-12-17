import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(in.readLine());
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());
				char c = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				
				// n을 트리맵에 삽입
				if (c == 'I') {
					map.put(n, map.getOrDefault(n, 0) + 1); // 숫자와 해당 숫자의 개수 저장
				}
				// map이 비어있는 경우
				else if (map.size() == 0) continue;
				// 최댓값 또는 회솟값 삭제
				else {
					int key = 0;
					if(n == 1) {
						key = map.lastKey(); // 가장 큰 값 반환
					}
					if(n == -1) {
						key = map.firstKey(); // 첫번째 값 반환
					}
					int cnt = map.get(key);
					
					if (cnt == 1) { // 1이면 제거
						map.remove(key);
					} else {
						map.put(key, cnt - 1);
					}
				}
			}
			
			// 결과 출력
			if (map.size() == 0) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}

	}

}
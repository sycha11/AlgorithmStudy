
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		String search = sc.nextLine();

		text = text.replaceAll(search, "1");
		
		int cnt = 0;
		
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i) == '1') {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	
	}

}

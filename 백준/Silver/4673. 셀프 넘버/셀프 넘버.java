
public class Main {
	
	public static void main(String[] args) {
		
		boolean[] visit = new boolean[100000];
		
		for(int i=1; i<=10000; i++) {
			int a = i;
			while(a<=10000) {
				a = dn(a);
				visit[a] = true;
			}
		}
		for(int i=1; i<=10000; i++) {	
				if(visit[i] == false) {
					System.out.println(i);
				}
		}
	}
	
	static int dn(int n) {
		String nstr = String.valueOf(n);
		int len = (int) Math.pow(10, (nstr.length()-1));
		
		int result = n;
		while(len > 0) {
			result = result + n/len;
			n = n % len;
			len = len/10;
			
		}
		
		return result;
	}
}

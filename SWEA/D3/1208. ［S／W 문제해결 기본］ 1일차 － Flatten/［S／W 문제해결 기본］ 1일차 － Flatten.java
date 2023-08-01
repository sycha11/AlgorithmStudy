import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[100];
			// 배열 입력
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			int min = 1000;
			int max = 0;
			
			int minSave = 0;
			int maxSave = 0;
			
			while(N>0) {
				min = 1000;
				max = 0;
				for(int i=0; i<100; i++) {
					if(min > arr[i]) {
						min = arr[i];
						minSave = i;
					}
					if(max < arr[i]) {
						max = arr[i];
						maxSave = i;
					}
				}
				arr[minSave] += 1;
				arr[maxSave] -= 1;
				
				N--;
			}
			min = 1000;
			max = 0;
			for(int i=0; i<100; i++) {
				min = Math.min(min, arr[i]);
				max = Math.max(max, arr[i]);
			}
			
			System.out.println("#" + tc + " " + (max - min));
			
		}
		
	}
	
	

}

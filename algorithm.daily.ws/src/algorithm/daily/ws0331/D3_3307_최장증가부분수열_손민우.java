package algorithm.daily.ws0331;

import java.util.Scanner;

public class D3_3307_최장증가부분수열_손민우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc<=t; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] LIS = new int[N];
			
			for(int i = 0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = 0; 
			
			for(int i = 0; i<N; i++) {
				LIS[i] = 1; //자신의 최소 최적값
				for(int j = 0; j<i; j++) { // 0번인덱스부터 내 앞 인덱스까지 비교
					if(arr[j]<arr[i] && LIS[i] <= LIS[j]) { // 내가 가진 수보다 앞에있는 수가 더 작고 && 앞에 인덱스의 최적값 이 내 최적값이랑 같거나 크다면 
						LIS[i] = LIS[j] + 1; // 내 최적값 = j인덱스가 가지는 최적값+1 로 초기화 
					}
				}
				if(max<LIS[i]) max = LIS[i]; // 더 큰 값으로 초기화
			}
			
			System.out.println("#"+tc+" "+max); //출력
			
		}
	}
}

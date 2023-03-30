import java.util.Scanner;

public class 냅색알고리즘 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt(); // 가방이 담을 수 있는 최대무게
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
			
		}
		
		// 초기값 세팅: int[][] 배열의 자동초기화를 이용.
		int[][] D = new int[N+1][W+1];

		for(int i = 1; i<=N; i++) {// i: 물건
			for(int w = 0; w<= W; w++) { // w: 가방의 무게
				// 해당 물건의 무게가 W를 초과하는지 봐야함
				if(weights[i]>w) {
					D[i][w] = D[i-1][w];
				}else {
					D[i][w] = Math.max(D[i-1][w], profits[i]+D[i-1][w-weights[i]]);
				}
			}
		}
		
		System.out.println(D[N][W]);
	}

}

/**
4
10
5 10
4 40
6 30
3 50

=> 90
*/
package algorithm.daily.hw0217;

import java.util.Scanner;

public class BJ_3040_백설공주와일곱난쟁이_손민우 {
	
	static int arr[] = new int[9]; // 9명의 난쟁이 정보
	static int arr7[] = new int[7]; //7명의 조합을 담을 배열.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//데이터 입력
		for(int i = 0; i<9; i++) {
			arr[i] = sc.nextInt();
		}
		// 메서드 호출
		solution(0,0);
	}
	
	private static void solution(int cnt, int start) {// cnt: 조합원 수, start: 시작 인덱스
		if(cnt == 7) {
			int sum = 0; // 조합원의 모든 수를 더할 변수
			for(int i = 0; i<7; i++) { 
				sum += arr7[i];
				if(sum>100) return; //만약 더하는 도중 이미 100을 넘어버리면 다음 조합으로.
			}
			if(sum==100) for(int i : arr7) System.out.println(i);// 조합원을 다 더한값이 100일때의 출력.
			return;
		}
		//9명중 7명의 난쟁이 조합 구하기
		for(int i = start; i<9; i++) {
			arr7[cnt] = arr[i];
			solution(cnt+1, i+1);
		}
	}
}

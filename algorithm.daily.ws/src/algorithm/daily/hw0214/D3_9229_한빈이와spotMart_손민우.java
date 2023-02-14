package algorithm.daily.hw0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9229_한빈이와spotMart_손민우 {
	static int n; // 과자 개수
	static int m;	// 무게 합 제한
	static int arr[]; // 과자별 무게 담을 배열
	static int w[];		//과자2개의 무게 담을 배열
	static int max;	//최대 무게
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		for(int t = 1; t<=tc; t++) { 
			max = -1; // 초기 무게 -1
			StringTokenizer st = new StringTokenizer(br.readLine());
			//초기화
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n];
			w = new int[2];
			// 과자 무게 배열에 담기
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			//메서드 호출
			solution(0,0);
			//출력
			System.out.println("#"+t+" " +max);
		}
	}
	private static void solution(int cnt, int start) {
		if(cnt == 2) { // 과자 2개를 담으면
			int sum = 0; //2개의 무게합 담을 변수
			//무게 합 구하기
			for(int i = 0; i<2; i++) {
				sum+=w[i];
			}
			//만약 무게제한을 넘는다면 리턴
			if(sum>m) return;
			//무게제한을 안넘을때 최대무게 재정의
			if(sum<=m) max = Math.max(max, sum);
			
			return;
		}
		
		for(int i = start; i<n; i++) {
			w[cnt] = arr[i]; // 2개의 과자무게 담기
			solution(cnt+1, i+1); //재귀-> 다음 과자 선택
		}
	}
}

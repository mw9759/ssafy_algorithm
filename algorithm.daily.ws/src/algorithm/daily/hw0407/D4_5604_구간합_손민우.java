package algorithm.daily.hw0407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_5604_구간합_손민우 {

	static long A,B;
	static long cntNumbers[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			cntNumbers = new long[10];
			long delta = 1;// 자릿수를 의미한다. 처음은 1의 자릿수
			
			while(A<=B) {
				// 윗쪽 짜투리 처리 A가 24라면 30으로 만들기.
				for(; A%10 != 0 && A<=B; A++) {
					parse(A, delta); 
				}
				// 아랫쪽 짜투리 처리 B가 56이라면 49로 만들기.
				for(; B%10 != 9 && A<=B; B--) {
					parse(B, delta);
				}
				// 만약 A가 B보다 커져버렸다
				if(A>B) break;
				
				//0~9까지 1의자리수가 반복되는 부분.=> row의 갯수만큼 추가
				A /= 10;
				B /= 10;
				long rowCnt = B-A+1; // 반복되는 행의 수
				for(int i = 0; i<10; i++) { // 0부터 9까지 행의 갯수만큼 카운트 해준다.
					cntNumbers[i] += rowCnt*delta;
				}
				delta*=10; // 다음 자릿수
			}
			// 총 합 구하기.
			long sum = 0;
			for(int i = 1; i<10; i++) { // 1부터 9까지의 갯수만큼 더하기.
				sum += i*cntNumbers[i]; 
			}
			// 출력
			System.out.println("#"+tc+" "+sum);
			
		}
	}
	// 반복되는 구간이 아닌 짜투리 구간에 있는 숫자의 합을 구하기.
	private static void parse(long x, long delta) {
		while(x>0) { // x가 0이 되기 전까지 반복.
			cntNumbers[(int)(x%10)] += delta; 
			x/=10;
		}
	}

}

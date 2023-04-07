package algorithm.daily.hw0407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1019_책페이지_손민우 {

	static long A,B;
	static long cntNumbers[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long B = Long.parseLong(br.readLine());
		long A = 33;
		
		cntNumbers = new long[10];
		long delta = 1;
		
		while(A<=B) {
			// 윗쪽 짜투리
			for(; A%10!=0 && A<=B; A++) {
				parse(A,delta);
			}
			// 아랫쪽 짜투리
			for(; B%10!=9 && A<=B; B--) {
				parse(B, delta);
			}
			
			if(A>B) break;
			
			A/=10;
			B/=10;
			long rowCnt = B-A+1;
			for(int i = 0; i<10; i++) {
				cntNumbers[i] += rowCnt*delta;
			}
			delta*=10;
		}
		
		for(int i = 0; i<10; i++) {
			System.out.print(cntNumbers[i]+" ");
		}
	}
	
	// 반복되는 구간이 아닌 짜투리 구간에 있는 숫자의 합을 구하기.
	private static void parse(long x, long delta) {
		while(x>0) {
			cntNumbers[(int) (x%10)] += delta;
			x/=10;
		}
	}

}

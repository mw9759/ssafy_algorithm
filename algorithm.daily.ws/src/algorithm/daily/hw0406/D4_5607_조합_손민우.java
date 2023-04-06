package algorithm.daily.hw0406;

import java.util.Scanner;

public class D4_5607_조합_손민우 {
	static long N,R;
	static long p = 1234567891;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); // n값
			R = sc.nextInt(); // r값
			
			long a = 1;
			long b = 1;
			
			//N combination R ,
			//N! / R!(N-R)!  공식에서 미리 약분하여  N 부터 R개 까지의 곱 / R! 을 적용 
			long t = Math.min(R, N-R);// 더 적은값까지 연산하면 된다.
			for(int i=0; i<t; i++) {
				a = a*(N-i)%p;
				b = b*(t-i)%p;
			}			
			// 모듈러 연산=> 연산의 분배법칙
			// 원래 a/b%p이다. 나누기는 분배법칙을 적용할 수 없기에 페르마의 소정리를 사용해서 바꿔준다.
			long ans = (a%p*div(b,p-2)%p)%p; //div(): 페르마의 소정리 메서드
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	// 페르마의 소정리
	static long div(long a, long b) { // a: 밑수, b: 지수
		if(b==1) // 기저조건 a의 지수가 1이면 a이다.
			return a;
		long tmp = div(a, b/2); 
		if(b%2 == 1) //b가 2로 나누어 떨어지지 않으면
			return tmp*tmp%p*a%p;
		else // b가 2로 나누어 떨어진다면
			return tmp*tmp%p;
	}
}

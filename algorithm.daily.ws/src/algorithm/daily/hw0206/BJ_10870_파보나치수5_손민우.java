package algorithm.daily.hw0206;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10870_파보나치수5_손민우 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //데이터 입력 객체
		int n = Integer.parseInt(br.readLine()); // n값
		if(n==0) System.out.println(0);
		else if(n==1) System.out.println(1);
		else System.out.println(solution(n, 1, 0, 1));//n값, 1번째, 0번째값, 1번째값
	}
	
	private static int solution(int n, int index, int a, int b) {//n값, index번째, index-1번째값, index번째값
		if(index == n-1) return a+b;//n이 9일때 a+b(10번째값)리턴
		return solution(n,++index, b, a+b);//n값, index번째, index-1번째값, index번째값
	}
}

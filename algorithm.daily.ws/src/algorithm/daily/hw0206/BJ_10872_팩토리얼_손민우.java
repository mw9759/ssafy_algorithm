package algorithm.daily.hw0206;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * 
 * bj 10872
 */
public class BJ_10872_팩토리얼_손민우 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //데이터 입력 객체
		int n = Integer.parseInt(br.readLine()); // n값
		System.out.println(solution(n));//n! 출력.
	}
	
	private static int solution(int n) {
		if(n==1) return 1; //1일때 1리턴&탈출
		return n*solution(--n); //재귀호출
	}

}

package algorithm.daily.hw0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호_손민우 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int sum = 0; // 연산값
		int flag = 0; // 덧셈을 해야하는 상황을 확인하는 변수
		StringTokenizer stSub = new StringTokenizer(br.readLine(), "-");
 
		while (stSub.hasMoreTokens()) { // stSub의 토큰을 다 쓸때까지 반복.
			int cal = 0;
 
			// -를 기준으로 나누어진 토큰을 또다시 +를 기준으로 나누어준다. +가 없다면 토큰은 정수값 하나이다.
			StringTokenizer stAdd = new StringTokenizer(stSub.nextToken(), "+");
			
			// +를 기준으로 나누어진 토큰들을 더한다.: 이미 -로 나누고 나온 토큰에는 a+b+c....이기에 +으로 또 나눠주면 정수만 남는다. 
			while (stAdd.hasMoreTokens()) { // stAdd의 토큰을 다 쓸때까지 반복.
				cal += Integer.parseInt(stAdd.nextToken());
			}
			// -가 있든 없든 sum에 + 하는 경우는 딱 1번이다 : -를기준으로 입력string을 쪼개줫으니 
			//+만 있다면 쪼개지는 토큰 없이 전부 한번에 딱 한번 더해주고, -가 있다면 첫 -의 앞부분만 더해주게 된다.
			if (flag == 0) {
				flag = 1;
				sum += cal;
			} else sum -= cal;
			
		}
		//출력
		System.out.println(sum);
		
	}

}

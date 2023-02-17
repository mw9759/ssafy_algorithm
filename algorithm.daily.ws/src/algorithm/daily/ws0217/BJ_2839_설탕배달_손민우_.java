package algorithm.daily.ws0217;

import java.util.Scanner;

public class BJ_2839_설탕배달_손민우_ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 배달해야할 무게
		int answer = 0;
		for(int i = n/5; i>=0; i--) { //5로 나눈 몫의 최댓값부터 0까지
			if((n-(i*5))%3 == 0) { // 나머지가 3으로 나누어 떨어지면 최소값
				answer = i+(n-(i*5))/3; 
				break;
			}
		}
		System.out.println(answer==0? -1:answer); //0이면 구할수 없는 수이기에 -1 출력
	}

}

package algorithm.daily.ws0209;

import java.util.Scanner;

public class BJ_2023_신기한소수 {

	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int startN = (int) Math.pow(10, n-1);
		solution(startN);
	}
	
	private static void solution(int startN) {
		for(int i = startN+1; i<Math.pow(10, n); i+=2) {
			int x = (int)Math.sqrt(i);
			System.out.println(x);
		}
	}
	
	
}

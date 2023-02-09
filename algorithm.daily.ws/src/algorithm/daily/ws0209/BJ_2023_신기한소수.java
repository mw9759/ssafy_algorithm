package algorithm.daily.ws0209;

import java.util.Scanner;

public class BJ_2023_신기한소수 {
	
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int primeNum[] = {2, 3, 5, 7};
		
		for(int i : primeNum) {
			solution(i, 1);
		}
		System.out.println(sb);
	}
	
	private static void solution(int primeNum, int cnt) {
		if(cnt == n) {
			sb.append(primeNum).append("\n");
			return;
		}
		
		for(int i = 1; i<10; i+=2) {
			if(isPrime(primeNum*10+i)) solution(primeNum*10+i, cnt+1);
		}
	}

	private static boolean isPrime(int num) {
		for(int i = 2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
	
		
}


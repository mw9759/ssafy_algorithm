package algorithm.daily.hw0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164_카드2_손민우 {
	static int n;
	static Queue<Integer> q = new LinkedList<Integer>(); //큐 선언 및 초기화
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //n 초기화
		solution();
	}
	
	private static void solution() {
		for(int i = 1; i<=n; i++) { //n까지 돌면서 큐에 전부 넣어준다.
			q.add(i);   
		}
		while(q.size()>1) {			//q의 크기가 1이면 출력해야하기 때문에 1이 되기 전까지 반복.
			q.remove();				//제일 상단의 카드 제거
			q.add(q.poll());		//그다음 제일 상단의 카드는 뽑아서 맨 밑으로.
		}
		System.out.println(q.poll()); //남은 1장의 카드 출력
	}

}

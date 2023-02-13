package algorithm.daily.hw0210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225_암호생성기_손민우 {
	static Queue<Integer> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<=10; tc++) {
			q = new LinkedList<Integer>();//큐 선언 및 초기화.
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			//8개의 암호문 받아오기. 바로 큐에 삽입.
			for(int i = 0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			solution();
			//출력문
			System.out.print("#"+t+" "); 
			for(int i : q) System.out.print(i + " ");
			System.out.println();
		}
	}

	private static void solution() {
		int sub = 1;// 앞부분에 빼줘야할 수
		while(true) {
			if(q.peek()-sub <= 0) { // 만약 뺀 수가 0 이하면
				q.poll(); // 그 수는 제거하고
				q.add(0); // 뒤에 0으로 삽입.
				break; //탈출
			}
			else { 
				q.add(q.poll()-sub); //0 초과라면 sub만큼 빼서 맨 뒤로 이동
			}
			
			sub++; //빼줘야할 수 1증가.
			if(sub>5) sub = 1; // 만약 빼줘야할 수가 5를 초과하면 1로 초기화
		}
	}

}

package algorithm.daily.ws0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697_숨바꼭질_손민우 {
	
	static int n,k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 내 위치
		k = Integer.parseInt(st.nextToken()); // 동생 위치
		
		solution(); //메서드 호출
		
	}
	private static void solution() {
		Queue<Integer> que = new LinkedList<Integer>(); // 이동된지점들 
		int visited[] = new int[200001]; // 방문여부
		
		que.add(n); // 출발지점 담기
		visited[n] = 1; // 출발지점 방문체크 
		int answer = 0; // 총 걸린 최소시간.
		while(!que.isEmpty()) {
			
			int size = que.size();
			for(int i = 0; i<size; i++) { // 1초에 일어나는 모든 경우 검증
				int num = que.poll(); // i번째 경우
				
				if(num == k) { // 동생을 찾은 경우라면
					System.out.println(answer); //출력하고 리턴
					return;
				}
				
				// 순간이동
				if(num<k && visited[num*2] ==0) { // 동생의 위치에 도달하지 못했을때만.&& 방문기록이 없을때
					que.add(num*2); // 이동할 지역 담기
					visited[num*2] = 1; // 담긴 지역 방문 체크
				}
				// 한칸 앞으로
				if(num<k && visited[num+1] ==0) {
					que.add(num+1);
					visited[num+1] = 1;
				}
				// 한칸 뒤로
				if(num>=1 && visited[num-1] ==0) {
					que.add(num-1);
					visited[num-1] = 1;
				}
			}
			answer++; // 1초 추가
		}
		
	}

}
/*
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1 
5 17
예제 출력 1 
4
*/
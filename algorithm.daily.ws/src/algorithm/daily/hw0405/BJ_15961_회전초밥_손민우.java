package algorithm.daily.hw0405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_15961_회전초밥_손민우 {
	static int n,d,k,c; 
	static int answer = 0;
	static Set<Integer> set;
	static Queue<Integer> que = new ArrayDeque<Integer>(); // 릴레이로 먹은 초밥들
	static Queue<Integer> list = new ArrayDeque<Integer>(); // 전체 초밥
	static int visited[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 레일위의 접시 수
		d = Integer.parseInt(st.nextToken());// 초밥의 가짓수 
		k = Integer.parseInt(st.nextToken());// 연속해서 먹는 접시 수
		c = Integer.parseInt(st.nextToken());// 쿠폰번호
		visited = new int[d+1]; // 먹은 초밥 카운팅
		// 입력값 받기
		for(int i = 0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		// 초기값 설정
		int count = 0; // 먹은 종류갯수
		for(int i = 0; i<k; i++) {
			if(visited[list.peek()] == 0) { // 안먹은 초밥이라면
				count++; // 카운팅
			}
			visited[list.peek()]++; // 먹었다고 체크
			que.add(list.peek()); // 릴레이로 먹은 초밥 리스트에 추가.
			list.add(list.poll()); // 뒤로 넘기기.
		}
		if(visited[c] == 0) { // 만약 쿠폰 초밥을 안먹었다면
			count++; // 카운팅
		}
		visited[c]++; // 먹었다고 체크
		
		// 초기값 설정이후 하나씩 빼고, 넣고.
		for(int i = 0; i<n-1; i++) {
			int a = que.poll(); // 먹은 릴레이초밥에서 뺄 초밥
			visited[a]--; 
			if(visited[a] == 0) count--; //먹은 기록이 없다면 종류갯수 줄이기. 
			
			int b = list.poll(); // 먹을 릴레이초밥
			if(visited[b] == 0) count++; // 먹은 기록이 없다면 카운팅
			visited[b]++; // 먹었다고 갯수 체크
			que.add(b); // 먹은 릴레이초밥에 추가.
			list.add(b); // 뒤로 넘기기.
			answer =Math.max(answer, count); // 최댓값으로 먹은 종류갯수 초기화
		}
		
		System.out.println(answer); //출력
	}

}
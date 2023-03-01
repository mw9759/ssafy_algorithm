package algorithm.daily.hw0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1238_Contact_손민우 {
	// 사람의 번호와 몇번째로 연락을 받는지 담아둘 객체
	static class Node implements Comparable<Node>{
		int num, count; // 번호, 몇번째인지.
		Node(int num, int count){
			this.num = num;
			this.count = count;
		}
		// 몇번째를 기준으로 정렬 재정의 : 가장 늦게 연락 받는 사람을 구해야함.
		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.count, this.count); // 내림차순: 비교할 값이 뒤로오면 내림.
		}
	}
	
	static int n, start; // 입력 갯수, 시작 당번번호
	static ArrayList<Integer>[] list; // 연락망의 내용을 담을 리스트.: n번이 전화할 수 있는 사람들의 번호들 
	static int visited[]; // 전화를 받았는지 유무를 담을 배열.
	static ArrayList<Node> lastNode; // 마지막으로 전화받은 사람들의 번호와 몇번째인지 담을 리스트
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//초기화.
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			list = new ArrayList[101];
			visited = new int[101];
			lastNode = new ArrayList<Node>();
			// 배열 초기화: 안에 리스트 자료형 넣어두기.
			for(int i = 0; i<=100; i++) {
				list[i] = new ArrayList<Integer>();
			}
			//문자열 짜르기. 및 입력 데이터 저장.
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n/2; i++) {// 2개의 입력 데이터가 짝궁이기에 입력갯수의 절반만큼만 반복.
				int from = Integer.parseInt(st.nextToken()); // 전화거는 사람
				int to = Integer.parseInt(st.nextToken());	// 전화받는 사람.
				
				list[from].add(to); // 데이터 입력.
			}
			//메서드 호출.
			bfs(start);
			//메서드가 다 돌고 만들어진 마지막으로 전화받은 사람들의 목록 정렬: 기준: 몇번째로 받았는지: 내림차순.
			Collections.sort(lastNode);
			int answer = -1; // 최댓값(같은 차례에 받은 사람들이 여러명이면 가장 연장자 출력) 담을 변수.
			int count = lastNode.get(0).count; // 가장 늦게받은 차례 담을 변수,
			// 정답 서치.
			for(Node n : lastNode) {
				if(n.count == count) { // 만약 같은 차례에 받은 사람이라면
					answer = Math.max(answer, n.num); // 정답 초기화. 최대값으로 저장..
				}
			}
			//출력
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	private static void bfs(int start) {
		Queue<Node> que = new LinkedList<Node>(); // 다음 전화를 걸 사람의 번호와 차례를 담을 큐.
		que.add(new Node(start, 0)); // 첫 시작 당번의 정보 큐에 담기.
		visited[start] = 1;	// 이 사람은 전화를 받았다고 표시.
		
		while(!que.isEmpty()) { // 큐가 빌때까지 : 전화를 받을 사람이 없을 때까지.
			Node temp = que.poll(); // 전화 거는 사람의 정보.
			int num = temp.num;		// 번호
			int count = temp.count;	// 차례
			int size = list[num].size(); // 전화 거는 사람이 몇명에게 걸어야하는지
			
			int flag = 0; // 전화를 걸었나 안걸었나 확인할 변수.
			for(int i = 0; i<size; i++) { // 명 수 만큼 반복.
				int child = list[num].get(i); // 전화 받을 사람의 번호.
				if(visited[child] == 0) { // 만약 전화를 받은 기록이 없다면
					visited[child] = 1;		// 전화를 받았다고 기록.
					que.add(new Node(child, count+1)); // 이사람이 이제 전화를 걸어야하니 큐에 담기.
					flag = 1; // 전화를 받은 사람이 1명이라도 있다면 1.
				}
			}
			// 만약 전화를 안걸었다면 걸 사람이 이제 없다는 것.
			if(flag == 0) {
				lastNode.add(new Node(num, count)); // 이 사람의 번호와 전화를 받은 차례를 담기.
			}
		}
	}

}

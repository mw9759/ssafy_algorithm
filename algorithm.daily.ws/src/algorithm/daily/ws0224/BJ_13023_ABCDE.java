package algorithm.daily.ws0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_13023_ABCDE {
	static int n,m; 
	static ArrayList<ArrayList<Integer>> list;
	static int visited[];
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //사람 수
		m = Integer.parseInt(st.nextToken()); // 친구관계 수
		
		list = new ArrayList<ArrayList<Integer>>(); // n번째 사람의 모든 친구정보를 담을 리스트
		visited = new int[n]; // 친구관계 포함 여부체크
		
		//list 초기화
		for(int i = 0; i<n; i++) {
			list.add(new ArrayList<Integer>());
		}
		// 관계 데이터 입력.: 양방향으로 친구이기에 이부분 고려해서 관계추가
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int to =Integer.parseInt(st.nextToken());
			int from =Integer.parseInt(st.nextToken());
			list.get(to).add(from);
			list.get(from).add(to);
		}
		// A-E 여부 확인
		for(int i = 0; i<n; i++) { // 사람수만큼 반복. i를 시작인 A로
			visited[i] = 1; // 방문체크
			dfs(0,i);	// i번 사람이 선두일떄의 경우 확인
			visited[i] = 0;	// 방문해제
			if(answer == 1) { //만약 A-E가 완성되었다면 BREAK;
				break;
			}
		}
		System.out.println(answer == 1? 1:0); // 출력
	}
	
	private static void dfs(int cnt, int x) {
		if(answer == 1) return; // 이미 A-E가 완성된 경우 더이상 탐색 X
		
		//추가로 A-E가 완성이 되었다면
		if(cnt == 4) {// : main에서 1+dfs에서 4= 5 A-E완성 
			answer = 1; // 정답 1로 초기화
			return; 
		}
		for(int i = 0; i<list.get(x).size(); i++) { //A의 친구들 수만큼 반복: 모든 친구들 검증
			int number = list.get(x).get(i); // 친구 번호
			if(visited[number] == 0) { //만약 A-E에 포함이 안되어 있다면
				visited[number] =1;	// 포함 체크
				dfs(cnt+1,number);	// 포함한 채로 다음 친구 찾기.
				visited[number] =0; // 다 돌고 돌아온 경우는 못찾은 경우이기에 다음 검증을 위해 방문 해제.
			}
		}
	}

}
/*

문제
BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.

둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

출력
문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.

예제 입력 1 
5 4
0 1
1 2
2 3
3 4
예제 출력 1 
1

*/
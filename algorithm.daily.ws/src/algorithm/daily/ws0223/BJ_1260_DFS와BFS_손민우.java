package algorithm.daily.ws0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS_손민우 {
	static int n, m, v;
	static int visited[];
	static ArrayList<Integer>[] list;
	static int[] nodes;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 정점의 개수
		m = Integer.parseInt(st.nextToken());// 간선의 개수
		v = Integer.parseInt(st.nextToken());// 시작 정점의 번호
		visited = new int[n+1];
		list = new ArrayList[n+1];
		// list 초기화
		for(int i = 0; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		// 데이터 입력
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//양방향 추가.
			list[from].add(to);
			list[to].add(from);
		}
		//호출 및 출력
		dfs(0, v);
		System.out.println(); 
		visited = new int[n+1]; // 방문여부 초기화
		bfs(v);
	}
	
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>(); // 다음 노드 담을 큐
		que.add(start); // 시작노드 입력
		visited[start] = 1; // 시작노드 방문표시
		
		int node = 0; // 현재 노드 담을 변수
		while(!que.isEmpty()) {
			node = que.poll(); // 큐에서 하나 뽑은 현재 노드
			System.out.print(node+ " "); // 출력
			
			Collections.sort(list[node]); // 다음 노드를 고르기 위해(최소값의 노드) 정렬
			
			for(int vertex : list[node]) { // 현재 노드의 모든 방문지를 번호가 작은 순으로 확인
				if(visited[vertex] == 0) { // 만약 방문 여부가 없다면
					que.add(vertex);	// 다음 노드로서 확인하기위해 큐에 담는다.
					visited[vertex] = 1;	// 방문을 했으니 1로 초기화
				}
			}
		}
	}
	
	
	private static void dfs(int cnt, int start) {
		if(cnt == n) { // 노드를 다 방문하면 탈출
			return;
		}
		
		System.out.print(start+" "); // 현재 방문노드 출력
		visited[start] = 1;	// 방문여부 초기화
		
		Collections.sort(list[start]); //현재 노드가 방문할수 있는 노드들 정렬
		int a =0; // 방문 가능한 노드를 담을 변수
		for(int i = 0; i<list[start].size(); i++) { // 방문할수 있는 노드들의 개수만큼반복: 작은 순부터
			if(visited[list[start].get(i)] == 0) { // 만약 방문기록이 없다면 방문
				a = list[start].get(i);			// 방문할 노드
				visited[a] = 1;					// 방문여부초기화
				dfs(cnt+1, a);					// 다음 재귀호출
			}
		}
		
		
	}
}
/*
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다. 
 
 입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 
출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
4 5 1
1 2
1 3
1 4
2 4
3 4
*/
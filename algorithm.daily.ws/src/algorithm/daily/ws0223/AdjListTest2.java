package algorithm.daily.ws0223;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest2 {
	
	static int V;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new ArrayList[V]; //head모두 null상태
		
		for(int i = 0; i<V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for(int i = 0; i<E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			//무향그래프라서 
			adjList[from].add(to);
			adjList[to].add(from);
			//유향그래프
		}
		bfs(0);
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		queue.offer(start);
		visited[start] = true;
		
		int current = 0;
		while(!queue.isEmpty()) {
			current = queue.poll();
			//영어로 출력.
			System.out.println((char)(current+65)); //탐색할때 해야할 일!
			
			for(int vertex : adjList[current]) { //adjList[current] : 어레이 리스트
				if(!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
				}
			}
		}
	}
}

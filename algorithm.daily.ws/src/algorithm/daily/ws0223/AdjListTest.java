package algorithm.daily.ws0223;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
		
	}
	
	static Node[] adjList;
	static int V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[V]; //head모두 null상태
		
		int from, to;
		for(int i = 0; i<E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			//무향그래프라서 
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
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
			
			for(Node temp = adjList[current]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
			
			
		}
	}
}

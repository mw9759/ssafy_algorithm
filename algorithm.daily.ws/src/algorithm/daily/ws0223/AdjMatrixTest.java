package algorithm.daily.ws0223;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {

	static int V;
	static int[][] adjMatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix = new int[V][V]; //모두 0으로 초기화된 상태
		
		int from, to;
		for(int i = 0; i<E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			//무향그래프라서 
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
			//유향그래프
//			adjMatrix[from][to] = 1;
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
			
			for( int i = 0; i<V; i++) {
				if(adjMatrix[current][i] != 0 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
			
			
		}
	}
	
}

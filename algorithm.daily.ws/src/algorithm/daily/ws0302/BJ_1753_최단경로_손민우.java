package algorithm.daily.ws0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class BJ_1753_최단경로_손민우 {
	
	static class Vertex implements Comparable<Vertex>{
		int a, weight;
		Vertex(int a, int weight){
			this.a = a;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int v,e,start;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken()); // 정점의 갯수
		e = Integer.parseInt(st.nextToken()); // 간선의 갯수
		start = Integer.parseInt(br.readLine()); // 시작 정점
		ArrayList<Vertex>[] list = new ArrayList[v+1];
		
		for(int i = 1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Vertex(to, weight));
		}
		
		
		PriorityQueue<Vertex> que = new PriorityQueue<Vertex>();
		que.add(new Vertex(start, 0)); // 출발지에서 가장 가까운 지역.
		int[] distance = new int[v+1];// 출발정점에서 자신까지 오는 최소비용.
//		boolean[] visited = new boolean[v+1]; // 경유지로 고려된 정점여부
		int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		while(!que.isEmpty()) {
			Vertex v = que.poll();
			int node = v.a;
			int weight = v.weight;
			
			for(int i = 0; i<list[node].size(); i++) {
				if(distance[list[node].get(i).a] > weight+list[node].get(i).weight) {
					distance[list[node].get(i).a] = weight+list[node].get(i).weight;
					que.add(new Vertex(list[node].get(i).a, weight+list[node].get(i).weight));
				}
			}
		}
		
		for(int i = 1; i<=v; i++) {
			if(distance[i] != INF) System.out.println(distance[i]);
			else System.out.println("INF");
		}
	}

}
/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/
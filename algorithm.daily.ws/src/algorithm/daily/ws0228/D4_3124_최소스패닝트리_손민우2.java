package algorithm.daily.ws0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D4_3124_최소스패닝트리_손민우2 {
	
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
	static int V, E;
	static boolean visited[];
	static int minEdge[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visited = new boolean[V+1];
			ArrayList<Vertex>[] list = new ArrayList[V+1];
			for(int i = 0; i<=V; i++) {
				list[i] = new ArrayList<Vertex>();
			}
			minEdge = new int[V+1];
//			
//			for(int i = 1; i<=V; i++) {
//				minEdge[i] = Integer.MAX_VALUE;
//				for(int j = 1; j<=V; j++) {
//					arr[i][j] = Integer.MAX_VALUE;
//				}
//			}
//			
			for(int i = 0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[a].add(new Vertex(b, c));
				list[b].add(new Vertex(a, c));
			}
			
			PriorityQueue<Vertex> que = new PriorityQueue<Vertex>();
			que.add(new Vertex(1,0));
			long answer = 0;
			int nodeCount = 0;
			
			while(!que.isEmpty()) {
				// 현재 가장 작은 간선비용을 가진 정점 뽑기.
				Vertex minVertex = que.poll();
				// 이미 연결된 노드면 다음 노드로
				if(visited[minVertex.a]) continue;
				
				answer += minVertex.weight; //비용추가
				visited[minVertex.a] = true; //  방문기록
				if(++nodeCount == V+1) break; // nodeCount 증가시키고, 정점수와 같다면 모든 정점 연결 완료
				
				//방문기록x, 현재 최소값보다 작은지?
				for(int i = 0; i<list[minVertex.a].size(); i++) {
					if(!visited[list[minVertex.a].get(i).a]) {
//					if(!visited[i] && 
//									minEdge[i]>arr[minVertex.a][i]) {
//						minEdge[i] = arr[minVertex.a][i];
						que.add(new Vertex(list[minVertex.a].get(i).a, list[minVertex.a].get(i).weight));
					}
				}
				
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	

}
/*
1
3 3
1 2 1
2 3 2
1 3 3
*/

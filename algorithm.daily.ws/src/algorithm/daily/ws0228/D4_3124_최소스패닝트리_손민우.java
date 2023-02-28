package algorithm.daily.ws0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3124_최소스패닝트리_손민우 {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int V, E;
	static int parents[];
	static Edge edgeList[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V+1];
			edgeList = new Edge[E];
			
			for(int i = 0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(a,b,c);
			}
			
			Arrays.sort(edgeList);
			makeSet();
			long answer = 0, count = 0;
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					answer += edge.weight;
					if(++count == V-1) break;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	private static void makeSet() {
		for(int i = 1; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if(parents[a] == a) return a;
	    return parents[a] = findSet(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}

}
/*
1
3 3
1 2 1
2 3 2
1 3 3
*/

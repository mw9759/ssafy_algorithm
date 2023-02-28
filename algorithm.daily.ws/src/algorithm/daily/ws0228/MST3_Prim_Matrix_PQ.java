package algorithm.daily.ws0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
//프림 알고리즘 이용 : PriorityQueue 버전
/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0
==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0
==>175
 */
public class MST3_Prim_Matrix_PQ {
	// pq 대상객체: 우선순위 비교 조건 재정의
    static class Vertex implements Comparable<Vertex>{
    	int no; // 정점 번호
    	int weight; // 간선 비용
		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		// 정점에 해당하는 간선비용 올림 정렬
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight,o.weight);
		}
    }
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] input = new int[N][N];
        boolean[] visited = new boolean[N];
        int[] minEdge = new int[N];
        
        // PQ 객체 산안 및 생성
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }// i노드에서 j노드까지의 비용을 모두 배열에 저장
        
        int result = 0;
        minEdge[0] = 0;//시작점 비용 0 셋팅
        // PQ 위한 초기 설정
        int  nodeCount= 0;
        pq.offer(new Vertex(0,0)); // PQ 넣기
        
		while(!pq.isEmpty()){
			//PQ에서 간선비용이 최소인 정점 뽑기
			Vertex minVertex = pq.poll();	// PQ 에서 간선비용이 최소인 정점 뽑기
			// 신장트리 선택여부 체킹: 이미 선택되었으면 다음노트
			if(visited[minVertex.no]) continue;
			
			// 신장트리에 선택된 정점 포함하기
            result += minVertex.weight; // 최소 비용 누적  
            visited[minVertex.no] = true; // 선택된 정점 신장트리에 포함시킴
            if(++nodeCount == N) break; // nodeCount 증가시키고, 정점수와 같다면 모든 정점 연결 완료.
            // 즉, N개 정점 모두 연결 완료
            
            // 새로운 정점이 추가됨
            // 인접한 노드중 방문하지 않은 노드에 대해 간선비용 최소값으로 갱신
            for (int i = 0; i < N; i++) { // 인접한 노드 중  방문하지 않은 노드에 대해 간선비용 최소값으로 갱신
                if (!visited[i] && 
                		input[minVertex.no][i] != 0 &&   
                		minEdge[i] > input[minVertex.no][i] ) {
                	minEdge[i] = input[minVertex.no][i];// 최소 비용 갱신
                	pq.offer(new Vertex(i, input[minVertex.no][i])); //PQ에 해당 정점의 최소 추가하기
                }
            }
        }
		
        System.out.println(result);// 모든 정점 연결완료: 최소비용 출력.
    }
}

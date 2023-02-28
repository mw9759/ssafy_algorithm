package algorithm.daily.ws0228;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
// 프림 알고리즘이용
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
public class MST2_Prim {
    public static void main(String[] args) throws Exception {
       //input
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //정점갯수
    	int N = Integer.parseInt(br.readLine().trim());
        //인접행렬
    	// 정점 크기만큼의 인접행렬[N][N] 배열 생성
        int[][] input = new int[N][N];
        // 신장트리에 선택된 여부 체킹 배열.
        boolean[] visited = new boolean[N];
        // 타 정점에서 자신으로의 간선비용중 최소비용 저장하기 위한 배열
        int[] minEdge = new int[N];
        
        // INPUT데이터로부터 인접행렬 채우기.
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
        	//라인단위 인접행렬 정보가져오기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
            //충분히 큰값으로 최소값을 초기화.
            minEdge[i] = Integer.MAX_VALUE;
        } // i노드에서 j노드까지의 비용을 모두 배열에 저장.
        // ==== input debug point
        int result = 0; //MST(최소진장트리) 비용
        minEdge[0] = 0; //임의의 시작점을 0으로 설정.
        
        // N개의 정점을 반복하면서 모두 연결
		for(int c = 0 ; c < N; c++){ 
			int min = Integer.MAX_VALUE;// 최소값을 찾아야하니 충분히 큰값으로 초기화
            int minVertex = 0;// 최소값을 값는 정점
           
            // 1단계 : 정점 선택
            //신장트리에 아직 연결되지 않는 정검중에서 가장 유리한 간선비용의 정점을 선택.
            for(int i=0; i<N; ++i) {
            	//아직 신장트리에 포함되지 않은 정점이면서 && 자신으로 다른정점에서 오는 최소 간선비용(minEdge[i]) min 보다 작다면(최소)
            	if(!visited[i] &&  
            			min > minEdge[i] ) {
            		min = minEdge[i]; // 최소비용 갱신
            		minVertex = i; 	  // 선택된 가장 유리한 최소정점 설정.
            	}
            }	
            
            // 선택된 정점을 신장트리에 포함시킴
            visited[minVertex] = true; 
            // 신장트리에 포함되었으니 최소 비용에 누적
            result += min; 
            
            // ------debug point : 선택된 정점정보 확인!@!@!@
//            System.out.println("---------------------");
            
            
            //2단계:
            //신장트리 연결될때마다 새로운 연결포인트가 생김
            //선택된 정점 기준으로 신장트리에 포함되지 않은 다른정점으로의 간선비용을 따져보고 최소값 갱신.
            //이미 비교한 정점과 최소값을 다시 비교할 필요는 없음.
            for (int i = 0; i < N; i++) { 
                if (!visited[i] && 
                		input[minVertex][i] != 0 &&  
                		minEdge[i] > input[minVertex][i]  ) {
                	minEdge[i] = input[minVertex][i];
                	System.out.printf("i = d%, minVerted = %d, minEdge[1", i,min, minEdge[i],input[minVertex][i]);
                }
            }
        }
		
        System.out.println(result);
    }
}

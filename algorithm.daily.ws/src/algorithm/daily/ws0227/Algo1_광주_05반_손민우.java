package algorithm.daily.ws0227;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_광주_05반_손민우 {
	static int n;
	static int arr[][], black[][];// 전체 맵, 검은천의 좌표, 
	static int dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0}; //4방 혹은 8방 확인용 배열.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[102][102]; // 전체 배열 1~100인덱스 확인하기위해 102로 초기화.
		
		black = new int[n][2];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			black[i][1] = Integer.parseInt(st.nextToken()); // 검은 천의 x좌표
			black[i][0] = Integer.parseInt(st.nextToken()); // 검은 천의 y좌표
		}
		// 검정색 천이 차지하는 부분만큼 1로 변경.
		for(int i = 0; i<n; i++) {
			//좌표담기
			int x = black[i][1];
			int y = black[i][0];
			// 해당 좌표 범위 전부 1로 초기화.
			for(int j = x; j<x+10; j++) {
				for(int k = y; k<y+10; k++) {
						arr[j][k] = 1;
					}
				}
		}
		// 근접이 아니면 전부 0이아닌 숫자로 변경
		int ct = 0; //리턴값
		for(int i = 1; i<=100; i++) {
			for(int j = 1; j<=100; j++) {
				if(arr[i][j] == 1) { // 만약 해당 지역이 0이라면 메서드 호출.: 근처에 1이 있는지 없는지 확인.
					ct += solution(i,j); // 해당 좌표의 인접한 0의 개수: 길이
				}
			}
		}
		System.out.println(ct);//출력
	}
	
	// 좌표 기준 4방에 0이 있는지 확인 -> 개수 리턴.
	private static int solution(int i, int j) {
		int ct = 0; // 1과 닿는 0의 개수
		for(int k = 0; k<4; k++) { //4방
			int nx = i + dx[k]; 
			int ny = j + dy[k];
			
			if(nx>=0 && ny>=0 && nx<=101 && ny<=101) { //인덱스 범위를 만족하고
				if(arr[nx][ny] == 0) {	// 만약 해당 지역이 0이라면
					ct++; // 길이 추가.
				}
			}
		}
		return ct; 
	}
}
/*
4
3 7
5 2
15 7
13 14
*/
package algorithm.daily.hw0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4_손민우 {
	
	static int n,m,k;
	static int[][] arr, arrk;
	static boolean visited[];
	static int cycle[];
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 배열의 가로길이
		m = Integer.parseInt(st.nextToken()); // 배열의 세로길이
		k = Integer.parseInt(st.nextToken()); // 회전 횟수
		arr = new int[n][m]; // n*m크기의 배열 
		arrk = new int[k][3]; // 3개의 정보를 가진 k개의 회전정보.
		visited = new boolean[k]; // 1~k까지의 순열을 위한 방문여부 체크배열.
		cycle = new int[k]; // k개의 조합원을 담을 배열: 인덱스 순으로 배열 회전.
		
		//배열에 데이터 입력
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//회전 정보 k개 데이터 입력
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arrk[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findMin(0);// 회전순서별 최소값 찾는 메서드 호출 : 순열이용.
		System.out.println(Min); //출력
	}
	
	private static int[][] turnArr(int a, int b, int c, int[][] sample) {//a,b,c: 회전정보 sample: arr복사배열
		int startY = a-c; // 시작 좌표 : 좌측상단				//복사이유: 회전정보k개를 여러개의 순서별로 돌고나면 다음 싸이클을 위해 기존 배열로 다시 초기화 해준다.
		int startX = b-c; // 시작 좌표 : 좌측상단
		int finishY = a+c; // 도착좌표 : 우측하단
		int finishX = b+c;	// 도착좌표: 우측하단
		// 위의 좌표 내에서 시계방향으로 회전: 밖에서부터 안쪽으로 따로 회전.: 횟수는 짧은변/2번
		for(int i = 0; i<=Math.min(finishY-startY+1, finishX-startX+1)/2-1; i++) {
			//덮여지는 값 미리 빼놓기
			int temp = sample[startY+i][startX+i];
			//좌측 이동
			for(int j = startY+i; j<=finishY-1-i; j++) {
				sample[j][startX+i] = sample[j+1][startX+i];
			}
			//아랫측 이동
			for(int j = startX+i; j<= finishX-1-i; j++) {
				sample[finishY-i][j] = sample[finishY-i][j+1];
			}
			//우측 이동
			for(int j = finishY-i; j>=startY+1+i; j--) {
				sample[j][finishX-i] = sample[j-1][finishX-i];
			}
			//윗측 이동
			for(int j = finishX-i; j>=startX+1+i; j--) {
				sample[startY+i][j] = sample[startY+i][j-1];
			}
			sample[startY+i][startX+i+1] = temp;
		}
		return sample; // 회전후 배열 리턴.-> 최솟값을 찾거나 같은 싸이클 내의 다음순서의 회전정보를 반영.
	}
	
	//최소값을 찾기위해 회전정보 k개의 순열.
	private static void findMin(int cnt) {
		if(cnt == k) { // k개의 회전정보 조합이 만들어지면(하나의 싸이클)
			int sample[][] = new int[n][m]; // 복사할 배열 생성
			//배열 복사
			for (int i = 0; i < n; i++) {
		          for (int j = 0; j < m; j++) {
		        	  sample[i][j] = arr[i][j];
		           }
		    }
			// 회전정보를 추출하고, 회전메서드의 매개변수로 담아 호출.
			for(int i = 0; i<k; i++) {
				//1~k의 수로 순열을 구했고, 해당 순서대로 회전정보 적용.
				int num = cycle[i]; //num번째 회전정보
				//회전정보
				int a = arrk[num][0]-1; //index값 문제해결: -1적용. 
				int b = arrk[num][1]-1;
				int c = arrk[num][2];
				sample = turnArr(a,b,c,sample);//회전메서드 호출. 반환값 다시 샘플에 초기화
												// -> 최솟값 찾기or(같은 싸이클 내의)다음 회전정보 반영.
			}
			//최솟값 찾기
			for(int i = 0; i<n; i++) { 
				int sum = 0;
				for(int j = 0; j<m; j++) {
					sum += sample[i][j];
					if(sum>Min) break; // 행의 합이 중간에 최솟값을 넘어가면 다음행으로
				}
				Min = Math.min(sum, Min); // 최소값 초기화.
			}
			return;
		}
		//0~k-1까지의 순열 구하기. : 회전 싸이클 구성
		for(int i = 0; i<k; i++) {
			if(!visited[i]) {
				visited[i] = true; // 해당 순서 사용.
				cycle[cnt] = i; //사용한 순서 싸이클에 담기
				findMin(cnt+1);	//다음 순서 구하기: 재귀
				visited[i] = false;	//종료전 사용한 순서 다시 반환
			}
		}
	}
}

package algorithm.daily.hw0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D2_1954_달팽이숫자_손민우 {
	static int n; // n*n배열 만들 n
	static int arr[][]; //달팽이 숫자 담을 배열
	static int dr[] = {0, 1, 0,-1}; //우->하->좌->상 이동하며 변할 y축좌표배열
	static int dc[] = {1, 0,-1, 0}; //변할 x축좌표배열
	static StringBuilder sb; //출력문 담기.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			//함수호출.( 좌표값 배열에 쓰일 초기 인덱스값 )
			solution(0);
			
			//출력.
			for(int i = 0; i <n; i++) {
				for(int j = 0; j< n; j++) {
					sb.append(arr[i][j]).append(" "); //원소 하나랑 공백 삽입.
				}
				sb.append("\n"); 
			}
			System.out.println("#"+tc); //테스트케이스 번호
 			System.out.print(sb); //출력
		}
	}
	
	private static void solution(int dist) {// 좌표값을 담은 배열에 쓰일 인덱스.
		arr = new int[n][n];
		sb = new StringBuilder();
		int y = 0;//숫자가 처음담길 y좌표
		int x = 0;//숫자가 처음담길 x좌표
		for(int i = 1; i <= n*n; i++) {
			arr[y][x] = i;
			y += dr[dist];// 달팽이관처럼 다음 숫자가 들어갈 y좌표 입력.
			x += dc[dist];//  x좌표입력.
			if(y>=n || x>=n || x<0 || y<0 || arr[y][x] != 0) { //x,y값이 배열길이를 넘거나, 다음 공간이 이미 차있다면=>방향바꿈.
				y -= dr[dist]; // 더해준 y좌표값을 다시 빼준다.
				x -= dc[dist]; // 더해준 x좌표값을 다시 빼준다.
				dist = (dist+1)%4; // 좌표배열 인덱스. 3을초과하지 않게 %4
				y += dr[dist]; // 바뀐 y좌표값을 더해준다.(방향바뀜)
				x += dc[dist]; // 바뀐 x좌표값을 더해준다.(방향바뀜)
			}
		}
		
		
			
	}

}

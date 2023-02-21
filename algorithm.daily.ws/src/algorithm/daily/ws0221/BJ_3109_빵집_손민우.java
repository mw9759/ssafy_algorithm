package algorithm.daily.ws0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_빵집_손민우 {
	static int r, c;
	static char[][] arr;
	static int count = 0;
	static boolean check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//배열크기
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		//초기화
		arr = new char[r][c];
		// 데이터 입력 
		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			for(int j = 0; j< c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		//세로축의 길이만큼 반복: 단위길이마다 파이프의 출발점이 된다. 
		for(int i = 0; i<r; i++) {
			pipe(i,0);
			check = false;
		}
		// 출력.
		System.out.println(count);
	}
	private static void pipe(int x, int y) {
		if(y == c-1) { // y가 우측 파이프라인에 도달하면
			count++;	// 갯수 추가
			check = true; // x번째 출발점 도착 확인
			return;
		}
		
		// 오른쪽상단: 도착확인이 안되었고, 다음 도착지가 인덱스 범위를 만족하며, 건물이나 다른 파이프라인이 아닐때: .일때 
		// 오른쪽 상단부터 확인하는 이유는 세로축 인덱스를 고려할때 위부터 채워가야 아래의 출발지점이 기회가 생긴다.
		if(check == false && x>0 && y<c-1 && arr[x-1][y+1] == '.') {
			arr[x-1][y+1] ='-';
			pipe(x-1, y+1);
		}
		//오른쪽
		if(check == false && y<c-1 && arr[x][y+1] == '.') {
			arr[x][y+1] = '-';
			pipe(x, y+1);
		}
		//오른쪽아래
		if(check == false && x<r-1 && y<c-1 && arr[x+1][y+1] == '.') {
			arr[x+1][y+1] = '-';
			pipe(x+1, y+1);
		}
		
	}
}
/*
5 5
.xx..
..x..
.....
...x.
...x.
*/
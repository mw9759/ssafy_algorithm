package algorithm.daily.hw0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이_손민우 {
	
	public static void main(String[] args) throws Exception{
		int arr[][] = new int[100][100]; // 100*100 크기의 배열 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //색종이 갯수
		int answer = 0; // 총 넓이
		
		//겹친부분은 무시하고, 0에서 1로 바뀐 순간에 총 넓이를 구해준다.
		for(int i = 0; i< n; i++) { //색종이 갯수만큼 반복.
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // x좌표
			int y = Integer.parseInt(st.nextToken()); // y좌표 받기.
			for(int j = y; j < y+10; j++) { //시작점브터 10번 반복 : 색종이 길이10
				for(int k = x; k<x+10; k++) {
					if(arr[j][k] == 0) { //만약 해당 구간이 0이면 
						arr[j][k] = 1;	// 1로 바꿔주고 넓이 1더해준다.
						answer += 1;
					}
				}
			}
		}
		System.out.println(answer);//출력
	}
}

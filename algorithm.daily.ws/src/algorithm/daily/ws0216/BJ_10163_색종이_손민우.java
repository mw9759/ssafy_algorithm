package algorithm.daily.ws0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10163_색종이_손민우 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[1001][1001];
		int arr2[] = new int[n+1]; // 색종이별로 차지하는 넓이 담기.
		int count = 1; //색종이별로 부여할 고유번호
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int x = Integer.parseInt(st.nextToken()); // 초기 좌표값 x
			int y = Integer.parseInt(st.nextToken()); // 초기 좌표값 y
			int width = Integer.parseInt(st.nextToken()); // 색종이 가로길이
			int height = Integer.parseInt(st.nextToken()); // 색종이 세로길이
			
			for(int j = x; j<x+width; j++) { // 배열을 전부 돌 필요 없이 시작점을 주어진 초기 좌표x로 하고, 끝을 x값 + 가로길이로 한다.
				for(int k = y; k<y+height; k++) { // y좌표값부터 y+높이 값만큼 반복
					if(arr[j][k] != count && arr[j][k] !=0) { // 만약 해당 지점이 현재 색종이 번호와 다르면서 0이 아니라면: 다른 색종이가 있는 경우
						arr2[arr[j][k]]--; // 색종이별로 차지하는 넓이를 담은 배열에서 하나씩 뺀다.: 현재 색종이로 덮을꺼임.
					}
					arr[j][k] = count;// 해당 지점에 현재 색종이 번호를 넣고
					arr2[count]++; // 넓이1추가
				}
			}
			count++; // 다음 색종이 번호 
			
		}
		//출력 1번 색종이부터 n번 색종이까지의 넓이
		for(int i = 1; i<=n; i++) {
			System.out.println(arr2[i]);
		}
	}

}

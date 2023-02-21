package algorithm.daily.ws0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6987_월드컵_손민우_pt {

	static int arr[][];
	static int check = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[6][3];
		for(int k = 0; k<4; k++) {
			st = new StringTokenizer(br.readLine());
			check = 0;
			for(int i = 0; i<6; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}
			worldCup(0,1);
			
			System.out.print(check == 1 ? 1:0+" ");
		}
	}
	private static void worldCup(int x, int y) {
		if(check == 1) return;
		// x가 5인경우 남은 경기가 없음으로 입력받은 결과배열의 원소가 전부 0이여야한다.
		if(x == 5) {
			int game = 1;
			for(int i = 0; i<6; i++) {
				for(int j = 0; j<3; j++) {
					if(arr[i][j] > 0) game =0;
				}
			}
			if(game!=0) {
				check = 1;
			}
			return;
		}
		
		//x가 이길때
		if(arr[x][0] > 0 && arr[y][2] > 0) {
			arr[x][0]--;
			arr[y][2]--;
			
			if(y == 5) {
				worldCup(x+1, x+2);
			}
			else {
				worldCup(x, y+1);
			}
			
			// x가 y를 이긴 경우의 뒷경기들의 경우의 수를 다 보고 왔으면 해당 경기 결과는 리셋: 무승부일 경우와 x가 졌을 경우를 확인해봐야 한다.
			arr[x][0]++;
			arr[y][2]++;
		}
		
		//무승부일때
		if(arr[x][1]>0 && arr[y][1] >0) {
			arr[x][1]--;
			arr[y][1]--;
			
			if(y == 5) {
				worldCup(x+1, x+2);
			}
			else {
				worldCup(x, y+1);
			}
			
			arr[x][1]++;
			arr[y][1]++;
		}
			
		//x가 졌을때
		if(arr[x][2]>0 && arr[y][0]>0) {
			arr[x][2]--;
			arr[y][0]--;
			
			if(y == 5) {
				worldCup(x+1, x+2);
			}
			else {
				worldCup(x, y+1);
			}
			
			arr[x][2]++;
			arr[y][0]++;
		}
	}
}



//4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
//5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
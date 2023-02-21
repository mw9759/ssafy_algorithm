package algorithm.daily.ws0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6987_월드컵_손민우 {
	static int answer = 0;
	static int arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[6][3];
		
		for(int i = 0; i<4; i++) { // 4개의 조 입력
			st = new StringTokenizer(br.readLine());
			answer = 0;
			for(int j = 0; j<6; j++) {
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
				arr[j][2] = Integer.parseInt(st.nextToken());
			}
			// 메서드 호출 0: 첫번째 국가와 1: 두번째 국가가 뜸
			worldCup(0,1);
			System.out.print(answer+ " ");
		}
	}
	private static void worldCup(int home, int visit) {
		// 만약 정상경기임을 알게 되었다면
		if(answer == 1) return;
		// 5번 국가가 홈이 되면 모든 경기를 다 치룬상태. 
		if(home == 5) {
			// 경기가 무사히 마친 경우: 각 국가별 승무패 카운트가 전부 000이여야 한다.
			int flag = 1;
			for(int i = 0; i<6; i++) {
				for(int j =0; j<3; j++) {
					if(arr[i][j] != 0) {// 만약 승무패 카운트가 0 0 0이 아니라면 플래그.
						flag = 0;
					}
				}
			}
			//만약 플래그가 1이라면: 정상경기 
			if(flag ==1) {
				answer = 1; // 출력에 1: 정상경기 
			}
			return;
		}
		
		// 홈이 원정을 이긴경우: 홈과 원정 국가의 승,패 카운트가 1이상씩은 있어야 성립한다.
		if(arr[home][0]>0 && arr[visit][2]>0) {
			arr[home][0]--; // 해당 홈이 이겨서 홈 승 카운트 다운
			arr[visit][2]--; // 해당 원정이 져서 원정 패 카운트 다운
			
			//만약 이 경기에서 원정국가 5인 경우 홈 국가는 모든 국가들과 경기를 치룬 상태
			// -> 홈이였던 국가는 더이상 경기x 다음 홈 국가로 바뀌며 원정도 이 경기 홈번호+2 국가가된다.
			if(visit == 5) worldCup(home+1, home+2);
			//홈 기준 다음 경이 진행 : 다음 원정.(현재 원정번호+1)
			else worldCup(home, visit+1);
			
			// 위의 모든 경우의 수를 고려하고 나면 홈과 원정이 비긴경우, 홈이 진 경우를 봐야하기 때문에 경기결과를 리셋해줌.
			arr[home][0]++;
			arr[visit][2]++;
		}
		
		// 홈과 원정이 비긴경우: 홈과 원정 국가의 무승부 카운트가 1이상씩은 있어야 성립한다.
		if(arr[home][1]>0 && arr[visit][1]>0) {
			arr[home][1]--; // 무승부 카운트 다운
			arr[visit][1]--; // 무승부 카운트 다운

			if(visit == 5) worldCup(home+1, home+2);
			//홈 기준 다음 경이 진행 : 다음 원정.(현재 원정번호+1)
			else worldCup(home, visit+1);
			
			// 위의 모든 경우의 수를 고려하고 나면 홈과 원정이 비긴경우, 홈이 진 경우를 봐야하기 때문에 경기결과를 리셋해줌.
			arr[home][1]++;
			arr[visit][1]++;
		}
		
		// 홈이 원정에게 진경우 : 홈과 원정 국가의 패, 승 카운트가 1이상씩은 있어야 성립한다.
		if(arr[home][2]>0 && arr[visit][0]>0) {
			arr[home][2]--; // 패 카운트 다운
			arr[visit][0]--; // 승 카운트 다운
			
			if(visit == 5) worldCup(home+1, home+2);
			//홈 기준 다음 경이 진행 : 다음 원정.(현재 원정번호+1)
			else worldCup(home, visit+1);
			
			// 위의 모든 경우의 수를 고려하고 나면 홈과 원정이 비긴경우, 홈이 진 경우를 봐야하기 때문에 경기결과를 리셋해줌.
			arr[home][2]++;
			arr[visit][0]++;
		}
	}

}

package algorithm.daily.hw0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_14510_나무높이_손민우 {

	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			int sum = 0;
			int maxTree = 0;
			for(int i = 0; i<n; i++) {
				int tree = Integer.parseInt(st.nextToken());
				arr[i] = tree;
				maxTree = maxTree<tree ? tree:maxTree; // 제일 긴 나무의 길이 구하기
			}
			
			
			int only1 = 0; // 홀수날만 줄수 있는 날 수
			int day2 = 0; // 짝수날에 줄수 있는 날 수
			int answer = 0; // 정답 담을 변수
			// 홀수날 짝수날 물줄 수 있는날 탐색.
			for(int i = 0; i<n; i++) {
				if(arr[i] == maxTree) continue; // 최대값이면 패스
				only1 += (maxTree-arr[i])%2;
				day2 += (maxTree-arr[i])/2;
			}
			
			int a = Math.min(only1, day2); // 두 날중에 최솟값 담기
			only1 -=a;	// 최소값만큼 빼주기
			day2 -=a;	// 최소값만큼 빼주기
			answer += 2*a; // 최소값은 (홀수날+짝수날) 세트의 개수임으로 정답에 *2를 해주어 물을 준 일수를 채운다.
			
			// 만약 두 일수가 같다면 일수가 딱 떨어짐으로 다음 테케로
			if(only1 == day2) {
				System.out.println("#"+tc+" "+answer);
				continue;
			}
			// 첫번째 날이 0이라면 
			if(only1 == 0) {
				day2 *=2; // 2만큼 자라는 일수의 개수임으로 총 day2*2가 자라야한다.
				answer+= (day2/3)*2; // 홀수날+짝수날=3만큼 자라므로 이 세트수(몫)를 구해*2를 해줘 필요한 일수를 더한다.
				answer+= day2%3; // 몫이 아닌 나머지는 결국 세트 조건(첫+둘)을 채우지 못함으로 나머지를 더해준다
													// 1이면 홀수날이 필요함으로 +1, 2이면 짝수날 +2: 홀수날은 물 안주기.
			}
			else {
				answer += only1 == 1 ? 1:only1*2-1; // 둘째날이 0이라면 필요한 첫쨋날이 1일때는 1, 그게 아니면 *2-1
			}
			System.out.println("#"+tc+" "+answer);//출력
		}
	}
}
/*
1
20
26 19 23 2 24 2 17 15 1 27 6 29 18 23 27 13 26 21 9 1
*/
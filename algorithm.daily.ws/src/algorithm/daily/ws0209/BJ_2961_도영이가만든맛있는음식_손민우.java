package algorithm.daily.ws0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이가만든맛있는음식_손민우 {
	
	static int n; // 재료의 개수
	static int sin[]; // 신맛정도를 담을 배열
	static int ssuen[]; // 쓴맛정도를 담을 배열
	static boolean isSelected[];// 선택된 재료인지 확인. 
	static int sub = Integer.MAX_VALUE;// 신맛과 쓴맛 차이의 최솟값
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sin = new int[n]; //신맛 배열 초기화
		ssuen = new int[n]; //쓴맛배열 초기화
		isSelected = new boolean[n]; //선택재료 왁인배열 초기화
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			ssuen[i] = Integer.parseInt(st.nextToken());
		}
		solution(0);
		System.out.println(sub);
	}
	
	private static void solution(int cnt) {
		if(cnt == n) {
			int sinL = 1; //신맛 초기값
			int ssuenL = 0; // 쓴맛 초기값
			boolean flag = false; // 공집합이 있다면 |신맛-쓴맛|이 항상 1이되기에 공집합을 구분하기 위한 논리형 변수.
			
			for(int i = 0; i<n; i++) { // 재료개수 만큼 반복. 
				if(isSelected[i]) { //만약 재료가 사용되었다면
					sinL *= sin[i]; // 신맛 상승(곱)
					ssuenL += ssuen[i]; // 쓴맛 상승(합)
					flag = true; // 이 if문이 돌아갔다면 공집합을 구분하기 위한 논리형 변수가 true가 된다.-> 공집합일 경우엔 if문이 돌지 않아 여전히 false
				}
			}
			if(!flag) return; // 만약 공집합이여서 if문을 돌지 못해 false라면 그냥 리턴
			
			int subSinSsuen = Math.abs(sinL-ssuenL); // 공집합이 아닐경구 신-쓴의 절대값을 저장해줄 변수.
			
			sub = sub>subSinSsuen ? subSinSsuen:sub; // 신-쓴 의 수치를 저장한 변수와 새로운 조합의 신-쓴중 더 작은 값이 sub에 들어간다. 
			return;
		}
		
		//현재 원소 포함시키고 재귀
		isSelected[cnt] = true;	// 이재료는 쓰겠다.																																																																			
		solution(cnt+1); // 다음 재료 대상 재귀.
		
		//현재 원소 불포함시키고 재귀
		isSelected[cnt] = false; // 이 재료는 쓰지 않겠다.
		solution(cnt+1); // 다음재료 대상 재귀 
	}
}



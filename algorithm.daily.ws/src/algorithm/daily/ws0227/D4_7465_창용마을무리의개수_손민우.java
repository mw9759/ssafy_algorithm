package algorithm.daily.ws0227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수_손민우 {
	
	static int arr[]; // n개의 집합을 담을 배열.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //테케 수
		// 테케 수만큼 반복.
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 집합의 개수
			int m = Integer.parseInt(st.nextToken()); // 관계의 개수: 두 사람간의 친분관계 유무
			
			arr = new int[n+1]; // n+1 만큼 선언. 1번사람은 1번방.
			//초기화
			for(int i = 1; i<=n; i++) {
				arr[i] = i;
			}
			
			// m만큼 반복.: 입력 받는대로 합.
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b); // 두 사람을 같은 곳에 놓기.== 합집합.
			}
			// 이루어진 무리 확인.
			int count = 0; // 무리개수 카운트
			for(int i = 1; i<=n; i++) { // 사람 수만큼 반복.
				if(findSet(i)==i) count++; // 만약 무리의 번호와 무리장의 번호가 같다면 하나의 무리이다.
			}
			
			System.out.println("#"+tc+" "+count); // 출력.
		}
	}
	// 합
	private static void union(int a, int b) {
		int rootA = findSet(a); // a번호의 사람이 속한 모임번호
		int rootB = findSet(b); // b번호의 사람이 속한 모임번호
		
		if(rootA == rootB) return; // 만약 같다면 같은 모임.
		
		arr[rootB] = rootA; // 다르다면 같은 모임으로 만들어준다.
		return;
	}
	// 모임번호 찾기.
	private static int findSet(int a) { // a번호의 사람.
		
		if(arr[a] == a) return a; // a번호의 사람이 속한 무리번호가 a라면 a반환
		//아니라면
		return arr[a] = findSet(arr[a]);
	}
	
}

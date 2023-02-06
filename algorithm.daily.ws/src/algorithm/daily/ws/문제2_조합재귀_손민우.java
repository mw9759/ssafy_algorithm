package algorithm.daily.ws;

public class 문제2_조합재귀_손민우 {
	static int arr[] = {1,2,3,4,5,6}; //배열선언
	static int k = 6; //조합개수선언
	private static int combination(int cnt, int idx) {
		int answer = 0; //조합개수담을 변수선언.
		// k개를 선택했으므로, 1리턴 .
		if (cnt == k) {
			return 1;
		}
		// 대상 집합을 주어진 인덱스부터 순회하며 조합 숫자 선택.
		for (int i = idx; i < arr.length; i++) {
			// 자신을 재귀 호출(중복방지를위해 자기자신+1) cnt가 k가되서 1을 리턴할때까지 재귀.
			answer += combination(cnt + 1, i + 1); //현재조합된개수, 시작인덱스
		}
		return answer; //개수리턴
	}
	
	public static void main(String[] args) {
		System.out.println(combination(0,0));
	}

}

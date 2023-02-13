package algorithm.daily.ws0213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ_1339_단어수학_손민우 {
	
	static int n; // n값 선언.
	static Map<Character, Integer> m = new HashMap<>(); // 알파벳별 총 자릿수값 담을 맵 A:100
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine()); //초기화
		
		System.out.println(solution()); //메서드호출 및 리턴값 출력
	}

	private static int solution() throws Exception{
		int answer = 0;
		for(int i = 0; i<n; i++) {
			String str = br.readLine(); //문자열 불러오기
			int cnt = 1;				//자리수별 더할 값 1: 첫번째 자리 10: 두번째자리 100: 세번째자리 
			for(int j = str.length()-1; j>=0; j--) { //마지막 문자열이 첫번째 자리 마지막 문자부터 for문
				// 키가 m에 존재한다면 그 키의 value+자리값: 누적합 / 키가m에 존재안하면 0+자리값 : 새값
				m.put(str.charAt(j), m.getOrDefault(str.charAt(j), 0)+cnt);
				cnt *= 10; // 자리수가 올라갈때마다 *10
			}
		}
		List<Integer> values = new ArrayList<>(m.values()); //value값들만 필요하기에 따로 list로 저장.
		Collections.sort(values);	// 정렬해서 높은 수부터 큰값==9을 곱해준다.
									//=>위의 for문에서 a-z전부 1로보고 자리값만 넣어줬다.
		
		for(int i = values.size()-1, cnt=9 ; i>=0; i--,cnt--) { //오름차순이기에 뒤에서부터 9부터 곱해준다.
			answer += values.get(i)*cnt;//리턴변수인 answer값에 누적합
		}
		return answer;
	}

}

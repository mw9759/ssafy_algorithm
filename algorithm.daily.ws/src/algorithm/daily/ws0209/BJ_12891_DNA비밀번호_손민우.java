package algorithm.daily.ws0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_12891_DNA비밀번호_손민우 {
	
	static int s; //처음 받을 문자열의 길이
	static int p; // 설정할 암호의 길이
	static char[] ACGT = {'A', 'C', 'G', 'T'}; // DNA배열에 ACGR각각 몇개씩 들어있나 담을 배열. 
	static HashMap<Character, Integer> map = new HashMap<>();// 슬라이싱된 문자열에 들어있는 acgr각각의 개수 담을 맵
	static int A;
	static int C;
	static int G;
	static int T;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		String str = br.readLine(); //문자열 받아오기.
		
		// 필수로 있어야할 ACGT 개수 받아오기.
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		System.out.println(solution(str));
	}
	
	private static int solution(String str) {
		int answer = 0;
		map.put('A', 0);
		map.put('C', 0);
		map.put('G', 0);
		map.put('T', 0);
		
		// 첫번째 슬라이싱 담기.
		for(int j = 0; j<p; j++) {
			map.put(str.charAt(j), map.get(str.charAt(j))+1);
		}
		if(map.get('A')>=A && map.get('C')>=C && map.get('G')>=G && map.get('T')>=T) {
			answer++;
		}
		
		int start = 0;
		int end = start+p;
		for(int i = 0; i<s-p; i++) {
			map.put(str.charAt(start+i), map.get(str.charAt(start+i))-1);
			map.put(str.charAt(end+i), map.get(str.charAt(end+i))+1);
			if(map.get('A')>=A && map.get('C')>=C && map.get('G')>=G && map.get('T')>=T) {
				answer++;
			}
		}
		return answer;
	}
}
package algorithm.daily.hw0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기_손민우 {

	static int l, c; // 암호의 길이, 주어진 알파벳 개수
	static char[] arr; //입력받을 알파벳 담을 배열
	static char[] password; // 비밀번호를 담을 배열
	static int count1, count2; // 모음과 자음 개수를 카운팅할 변수
	static String str = "aeiou"; // 모음 확인용 문자열
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 암호길이, 알파벳 개수, 알파벳 입력 초기화
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		password = new char[l];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		// 정렬된 암호를 구해야 하기에 오름차순으로 정렬해서 조합을 구하려고 한다.
		Arrays.sort(arr);
		solution(0,0,0,0); // 암호의 인덱스, 시작 인덱스, 모음의 개수, 자음의 개수
		System.out.println(sb); //출력
	}
	
	private static void solution(int cnt, int start, int count1, int count2) {// 암호의 인덱스, 시작 인덱스, 모음의 개수, 자음의 개수
		if(cnt == l) { // 암호가 완성이 되면
			if(count1<1 || count2<2) return; // 우선 모음과 자음의 최소 개수가 부족하면 리턴,
			//암호 출력
			for(int i = 0; i<l; i++) { 
				sb.append(password[i]);
			}sb.append("\n");
			return;
		}
		
		for(int i = start; i<c; i++) {
			password[cnt] = arr[i]; // 암호배열에 주어진 알파벳 입력
			if(str.contains(Character.toString(arr[i]))) { //만약 알파벳이 모음이라면
				solution(cnt+1,i+1,count1+1,count2); // 모음 개수를 올려주며 재귀호출
			}
			else {										// 만약 알파벳이 자음이라면
				solution(cnt+1,i+1,count1,count2+1); // 자음 개수를 올려주며 재귀호출
			}
		}
	}
}

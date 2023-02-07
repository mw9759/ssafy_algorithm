package algorithm.daily.ws0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class D3_1208_SW문제해결기본1일차_Flatten_손민우 {
//	private static int arr[];
	private static List<Integer> arr; // 데이터받을 list 선언.멤버.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 입력값 받을 뤼더 생성.
		for(int tc = 1; tc<=10; tc++) { //테케 10개.
			int n = Integer.parseInt(br.readLine()); // n값 초기화
			arr = new ArrayList<>(); // arr 초기화
			StringTokenizer st = new StringTokenizer(br.readLine()," "); //입력값 한줄 불러와서 쪼개기.
 			while(st.hasMoreElements()) { //만약 불러올 요소가 더 있다면 반복.
				arr.add(Integer.parseInt(st.nextToken())); //arr에 쪼개진 데이터 삽입
			}
//			Arrays.sort(arr);
			System.out.println("#"+tc+" "+solution(n, arr.size())); // 메서드 리턴값 출력
		}
	}
	
	private static int solution(int n, int len) {
		int answer = 0;
		for(int i = 0; i<n; i++) {
		    int maxIdx = arr.indexOf(Collections.max(arr));
		    int minIdx = arr.indexOf(Collections.min(arr));
		    arr.set(maxIdx, arr.get(maxIdx)-1);
		    arr.set(minIdx, arr.get(minIdx)+1);
		}
		
		answer = Collections.max(arr) - Collections.min(arr);
		return answer;
	}

}

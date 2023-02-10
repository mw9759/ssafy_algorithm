package algorithm.daily.hw0210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이 {
	static int arr[] = new int[9]; // 입력값 9개 담을 배열.
	static int arr7[] = new int[7]; // 입력값 7개 담을 배열.
	static boolean flag = false;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) { // 입력값 만큼 배열에 넣기
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		solution(0, 0);//메서드 호출.
		//출력
		System.out.println(sb);
	}
	
	//재귀로 조합구해서 조건만족하면 바로 탈출.
	private static void solution(int cnt, int start) {
		if(cnt == 7) { //만약 7명 난쟁이 키가 모이면 
			int sum = 0;  //키를 모두 더할 sum변수 초기화
			for(int i = 0; i<7; i++) sum += arr7[i]; //키 다 더하기.
			if(sum == 100) { //만약 합이 100이라면
				Arrays.sort(arr7); //우선 정렬하고
				for(int i : arr7) sb.append(i).append("\n"); //출력문에 저장.
				flag = true; //신호를 true를 줘서 조건을 만조했다 알림.
			}
			return;//7개의 키를 다 채웠으니 탈출,
		}
		
		for(int i = start; i < 9; i++) { //9명의 키에서 조합 찾음.
			arr7[cnt] = arr[i]; //조합원 을 하나씩 삽입. 7명 모이면 if문 돈다.
			solution(cnt+1,start+1); // 재귀.
			if(flag) return; //true신호를 받으면 재귀 탈출.
		}
	}

}

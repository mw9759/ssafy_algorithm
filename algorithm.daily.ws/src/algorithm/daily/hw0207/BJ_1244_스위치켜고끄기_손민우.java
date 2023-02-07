package algorithm.daily.hw0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기_손민우 {
	private static int arr[];//스위치 담을 배열.
	private static int students[][]; //학생별 성별과 소유숫자 담을 2차원 배열 선언.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");//문자열 슬라이싱.
		arr = new int[n];//배열 초기화
		for(int i = 0; i < n; i ++) { //스위치의 개수만큼 돌려 스위치값 배열에 초기화
			arr[i] = Integer.parseInt(st.nextToken()); // 공백으로 슬라이싱된 값 배열에 초기화
		}
		
		int m = Integer.parseInt(br.readLine()); // 학생수
		students = new int[m][2]; // 배열초기화
		for(int i = 0; i < m; i++) { // 학생수만큼 반복.
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<2; j++) { // 학생정보 두가지만큼 반복.(성별, 소유숫자)
				students[i][j] = Integer.parseInt(st.nextToken());//(성별, 소유숫자)
			}
		}
		solution(0, n, m,1); // 초기 인덱스값, 전구수, 학생수, 여학생규칙 처릴위한 count.
		
		//출력문
		for(int i = 1; i <= n; i++) { //전구수 만큼 반복 
			System.out.print(arr[i-1]+" "); //전구온오프 여부 + 공백
			if(i%20 == 0) // 나머지가 없으면 20개가 출렷됬으므로 다음열로.
				System.out.println(); //라인공백 출력.
		}
	}
	
	private static void solution(int idx, int n, int m, int count) {
		if(idx == m) return; //학생수만큼 돌았으면 탈출.
		
		if(students[idx][0]==1) { //남학생이라면
			for(int i = students[idx][1]-1; i<n; i+=students[idx][1]) { //시작점:남학생 보유숫자, 증가량: 남학생 보유숫자.
				arr[i] = arr[i]>0 ? 0:1; //람다식 이용해서 0보다 큰 값이면 1이기에 0으로. 아니면 1로.
			}
			solution(++idx, n, m, count); // 스위치 스위칭 됬으면 다음 학생으로 재귀.
		}
		else { //여학생이라면.
			int g = students[idx][1]-1; // 현재 위치 index
			if(count ==1) //출발점은 한번만 바꿔야되니까 재귀전에 한번만.
				arr[g] = arr[g]>0? 0:1; // 현재 위치(출발점) 스위치 변경.
				
			if(g-count>=0 && g+count<n && arr[g-count] == arr[g+count]) { //인덱스를 안벗어나며 좌측값=우측값일때.
				arr[g-count] = arr[g-count]>0? 0:1; 
				arr[g+count] = arr[g+count]>0? 0:1; 
				solution(idx, n, m, ++count); //재귀호출: 카운트를 증가시켜 출발점기준 -n +n 위치 조회.
			}else { // 인덱스를 벗어나거나 좌값!=우값  이라면.
				solution(++idx, n, m, 1); //다음 학생조회. count 1로 초기화.
			}
		}
			
		
	}

}

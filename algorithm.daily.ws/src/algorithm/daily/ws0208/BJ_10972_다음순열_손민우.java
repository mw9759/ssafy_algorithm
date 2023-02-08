package algorithm.daily.ws0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10972_다음순열_손민우 {
	private static int n;
	private static int[] arr; // 현재순열
	private static int[] arr2; // n개만큼 담길 수열 배열.
	private static int count; // 순열 순번 체크.
	private static int check; // 현재순열과 n번째 순열과 같을때 n값 받을 변수.
	static boolean[] isSelected;// 조합원이 조합에 포함했나 확인.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n]; //초기화
		isSelected = new boolean[n]; // 초기화
		arr2 = new int[n]; // 초기화
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solution(0);
		if(Arrays.equals(arr, arr2)) {
			System.out.println(-1);
		}
	}
	
	private static void solution(int cnt) {
		if(cnt == n) {
			if(check == 1) {
				for(int i : arr2) {
					System.out.print(i+" ");
				}
				System.out.println();
				check = 0;
				return;
			}
			if(Arrays.equals(arr, arr2)) {
				check = 1;
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				arr2[cnt] = i+1;
				solution(cnt+1);
				isSelected[i] = false;
			}
		}
	}
}

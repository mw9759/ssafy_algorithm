package algorithm.daily.ws0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링_손민우 {
	static int N;
	static int[] people;
	static boolean visited[];
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		visited = new boolean[N+1];
		arr = new int[N+1][N+1];
		//인구수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0; j<count; j++) {
				int to = Integer.parseInt(st.nextToken());
				arr[i][to] = 1;
			}
		}
		
//		for(int i[]:arr) {
//			System.out.println(Arrays.toString(i));
//		}
		부분집합(1);
		System.out.println(min);
	}
	
	private static void 부분집합(int cnt) {
		
		if(cnt == N+1) {
			int count = 0;
			int sumA = 0;
			int sumB = 0;
			ArrayList<Integer> groupA = new ArrayList<>();
			ArrayList<Integer> groupB = new ArrayList<>();
			for(int i = 1; i<=N; i++) {
				if(visited[i]) {
					groupA.add(i);
					count++;
					sumA += people[i];
				}else {
					groupB.add(i);
					sumB += people[i];
				}
			}
			if(count == 0 || count == N) return;
			
//			if(구역검증(groupA, groupB)) {
//				min = Math.min(min, Math.abs(sumA-sumB));
//			}
			return;
		}
		
		visited[cnt] = true;
		부분집합(cnt+1);
		visited[cnt] = false;
		부분집합(cnt+1);
	}
	
	private static boolean 구역검증(ArrayList<Integer> groupA, ArrayList<Integer> groupB) {

		
		return true;
	}
}
/*
6
5 2 3 4 1 2
2 2 4
4 1 3 6 5
2 4 2
2 1 3
1 2
1 2
*/
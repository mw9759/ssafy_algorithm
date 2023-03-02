package algorithm.daily.ws0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링_손민우 {
	static int N; // 구역의 갯수
	static int[] people; // 구역별 인구수를 담을 배열
	static boolean visited[]; // 구역을 나눌때 사용여부 담을 배열
	static int[][] arr; // n번 구역과 연결된 구역은 1로 초기화 할 배열.
	static int min = Integer.MAX_VALUE; // 인구수 차이의 최소값을 담을 변수.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//초기화
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		visited = new boolean[N+1];
		arr = new int[N+1][N+1];
		
		//인구수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구역별 연결 현황 입력받아 저장.
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0; j<count; j++) {
				int to = Integer.parseInt(st.nextToken());
				arr[i][to] = 1; // i번 구역과 to번 구역은 연결되어서 1.
			}
		}
		// 메서드 호출
		부분집합(1);
		if(min == Integer.MAX_VALUE) min = -1; // 만약 최소값이 변경이 없다면->구역 나누기가 불가능->-1로 초기화
		//출력
		System.out.println(min);
	}
	
	private static void 부분집합(int cnt) {
		if(cnt == N+1) { // n개의 구역이 다 나우어 졌다면
			int count = 0; // 나우어진 구역중 한 구역을 카운팅할 변수
			int sumA = 0; // A그룹의 총 인구수
			int sumB = 0; // B그룹의 총 인구수
			ArrayList<Integer> groupA = new ArrayList<>(); // A그룹의 포함된 선거구 담기.
			ArrayList<Integer> groupB = new ArrayList<>(); // B그룹의 포함된 선거구 담기
			// 담는과정.
			for(int i = 1; i<=N; i++) {
				if(visited[i]) { // true인구역: A그룹
					groupA.add(i); // 그룹담기
					count++;		//카운팅
					sumA += people[i];
				}else {       	// false인구역: B그룹
					groupB.add(i);
					sumB += people[i];
				}
			}
			// 만약 어떤 한 그룹이 0이거나 N이면 둘 중 한 그룹은 0이기에 다시 나눈다.
			if(count == 0 || count == N) return;
			
			// 나눈 구역의 모든 선거구가 연결되어 있어야 함으로 검증.
			if(구역검증(groupA) && 구역검증(groupB)) { // 두 구역 모두 이상이 없다면 
				min = Math.min(min, Math.abs(sumA-sumB));	// 인구수 차 초기화.
			}
			return;
		}
		// 부분집합 구하기.
		visited[cnt] = true; // 이 선거구를 포함했을때
		부분집합(cnt+1);// 다음 선거구 확인
		visited[cnt] = false;// 포함 안했을때
		부분집합(cnt+1);
	}
	
	private static boolean 구역검증(ArrayList<Integer> group) {
		Queue<Integer> que = new LinkedList<Integer>();//검증할 선거구 담을 큐
		int visit[] = new int[N+1]; // 선거구 검증 유무를 담을 배열
		que.add(group.get(0));	// 큐에 검증할 첫 선거구 삽입.
		visit[group.get(0)] = 1; // 유무 체크
		int count = 1; // 검증에 통과한 선거구 갯수 카운팅.
		
		while(!que.isEmpty()) { // 큐가 빌때까지 반복.
			int a = que.poll(); // 검증할 선거구.
			
			for(int i = 0; i<group.size(); i++) { // 검증할 같은 구역내의 선구들의 수만큼 반복.
				if(visit[group.get(i)] == 0) { // i번째 선거구를 아직 검증하지 않았다면.
					if(arr[a][group.get(i)] == 1) {// a선거구 와 i번째 선거구가 연결되어 있다면
						que.add(group.get(i)); // 큐에 i번째 선거구 삽입.-> 다음while문에서 i번째 선거구 검증.
						visit[group.get(i)] = 1; // 검증 체크
						count++; // 검증되었으니 갯수 추가.ss
					}
				}
			}
		}
		if(count == group.size()) return true; //구역내의 모든 선거구가 연결되었다면: count가 구역내의 선거구 갯수라면.true
		return false;// 아니라면 false리턴.
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
package algorithm.daily.ws0227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3289_서로소집합_손민우 {
	static int arr[]; // n개의 집합을 담을 배열
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		
		for(int tc = 1; tc<=t; tc++) { // 케이스별로 반복.
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			arr = new int[n+1];// 배열 길이 초기화. 원소 1의 부모를 1에 담을거이기에 n+1
			for(int i = 1; i<=n; i++) {
				arr[i] = i;
			}
			//테스트케이스 번호 출력
			System.out.print("#"+tc+" ");
			// 입력을 받는대로 수행.
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int q = Integer.parseInt(st.nextToken()); // 합치는작업: 0, 여부확인: 1
				int a = Integer.parseInt(st.nextToken()); // 집합 a
				int b = Integer.parseInt(st.nextToken()); // 집합 b
				if(q == 0) { // 합치는 작업이라면 
					union(a,b); // 집합a와 집합b를 합친다.
				}
				else if(q == 1) { // 여부를 확인하는 작업.
					System.out.print(check(a,b)); // 결과 출력. 부모가 같으면 1 다르면 0
				}
			}
			System.out.println(); // 줄바꿈.
		}
	}
	// 합집합 처리
	static void union(int a, int b) { // 집합 a, 집합 b
		int rootA = findSet(a); // 집합 a의 부모
		int rootB = findSet(b); // 집합 b의 부모
		if(rootA == rootB) return; // 부모가 같다면 그냥 리턴.
		//다르다면 둘중 한곳에 부모 일치화.
		arr[rootB] = rootA;
		return;
	}
	// 합집합인지 확인
	static int check(int a, int b) {
		if(findSet(a) == findSet(b)) return 1; // 부모가 같으면 합칩합임으로 1 반환
		return 0;
	}
	// 부모 찾기.
	static int findSet(int a) {// 집합 a
		// 자신의 부모와 자신이 같으면 자신이 대표자(짱)
		if(arr[a] == a) return a;
		// pass compresion: 내가 속한 root node(짱짱) 반환
		return arr[a] = findSet(arr[a]);
	}
}
/*
5
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
5
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
*/
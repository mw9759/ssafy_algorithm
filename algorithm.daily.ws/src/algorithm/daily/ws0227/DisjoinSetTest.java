package algorithm.daily.ws0227;

import java.util.Arrays;

//서로소 집합
public class DisjoinSetTest {
	static int N;
	static int[] parents;
	
	// 최소 단위 집합생성
	static void makeSet() {
		// 자신의 부모노드를 자신의 값으로 셋팅
		for (int i = 0; i < N; i++) {
			parents[i] = i; // 자신의 부모를 자신으로 지정
		}
	}
	// 속한 집합찾기 : a가 속한 대표자(짜아아앙) 찾기
	static int findSet(int a) {
		// 자신의 부모와 자신이 같으면 자신이 대표자(짱)
		if(parents[a] == a) return a;
		// pass compresion: 내가 속한 root node(짱짱) 반환
		return parents[a] = findSet(parents[a]);
	}
	
	// 두집합 합치기
	static boolean union(int a, int b){
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		// a, b의 root(짱)가 동일하므로 같은집합.
		// 같은집합은 합칠 필요가 없슴. 합치지 못함.
		if(aRoot == bRoot) return false;
		// aRoot(집합)에 bRoot(집합) 합치기
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) {
		N = 5;
		parents = new int[N];
		
		makeSet();
		System.out.println(Arrays.toString(parents));
		
		System.out.println("== union ==");
		// 중간에 합쳐졌다면 parents 변화가 발생했으니 출력확인.
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3, 2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(4,3));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("== findSet == ");
		System.out.println(findSet(4));
		// path compression 바랭할수 있으니 출력확인
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
	}

}

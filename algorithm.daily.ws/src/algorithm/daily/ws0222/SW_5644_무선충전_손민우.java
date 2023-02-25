package algorithm.daily.ws0222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SW_5644_무선충전_손민우 {

	static int n, a; // 이동거리 , bc개수
	static int Aman[], Bman[];
	static int bc[][];
	static int sum;
	static int pointA[]= new int[2], pointB[]= new int[2];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			Aman = new int[n];
			Bman = new int[n];
			bc = new int[a][4];
			sum = 0;
			pointA[0] = pointA[1] = 1;
			pointB[0] = pointB[1] = 10;
			
			st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				Aman[j] = Integer.parseInt(st.nextToken());
				Bman[j] = Integer.parseInt(st2.nextToken());
			}
			
			for(int i = 0; i<a; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<4; j++) {
					bc[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			move(0);
			System.out.println("#"+tc+" "+sum);
		}
	}
	static List<int[]> am;
	static List<int[]> bm;
	private static void move(int cnt) {
		
		while(cnt<=n) {
			am = new ArrayList<>();
			bm = new ArrayList<>();
			for(int i = 0; i<a; i++) {
				if(Math.abs(pointA[0]-bc[i][1])+ Math.abs(pointA[1]-bc[i][0]) <= bc[i][2]) {// I번 bc존에 포함되있다.
					int arr[] = {i,bc[i][3]};
					am.add(arr);
				}
				if(Math.abs(pointB[0]-bc[i][1])+ Math.abs(pointB[1]-bc[i][0]) <= bc[i][2]) {
					int arr[] = {i,bc[i][3]};
					bm.add(arr);
				}
			}
			
			Collections.sort(am, (o1, o2)->{
				return Integer.compare(o2[1], o1[1]);
			});
			Collections.sort(bm, (o1, o2)->{
				return Integer.compare(o2[1], o1[1]);
			});
			
//			System.out.println("a"+cnt+" "+ pointA[0]+ " "+pointA[1]);
//			System.out.println("b"+cnt+" "+ pointB[0]+ " "+pointB[1]);
			if(am.isEmpty() && bm.isEmpty()) {
//				System.out.println("아무일x");
			} //둘다 비었을때
			else if(!am.isEmpty() && bm.isEmpty()) { // b만 비었을때 
				sum += am.get(0)[1];
//				System.out.println("@"+cnt+" a삽입");
			}
			else if(am.isEmpty() && !bm.isEmpty()) { // a만 비었을때
				sum += bm.get(0)[1];
//				System.out.println("@"+cnt+" b삽입");
			}
			else if((int)am.get(0)[0] != (int)bm.get(0)[0]) {
				sum+=am.get(0)[1]+bm.get(0)[1];
//				System.out.println("@"+cnt+" 둘다추가");
			}
			// 둘다 기지국이 하나이며 같은 기지국을 쓸 때.
			else if(am.size() == 1 && bm.size() == 1 && am.get(0)[0] == bm.get(0)[0]) {
				sum += am.get(0)[1]; 
//				System.out.println("@"+cnt+" 반반");
			}
			
			else {
//				System.out.println("@"+cnt+" else");
				sum+= am.get(0)[1];
				sum+= Math.max(am.size()>1 ? am.get(1)[1]:0, bm.size()>1 ? bm.get(1)[1]:0);
			}
//			System.out.println(sum);
//			System.out.println();
			if(cnt == n) break;
			int pa = Aman[cnt];
			if(pa == 1) pointA[0]--;
			else if(pa == 2)pointA[1]++;
			else if(pa == 3)pointA[0]++;
			else if(pa == 4)pointA[1]--;
			
			int pb = Bman[cnt];
			if(pb == 1) pointB[0]--;
			else if(pb == 2)pointB[1]++;
			else if(pb == 3)pointB[0]++;
			else if(pb == 4)pointB[1]--;
			
			cnt++;
		}
	}

}
/*
// 테스트케이스 개수
// 첫 번째 테스트 케이스: M=20, A=3 // 이동거리, bc개수
// 사용자A의 이동 정보
// 사용자B의 이동 정보
// AP 1의 정보 (4, 4), C1=1, P1=100
// AP 2의 정보 (7, 10), C2=3, P2=40
// AP 3의 정보 (6, 3), C3=2, P3=70
1
20 3
2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
4 4 1 100
7 10 3 40
6 3 2 70

*/
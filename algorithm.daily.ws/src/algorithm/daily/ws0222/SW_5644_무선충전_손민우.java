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
	static int AP, BP;
	static int pointA[], pointB[]= new int[2];
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
			AP = 0;
			BP = 0;
			pointA = new int[2];
			pointB[0]=pointB[1]=100;
			
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
			System.out.println(AP+BP);
		}
	}
	
	private static void move(int cnt) {
		
		while(cnt<n) {
			List<Integer> am = new ArrayList<Integer>();
			am.add(0);
			am.add(0);
			List<Integer> bm = new ArrayList<Integer>();
			bm.add(0);
			bm.add(0);
			for(int i = 0; i<a; i++) {
				if(Math.abs(pointA[0]-bc[i][1])+ Math.abs(pointA[1]-bc[i][0]) <= bc[i][2]) {// I번 bc존에 포함되있다.
					am.add(bc[i][3]);
				}; 
				if(Math.abs(pointB[0]-bc[i][1])+ Math.abs(pointB[1]-bc[i][0]) <= bc[i][2]) {
					bm.add(bc[i][3]);
				}
			}
			
			int sumA = 0;
			int sumB = 0;
			Collections.sort(am);
			Collections.sort(bm);
			if(am.get(am.size()-1)!=bm.get(bm.size()-1)) {
				sumA = am.get(am.size()-1);
				sumB = bm.get(bm.size()-1);
			}
			
			else {
				sumA = Math.max(am.get(am.size()-1), bm.get(bm.size()-1));
				sumB = Math.max(am.get(am.size()-2), bm.get(bm.size()-2));
			}
			
			AP += sumA;
			BP += sumB;
			System.out.println(AP+" "+BP);
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
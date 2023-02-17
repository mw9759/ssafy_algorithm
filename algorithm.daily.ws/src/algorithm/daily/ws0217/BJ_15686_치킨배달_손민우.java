package algorithm.daily.ws0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15686_치킨배달_손민우 {

	static int n,m;
	static List<int[]> home = new ArrayList<>(); //집좌표를 담을 리스트
	static List<int[]> chicken = new ArrayList<>(); //치킨집 좌표를 담을 리스트
	static int[][] chickenM; // m개의 치킨집 조합.
	static int minDis = 0; // 조합의 치킨거리
	static int minDisAll = Integer.MAX_VALUE; // 최소 치킨거리
	
	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());// 배열크기
		 m = Integer.parseInt(st.nextToken()); // 최대 치킨집수
		 chickenM = new int[m][]; // 초기화
		 
		 // 집과 치킨집의 좌표를 리스트에 담는다.
		 for(int i =0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 0; j<n; j++) {
				 int a = Integer.parseInt(st.nextToken()); // 좌표의 내용물.
				 int arr[] = {i,j}; // 해당 좌표를 담아서
				 if(a == 1) home.add(arr);	// 1일때 집 리스트에 넣어주고
				 else if(a==2) chicken.add(arr); // 2일때 치킨집 리스트에 넣어준다.
			 }
		 }
		 
		 solution(0,0); //메서드 호출
		 System.out.println(minDisAll); // 전체 조합중 제일 작은 치킨거리
	}
	
	private static void solution(int cnt, int start) {
		if(cnt == m) {
			minDis = 0; // 조합의 치킨거리.
			for(int i = 0; i<home.size(); i++) {
				int min  = n+n;
				for(int j = 0; j<m; j++) {
					int a = Math.abs(home.get(i)[0]-chickenM[j][0]);
					int b = Math.abs(home.get(i)[1]-chickenM[j][1]);
					min = Math.min(a+b, min); // 집에서 제일 가까운 치킨거리 계속 초기화
				}
				minDis+=min; // 치킨거리를 위해 더해준다.
			}
			minDisAll = Math.min(minDis, minDisAll); // 최소 치킨거리 초기화
			return;
		}
		//조합재귀.
		for(int i = start; i<chicken.size(); i++) {
			chickenM[cnt] = chicken.get(i);
			solution(cnt+1, i+1);
		}
	}
}

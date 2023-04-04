package algorithm.daily.ws0403;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205_맥주마시면서걸어가기_손민우 {
	
	static int n;
	static List<Point> list;
	static int visit[];
	static Queue<Point> que;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for(int t =1; t<=tc; t++) {
			n = Integer.parseInt(br.readLine()); // 편의점 개수
			list = new ArrayList<Point>();
			
			for(int i = 0; i<n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 포인트 객체에 x좌표와 y좌표 담아서 리스트에 추가.
				list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			visit = new int[list.size()]; // 방문여부 체크할 배열.=> 리스트의 인덱스를 기준으로 방문체크.
			que = new ArrayDeque<Point>(); // point 객체를 담을 큐 초기화
			
			String answer = "sad"; // 출력 변수 초기값.
			visit[0] = 1; // 초기값 세팅. 시작좌표 방문체크.
			que.add(list.get(0)); // 큐에 시작좌표 담아서 while 문  시작.
			while(!que.isEmpty()) {
				Point p = que.poll();
				int x = p.x; // 현재 x좌표
				int y = p.y; // 현재 y좌표
				// 만약 현재 좌표가 페스티벌 장소라면 무사히 도착 한 것이다.
				if(x == list.get(list.size()-1).x && y == list.get(list.size()-1).y) {
					answer = "happy"; // 무사히 도착했음으로 출력변수 초기화 및 탈출.
					break;
				}
				
				for(int i = 0; i<list.size(); i++) {
					if(visit[i] == 1) continue; // 이미 들렀던 곳이라면 패스
					Point np = list.get(i); // 다음 좌표.
					int dis_x = Math.abs(x-np.x); // 다음좌표와의 x축 거리차이
					int dis_y = Math.abs(y-np.y); // 다음좌표와의 y축 거리차이
					
					if(dis_x+dis_y>1000) continue; // 거리가 1000보다 크면 패스(마실 맥주가 없다..)
					// 도착 가능한 거리이면 방문체크 및 큐에 좌표 담아서 반복.
					visit[i] = 1;
					que.add(new Point(np.x, np.y));
				}
			}
			System.out.println(answer); // 출력
		}
	}

}

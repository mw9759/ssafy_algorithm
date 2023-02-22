package algorithm.daily.ws0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BJ_16197_두동전_손민우 {
	
	static int n,m,count=1, flag = 0;
	static char arr[][];
	static Queue<Point> que = new LinkedList<Point>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n+2][m+2];
		
		for(int i = 1; i<=n; i++) {
			String str = br.readLine();
			for(int j = 1; j<=m; j++) {
				arr[i][j] = str.charAt(j-1);
				if(arr[i][j] == 'o') {
					que.add(new Point(i,j));
				}
			}
		}
		dropCoin();
		System.out.println(count);
//		for(char[] i : arr) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println(arr[0][0] == ' ');
//		System.out.println(que.size());
	}
	private static void dropCoin() {
		
		while(!que.isEmpty()) {
			int size =que.size()/2;
			for(int i = 0; i<size; i++) {
				int coin1X = que.peek().x;
				int coin1Y = que.poll().y;
				int coin2X = que.peek().x;
				int coin2Y = que.poll().y;
				int isdrop1 = 0;
				int isdrop2 = 0;
				
				//좌측이동@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
				char coin1Left = arr[coin1X][coin1Y-1];
				char coun2Left = arr[coin2X][coin2Y-1];
				
				//코인1 좌측
				if(coin1Left == '.') {// 코인1 왼쪽에 공간이 있다면 이동
					que.add(new Point(coin1X, coin1Y-1)); //큐에 다음좌표 담기
					arr[coin1X][coin1Y] = '.'; //코인있던자리 빈공간으로
					arr[coin1X][coin1Y-1] = 'o'; //빈공간 자리 코인으로
				}
				else if(coin1Left != '#') { //위에서 이동가능 공간이 걸러지고 만약 벽도 아니라면 낭떠러지
					arr[coin1X][coin1Y] = '.';
					isdrop1 = 1;// 코인이 떨어짐
				}que.add(new Point(coin2X, coin2Y)); //벽인경우 큐에 현재 좌표 담기
				//코인2 좌측
				if(coun2Left == '.') {// 코인2도 왼쪽에 공간이 있다면 이동
					que.add(new Point(coin2X, coin2Y-1)); //큐에 다음 좌표 담기
					arr[coin2X][coin2Y] = '.'; //코인있던자리 빈공간으로
					arr[coin2X][coin2Y-1] = 'o'; //빈공간 자리 코인으로
				}
				else if(coin1Left != '#') { //위에서 이동가능 공간이 걸러지고 만약 벽도 아니라면 낭떠러지
					arr[coin2X][coin2Y] = '.';
					isdrop2 = 1;// 코인이 떨어짐
				}que.add(new Point(coin2X, coin2Y)); //벽인경우 큐에 현재 좌표 담기
				if(isdrop1 != isdrop2) return;
				else isdrop1 = isdrop2 = 0;
				
				//상부이동@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
				char coin1Top = arr[coin1X-1][coin1Y];
				char coun2Top = arr[coin2X-1][coin2Y];
				//코인1 상부측
				if(coin1Top == '.') {// 코인1 윗쪽에 공간이 있다면 이동
					que.add(new Point(coin1X-1, coin1Y)); //큐에 다음좌표 담기
					arr[coin1X][coin1Y] = '.'; //코인있던자리 빈공간으로
					arr[coin1X-1][coin1Y] = 'o'; //빈공간 자리 코인으로
				}
				else if(coin1Top != '#') { //위에서 이동가능 공간이 걸러지고 만약 벽도 아니라면 낭떠러지
					arr[coin1X][coin1Y] = '.';
					isdrop1 = 1;// 코인이 떨어짐
				}else que.add(new Point(coin2X, coin2Y)); //벽인경우 큐에 현재 좌표 담기
				
				//코인2 상부측
				if(coun2Top == '.') {// 코인2도 왼쪽에 공간이 있다면 이동
					que.add(new Point(coin2X-1, coin2Y)); //큐에 다음 좌표 담기
					arr[coin2X][coin2Y] = '.'; //코인있던자리 빈공간으로
					arr[coin2X-1][coin2Y] = 'o'; //빈공간 자리 코인으로
				}
				else if(coun2Top != '#') { //위에서 이동가능 공간이 걸러지고 만약 벽도 아니라면 낭떠러지
					arr[coin2X][coin2Y] = '.';
					isdrop2 = 1;// 코인이 떨어짐
				} else que.add(new Point(coin2X, coin2Y)); //벽인경우 큐에 현재 좌표 담기
				if(isdrop1 != isdrop2) return;
				else isdrop1 = isdrop2 = 0;
				
				//우측이동@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
				char coin1R = arr[coin1X][coin1Y+1];
				char coun2R = arr[coin2X][coin2Y+1];
				//코인1 우측
				if(coin1R == '.') {// 코인1 왼쪽에 공간이 있다면 이동
					que.add(new Point(coin1X, coin1Y+1)); //큐에 다음좌표 담기
					arr[coin1X][coin1Y] = '.'; //코인있던자리 빈공간으로
					arr[coin1X][coin1Y+1] = 'o'; //빈공간 자리 코인으로
				}
				else if(coin1R != '#') { //위에서 이동가능 공간이 걸러지고 만약 벽도 아니라면 낭떠러지
					arr[coin1X][coin1Y] = '.';
					isdrop1 = 1;// 코인이 떨어짐
				}else que.add(new Point(coin2X, coin2Y)); //벽인경우 큐에 현재 좌표 담기
				//코인2 우측
				if(coun2R == '.') {// 코인2도 왼쪽에 공간이 있다면 이동
					que.add(new Point(coin2X, coin2Y+1)); //큐에 다음 좌표 담기
					arr[coin2X][coin2Y] = '.'; //코인있던자리 빈공간으로
					arr[coin2X][coin2Y+1] = 'o'; //빈공간 자리 코인으로
				}
				else if(coun2R != '#') { //위에서 이동가능 공간이 걸러지고 만약 벽도 아니라면 낭떠러지
					arr[coin2X][coin2Y] = '.';
					isdrop2 = 1;// 코인이 떨어짐
				} else que.add(new Point(coin2X, coin2Y)); //벽인경우 큐에 현재 좌표 담기
				
				if(isdrop1 != isdrop2) return;
				else isdrop1 = isdrop2 = 0;
				
				//하부이동@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
				char coin1B = arr[coin1X+1][coin1Y];
				char coun2B = arr[coin2X+1][coin2Y];
				//코인1 우측
				if(coin1B == '.') {// 코인1 왼쪽에 공간이 있다면 이동
					que.add(new Point(coin1X+1, coin1Y)); //큐에 다음좌표 담기
					arr[coin1X][coin1Y] = '.'; //코인있던자리 빈공간으로
					arr[coin1X+1][coin1Y] = 'o'; //빈공간 자리 코인으로
				}
				else if(coin1B != '#') { //위에서 이동가능 공간이 걸러지고 만약 벽도 아니라면 낭떠러지
					arr[coin1X][coin1Y] = '.';
					isdrop1 = 1;// 코인이 떨어짐
				}else que.add(new Point(coin2X, coin2Y)); //벽인경우 큐에 현재 좌표 담기
				//코인2 우측
				if(coun2B == '.') {// 코인2도 왼쪽에 공간이 있다면 이동
					que.add(new Point(coin2X+1, coin2Y)); //큐에 다음 좌표 담기
					arr[coin2X][coin2Y] = '.'; //코인있던자리 빈공간으로
					arr[coin2X+1][coin2Y] = 'o'; //빈공간 자리 코인으로
				}
				else if(coun2B != '#') { //위에서 이동가능 공간이 걸러지고 만약 벽도 아니라면 낭떠러지
					arr[coin2X][coin2Y] = '.';
					isdrop2 = 1;// 코인이 떨어짐
				} else que.add(new Point(coin2X, coin2Y)); //벽인경우 큐에 현재 좌표 담기
				
				if(isdrop1 != isdrop2) return;
				else isdrop1 = isdrop2 = 0;
			}
			count++;
		}
	}
}
/*
6 2
..
..
..
o#
o#
##
*/
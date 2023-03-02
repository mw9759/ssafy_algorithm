package algorithm.daily.ws0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17143_낚시왕_손민우 {

	static int n, m, c;
	static int[][] arr;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로 길이
		c = Integer.parseInt(st.nextToken()); // 물고기 마리수
		arr = new int[c][5];

		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
//		for (int j[] : arr) {
//			System.out.println(Arrays.toString(j));
//		}
//		System.out.println();
		
		for (int i = 1; i <= m; i++) {
			getFish(i);
			move();
//			for (int j[] : arr) {
//				System.out.println(Arrays.toString(j));
//			}
//			System.out.println();
		}
		System.out.println(answer);
	}

	static void getFish(int a) {
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		});
		for(int i = 0; i<c; i++) {
			if(arr[i][0] == 0) continue;
			if(arr[i][1] == a) {
				answer += arr[i][4];
				arr[i][0] = 0;
//				System.out.println(answer);
				return;
			}
		}
	}

	static void move() {
		for (int i = 0; i < c; i++) {
			if (arr[i][0] == 0)
				continue; // 이미 잡힌 물고기.

			if (arr[i][3] > 2) { // 좌우
				int speed = arr[i][2] % ((m - 1) * 2);// 나머지

				while (speed > 0) {
					if (arr[i][3] == 3) {
						if (arr[i][1] < m) {
							arr[i][1]++;
							if (arr[i][1] == m) {
								arr[i][3] = 4;
							}
							speed--;
						} else
							arr[i][3] = 4;
					}

					else if (arr[i][3] == 4) {
						if (arr[i][1] > 1) {
							arr[i][1]--;
							if (arr[i][1] == 1) {
								arr[i][3] = 3;
							}
							speed--;
						} else
							arr[i][3] = 3;
					}
				}
			} else {// 상하
				int speed = arr[i][2] % ((n - 1) * 2);// 나머지

				while (speed > 0) {

					if (arr[i][3] == 2) {// 아래방향
						if (arr[i][0] < n) {
							arr[i][0]++;
							if (arr[i][0] == n) {
								arr[i][3] = 1;
							}
							speed--;
						} else
							arr[i][3] = 1;
					}

					else if (arr[i][3] == 1) { // 윗방향
						if (arr[i][0] > 1) {
							arr[i][0]--;
							if (arr[i][0] == 1) {
								arr[i][3] = 2;
							}
							speed--;
						} else
							arr[i][3] = 2;
					}
				}
			}
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				if(o1[1] == o2[1]) return Integer.compare(o1[4], o2[4]);
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		});
//		for (int j[] : arr) {
//			System.out.println(Arrays.toString(j));
//		}
//		System.out.println("@@");
		int indx = 0, x = -1, y = -1, w = 0;
		for(int i = 0; i<c; i++) {
			if(arr[i][0] == 0) continue;
			
			if(arr[i][0] ==x && arr[i][1] == y) {
				if(arr[i][4] > w) {
					arr[indx][0] = 0;
				}
				else {
					arr[i][0] = 0;
				}
			}
			indx = i;
			x = arr[i][0]; 
			y = arr[i][1];
			w = arr[i][4];
		}
	}
}
/*
 * 0, 1, 3 0:세로축 1: 가로축 2:속도 3:방향 4:무게 4 6 8 4 1 3 3 8 1 3 5 2 9 2 4 8 4 1 4 5 0
 * 1 4 3 3 1 2 7 1 5 8 4 3 3 6 2 1 2 2 2 2 3 5
 */
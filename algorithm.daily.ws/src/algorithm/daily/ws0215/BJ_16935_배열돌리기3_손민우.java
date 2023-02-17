package algorithm.daily.ws0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16935_배열돌리기3_손민우 {
	static int n, m, c, k;
	static int arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Math.max(n, m);
		arr = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<c; i++) {
			int a = Integer.parseInt(st.nextToken());
			switch (a) {
			case 1: p1();
					break;
			case 2: p2();
				break;
			case 3: p3();
				break;
			case 4: p4();
				break;
			case 5: p5();
				break;
			case 6: p6();
				break;
			}
		}
		// 출력
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void p1() {
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n/2; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[n-1-j][i];
				arr[n-1-j][i] = temp;
			}
		}
	}
	
	private static void p2() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][m-1-j];
				arr[i][m-1-j] = temp;
			}
		}
	}
	
	private static void p3() {
		int arr2[][] = new int[m][n];
		for(int i = 0; i <m; i++) {
			for(int j = 0; j< n; j++) {
				arr2[i][j] = arr[n-1-j][i];
			}
		}
		arr=arr2;
		int ttmp = n;
		n = m;
		m = ttmp;
	}
	private static void p4() {
		for(int i = 0; i<3; i++) {
			p3();
		}
	}
	private static void p5() {
		int arr2[][] = new int[n][m];
		//좌하-> 좌상
		for(int i = 0; i<n/2; i++) {
			for(int j = 0; j<m/2;j++) {
				arr2[i][j] = arr[i+n/2][j];
			}
		}
		
		//좌상-> 우상
		for(int i = 0; i<n/2; i++) {
			for(int j = m/2; j<m;j++) {
				arr2[i][j] = arr[i][j-m/2];
			}
		}
		
		//우상-> 우하
		for(int i = n/2; i<n; i++) {
			for(int j = m/2; j<m;j++) {
				arr2[i][j] = arr[i-n/2][j];
			}
		}
		
		//우하-> 좌하
		for(int i = n/2; i<n; i++) {
			for(int j = 0; j<m/2;j++) {
				arr2[i][j] = arr[i][j+m/2];
			}
		}
		
		arr=arr2;
	}
	
	private static void p6() {
		for(int i = 0; i<3; i++) {
			p5();
		}
	}
}

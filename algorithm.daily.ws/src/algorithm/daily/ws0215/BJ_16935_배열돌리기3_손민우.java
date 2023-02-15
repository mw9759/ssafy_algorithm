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
		System.out.println(Arrays.deepToString(arr));
		//p1();
		//p2();
		p3();
		System.out.println(Arrays.deepToString(arr));
		p4();
		System.out.println(Arrays.deepToString(arr));
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
		int arr2[][] = new int[m][n];
		for(int j=m-1;j>=0;j--) {
			for(int i=0;i<n;i++)
				arr2[m-1-j][i] = arr[i][j];
		}
		arr=arr2;
		int tmp = n;
		n = m;
		n = tmp;

	}
}

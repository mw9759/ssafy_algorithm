package algorithm.daily.ws0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1991_트리순회_손민우 {
	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][2];// n개의노드, 좌측후측 두개의 자식개수
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0)-'A'; //A-A= 0=> A의 인덱스값 지칭
			int left = st.nextToken().charAt(0)-'A'; //자식이 있다면 양의 정수.
			int right = st.nextToken().charAt(0)-'A';// 자식이 없다면 '.' => '.'-'A' => -19 음수
			
			// 해당노드 위치(인덱스로 지칭)에 좌측값 우측값 입력.
			arr[root][0] = left; 
			arr[root][1] = right;
		}
		
		//전위
		pre(0);//항상 루트 노드는 A이기에 A부터 시작. (int)'A' = 0;
		sb.append("\n");
		//중위
		in(0);
		sb.append("\n");
		//후위
		post(0);
		sb.append("\n");
		
		//출략
		System.out.println(sb);
	}

	private static void pre(int root) {
		if(root == -19) return; // 자식이 없다. -19: '.'-'A'의 값.
		
		// 루트->좌->우 순으로 출력
		sb.append((char)(root+65)); //루트출력
		pre(arr[root][0]); //좌측 자식[0]이 root가 되어 루트->좌->우 순으로 출력(재귀)
		pre(arr[root][1]); //우측 자식[1]이 root가 되어 루트->좌->우 순으로 출력(재귀)
	}

	private static void in(int root) {
		if(root == -19) return; // 자식이 없다. -19: '.'-'A'의 값.
		
		// 좌->루트->우측 순으로 출력
		in(arr[root][0]); //좌측 자식[0]이 root가 되어 루트->좌->우 순으로 출력(재귀)
		sb.append((char)(root+65)); //루트출력
		in(arr[root][1]); //우측 자식[1]이 root가 되어 루트->좌->우 순으로 출력(재귀)
	}

	private static void post(int root) {
		if(root == -19) return; // 자식이 없다. -19: '.'-'A'의 값.
		
		// 좌->우측->루트 순으로 출력
		post(arr[root][0]); //좌측 자식[0]이 root가 되어 루트->좌->우 순으로 출력(재귀)
		post(arr[root][1]); //우측 자식[1]이 root가 되어 루트->좌->우 순으로 출력(재귀)
		sb.append((char)(root+65)); //루트출력
	}

	

}

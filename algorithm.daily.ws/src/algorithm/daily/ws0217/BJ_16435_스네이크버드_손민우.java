package algorithm.daily.ws0217;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_16435_스네이크버드_손민우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 과일의 갯수
		int l = sc.nextInt();	// 뱀의 길이
		int arr[] = new int[n]; // 과일이 땅에서 떨어진 위치 담을 배열
		//입력 담기
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);// 제일 낮은 과일부터 먹도록 정렬
		
		// n개의 과일을 길이가 닿는다면 먹는다.
		// 하나 먹으면 길이가 1 늘어나기에 먹을수 있는 과일이 생길수도 있다.
		for(int i = 0; i<n; i++) {
			if(l>=arr[i]) { // 길이가 닿는다면
				l += 1;	// 하나먹고 길이1증가
			}
		}
		//출력
		System.out.println(l);
	}

}

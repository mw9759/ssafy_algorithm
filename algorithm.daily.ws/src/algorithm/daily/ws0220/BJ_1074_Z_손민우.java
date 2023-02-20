package algorithm.daily.ws0220;

import java.util.Scanner;

public class BJ_1074_Z_손민우 {
	
	static int N;
	static int arr[][];
	static int count = 0; // 해당 좌표 값
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 배열크기 2의 n승 
		int r = sc.nextInt(); // 세로좌표
		int c = sc.nextInt();	// 가로좌표
		int size = (int) Math.pow(2, N); // 배열의 길이 
		solution(size, r, c); // 배열의 길이,좌표
		System.out.println(count);// 출력
	}
	
	private static void solution(int size, int r, int c) {
		if(size == 1) return; // 배열 길이가 1이되면 값을 구해 탈출
		
		if(r < size/2 && c < size/2) { // r과 c가 배열의 중간길이보다 작으면  1번자리. 시작 위치이기에 값은 추가하지 않는다.
			solution(size/2, r, c); // 배열을 다시 4등분.-> 한변을 절반으로 나누면 4등분.
		} 
		else if(r < size/2 && c>=size/2) { // 2번자리
			count += size*size/4;			// 1번자리는 모두 지나온 것이기에 1번자리의 공간만큼 더해준다.
			solution(size/2, r, c-size/2); // 배열을 다시 4등분. 더 작아진 사각형에서의 자리를 확인하기 위해서 기존 사이즈의 절반 보다 컷던 좌표는 size/2만큼 빼준다.
		}
		else if(r >=size/2 && c<size/2) { // 3번자리
			count += size*size/2;		// 1,2 번 자리는 모두 지나온 것이기에 1,2 번자리의 공간만큼 더해준다.
			solution(size/2, r-size/2, c); // 배열을 다시 4등분.
		}
		else {								// 4번자리
			count += (size*size/4)*3;		// 123번자리의 공간만큼 더해준다.
			solution(size/2, r-size/2, c-size/2);// 배열 다시 4등분 
		}
	}
}

package algorithm.daily.hw0206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class BJ_2447_별찍기_손민우 {
	static char[][] arr;
 
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
        
		solution(0, 0, N, false);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
 
	static void solution(int x, int y, int N, boolean blank) {
		// 공백칸일 경우
		if(blank) {//재귀로 시작될 x축값, y축 값, n(공백의길이), 공백유무
			for(int i = x; i < x+N; i++) {
				for(int j = y; j <y+N;j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
 
		// 더이상 쪼갤 수 없는 블록일 때
		if(N == 1) {
			arr[x][y] = '*';
			return;
		}
		
		/*
		   N=27 일 경우 한 블록의 사이즈는 9이고, 
		   N=9 일 경우 한 블록의 사이즈는 3이듯
		   해당 블록의 한 칸을 담을 변수를 의미 size
           
		   count는 별 출력 누적을 의미
		 */
 
		int size = N/3;
		int count = 0;
		for(int i = x; i < x+N; i+=size) {
			for(int j = y; j< y+N; j += size) {
				count++;
				if(count == 5) {
					solution(i,j,size,true);
				}else {
					solution(i,j,size,false);
				}
			}
			
		}

	}
}
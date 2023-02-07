package algorithm.daily.hw0206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 영섭이영농작물 {

	   public static void main(String[] args) throws IOException {
		      // TODO Auto-generated method stub
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		      int T = Integer.parseInt(br.readLine());
		      // 테스트 케이스 반복문
		      for (int t = 1; t <= T; t++) {
		         int N = Integer.parseInt(br.readLine());
		         // 입력 값을 받을 2차원 배열
		         String map[] = new String[N];
		         for(int i = 0; i < N; i++) {
		            map[i] = br.readLine();
		         }
		         int sum = 0;
		         //위
		         for (int x = 0; x < N / 2; x++) {
		            for (int y = N /2 - x; y < N / 2 + x; y++) {
		               sum += map[x].charAt(y) - '0';
		            }
		         }
		         //가운데
		         for (int x = 0; x < N; x++) {
		            sum += map[(int) N / 2].charAt(x) - '0';
		         }
		         //아래
		         int count = 0;
		         for (int x = N/2 + 1; x < N; x++) {
		            for (int y = N / 2 - count; y <= N / 2 + count; y++) {
		               sum += map[y].charAt(x) - '0';
		            }
		            count++;
		         }
		         System.out.println(sum);
		      }
		   }
		

}

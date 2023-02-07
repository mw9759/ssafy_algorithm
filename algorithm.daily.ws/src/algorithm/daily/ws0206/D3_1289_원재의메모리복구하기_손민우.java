package algorithm.daily.ws0206;

import java.io.*;

public class D3_1289_원재의메모리복구하기_손민우{

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input1289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case < tc+1; test_case++) {
			String s = br.readLine();
			
			System.out.println(solution(s,0));
		}
	}

	private static int solution(String s, int index) {
		int answer = 0;
		if(index == s.length()) return answer;
			
		
	}

}



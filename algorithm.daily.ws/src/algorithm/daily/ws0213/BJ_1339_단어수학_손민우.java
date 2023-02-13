package algorithm.daily.ws0213;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1339_단어수학_손민우 {
	static int n;
	static String arr[];
	static int len[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new String[n];
		len = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = br.readLine();
			len[i] = arr[i].length();
		}
		
	}

}

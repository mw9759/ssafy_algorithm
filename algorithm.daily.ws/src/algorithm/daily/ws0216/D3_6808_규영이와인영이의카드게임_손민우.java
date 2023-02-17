package algorithm.daily.ws0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D3_6808_규영이와인영이의카드게임_손민우 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=1; tc++) {
			int arr[] = new int[9];
			int arr2[] = new int[9];
			int check[] = new int[19];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<9; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				check[arr[i]] = 1;
			}
			for(int i = 1, j = 0; i<19; i++) {
				if(check[i]==0) {
					arr2[j++] = i;
				}
			}
			
			
		}
	}
	
}

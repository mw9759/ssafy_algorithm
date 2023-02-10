package algorithm.daily.hw0210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_10867_중복빼고정렬하기_손민우 {
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		for(int i : list) System.out.print(i + " ");
	}

}

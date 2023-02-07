package algorithm.daily.hw0206;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_25501_재귀의귀재_손민우 {
	private static int count = 0;
	public static int recursion(String s, int l, int r){
		count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	String s = new String();
    	for(int i = 0; i < t; i++) {
    		s = br.readLine();
    		System.out.println(isPalindrome(s)+" "+count);
    		count = 0;
    	}
    }
}

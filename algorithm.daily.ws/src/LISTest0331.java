import java.util.Scanner;

public class LISTest0331 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0; 
		
		for(int i = 0; i<N; i++) {
			LIS[i] = 1; //자신만 긑에 세웠을 경우 1의 길이.
			for(int j = 0; j<i; j++) {
				if(arr[j]<arr[i] && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			if(max<LIS[i]) max = LIS[i];
		}
		System.out.println(max);
	}
}
/**
10
8 2 4 3 6 11 7 10 14 5
=>6
*/
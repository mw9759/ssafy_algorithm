package algorithm.daily.ws;

public class 문제1_배열재귀_손민우 {

	static int arr[] = {10, 20, 30}; //배열선언
	
	private static void printArray1(int a) {
		
		System.out.println(arr[a]); //배열출력
		if(a<arr.length-1) printArray1(++a);//재귀호출
	}
	
	public static void main(String[] args) {
		printArray1(0);//메서드호출
	}

}

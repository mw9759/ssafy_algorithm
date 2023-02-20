package algorithm.daily.ws0220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 이진 검색을 이용해서 아래의 값이 저장된 위치(인덱스)를 출력해 보세요.
 int[] values = {3, 11, 15, 20, 21, 29, 45, 59, 65, 72};
 * 만약, 해당 요소가 없는 경우에는 -1 반환
(1) 반복문 사용: for 

65
3
2
46
72
 */
public class 이진검색 {

	static int values[] = {3, 11, 15, 20, 21, 29, 45, 59, 65, 72};
	public static void main(String[] args) {
		System.out.println(search(65));
		System.out.println(search(3));
		System.out.println(search(2));
		System.out.println(search(46));
		System.out.println(search(72));
		
		System.out.println("====재귀====");
		System.out.println(binarySearch(65, 0, values.length -1));
		System.out.println(binarySearch(3, 0, values.length -1));
		System.out.println(binarySearch(2, 0, values.length -1));
		System.out.println(binarySearch(46, 0, values.length -1));
		System.out.println(binarySearch(72, 0, values.length -1));
		
		
		//binarySearch(byte[] a, byte key);
		System.out.println("===api 이진탐색===");
		System.out.println(Arrays.binarySearch(values, 65));
		System.out.println(Arrays.binarySearch(values, 3));
		System.out.println(Arrays.binarySearch(values, 2));
		System.out.println(Arrays.binarySearch(values, 46));
		System.out.println(Arrays.binarySearch(values, 72));
	}
	
	private static int search(int key) {
		int start = 0;
		int end = values.length -1;
		int mid = 0;
		
		while(start <= end) {
			mid = (start+end)/2;
			if(values[mid] == key) return mid;
			else if(values[mid] < key) start = mid + 1;
			else end = mid-1;
		}
		return -1;
	}
	
	//재귀
	public static int binarySearch(int key, int start, int end) {
		if(start <= end) {
			int mid = (start+end)/2;
			if(values[mid] == key) return mid;
			else if(values[mid] < key) return binarySearch(key, mid+1, end);
			else return binarySearch(key, start, mid-1);
		}
		return -1;
	}
}

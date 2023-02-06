package algorithm.daily.ws0206;

public class 문제3_하노이탑_손민우 {

	public static void main(String[] args) {
		int n = 3; // 원판개수 및 원판번호
		char startPoint = 'A';
		char otherPoint = 'B';
		char endPoint = 'C';
		hanoi(n, startPoint, endPoint, otherPoint);
	}
	
	private static void hanoi(int n, char startPoint, char endPoint, char otherPoint) {
		if(n == 1) {
			System.out.println(startPoint+"에서 원판"+n+"을 "+endPoint+"로 이동.");
		} else {
			hanoi(n-1, startPoint, otherPoint, endPoint);
			System.out.println(startPoint+"에서 원판"+n+"을 "+endPoint+"로 이동.");
			hanoi(n-1, otherPoint, endPoint, startPoint);
		}
	}
}

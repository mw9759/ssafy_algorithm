package algorithm.daily.ws0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_11286_절대값힙_손민우 {
	// 절대값 담을 큐: 낮은 수부터 우선 출력 -> 정수형 기본 우선순위: 낮은수
	static PriorityQueue<Integer> abs = new PriorityQueue<>(); 
	//음수담을 큐. 높은값 우선 출력 -> 리버스메서드 사용시 우선순위: 큰수
	static PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder()); 
	static StringBuilder sb = new StringBuilder();
	
	// 내풀이
	public static void main1(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			boolean isA = a<0 ? true:false;
			if(a == 0) { //0이 들어오면
				if(abs.isEmpty()) sb.append(0).append("\n"); // 만약 절대값 큐가 비었다면 그냥 0 출력.
				else {// 절대값 큐에 원소가 있다면
					//만약 음수큐가 비어있지 않고, 절대값큐 상단과 음수값큐 상단이 같다면
					if(!minus.isEmpty() && abs.peek() == Math.abs(minus.peek())) { 
						abs.remove(); // 출력은 음수로 해야하니 abs큐 상단으 그냥 버림.
						sb.append(minus.poll()).append("\n"); // 음수 큐 상단 출력.
					}
					else {
						sb.append(abs.poll()).append("\n"); // 음수값이 이니였기에 그냥 abs상단 출력.
					}
				}
			}
			// 0이 아닌 수->  큐에 삽입
			else {
				abs.add(Math.abs(a)); // 모든 수의 절대값은 abs에도 삽입 
				if(isA) minus.add(a);	// 만약 음수였다면  minus큐에도 삽입
			}
		}
		System.out.println(sb); // 출력.
	}
	
	//최적
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 큐 정렬 재정의
		PriorityQueue<Integer> abs = new PriorityQueue<>((i1, i2)->{
			int x = i1>=0 ? i1:-i1; //음수면 양수
			int y = i2>=0 ? i2:-i2; //음수면 양수
			
			if(x==y) { //절대값이  같을때 
				return Integer.compare(i1, i2); // 음수가 앞으로
			}
			// 절대값이 작은 수가 앞으로
			return Integer.compare(x, y);
		}); 
		
		for(int i = 0; i<n; i++) {//n번만큼
			//입력
			int a = Integer.parseInt(br.readLine());
			
			if(a != 0) { // 0이 아닌 수가 오면 큐에 입력
				abs.add(a);
			}
			// 큐가 비어있다면 0 출력
			else if(abs.isEmpty()) {
				sb.append(0).append("\n");
			}
			else {
				sb.append(abs.poll()).append("\n"); //큐의 상단값 출력
			}
		}
		System.out.println(sb); // 출력.
	}

}

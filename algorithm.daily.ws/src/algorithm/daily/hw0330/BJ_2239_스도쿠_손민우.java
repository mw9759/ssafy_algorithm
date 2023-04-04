package algorithm.daily.hw0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//수도쿠에서 빈 공간의 좌표를 담아놓을 객체
class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BJ_2239_스도쿠_손민우 {
	
	static int sudoku[][]; // 입력값을 담을 수도쿠 배열
	static List<Point> point = new ArrayList<Point>(); // 빈 스도쿠의 좌표값을 가진 객체를 담을 리스트.
	static boolean flag = false; // 스도쿠가 완성되었음을 알릴 신호.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[10][10]; // 스도쿠 배열 초기화.
		// 입력값 처리.=> 데이터가 공백없이 다 붙어서 왔기에 스트링으로 받아 toChar로 처리.
		for(int i = 1; i<=9; i++) {
			String str = br.readLine();
			for(int j = 1; j<=9; j++) {
				int num = str.charAt(j-1)-'0'; // -'0'을 해줘서 일치하는 정수형으로 변환.
				sudoku[i][j] = num; // 스도쿠 배열에 입력값 넣기.
				if(num == 0) { // 만약 값이 0이라면 채워줘야하기에 
					point.add(new Point(i, j));	// 따로 point 리스트에 Point객체로 좌표를 넣어줘서 삽입.
				}
			}
		}
		sudoku(0); // 소도쿠 채울 메서드 호출.
		
		// 완성된 수도쿠 출력.
		for(int i = 1; i<=9; i++) {
			for(int j = 1; j<=9; j++) {
				System.out.print(sudoku[i][j]);
			}System.out.println();
		}
		
	}
	
	private static void sudoku(int cnt) {
		if(cnt == point.size()) { // 스도쿠가 완성되었다면. 
			flag = true; // 스도쿠 완성 신호 초기화
			return; 	
		}
		
		int x = point.get(cnt).x; // cnt인덱스의 x값
		int y = point.get(cnt).y; // cnt인덱스의 y값.
		for(int i = 1; i<=9; i++) { // 1~9까지의 수 반복: 스도쿠에 들어갈 숫자.
			if(checkX(x,i) && checkY(y,i) && check33((x-1)/3,(y-1)/3,i)) { // 가로, 세로, 33구역에서 스도쿠 규칙을 만족한 i라면
				sudoku[x][y] = i; // 스도쿠 해당값이 0이였던 부분에 i값 넣기.
				sudoku(cnt+1); 	// 다음 빈 공간 채우러 cnt+1해서 재귀.
				if(flag) return; // 재귀를 다 돌고 flag가 true가 되었다면 리턴.
				sudoku[x][y] = 0; // 위의 if문을 돌지 않았다면 스도쿠가 이상이 있던것임으로 i값 다시 0 으로 초기화.
			}
		}
	}

	// x축 검증
	private static boolean checkX(int x, int num) {
		for(int i = 1; i<=9; i++) {
			if(sudoku[x][i] == num) return false; // x열에 num이 있다면 못넣기에 false리턴
		}
		return true; // num을 쓸 수 있기에 true리턴
	}
	//y축 검증
	private static boolean checkY(int y, int num) {
		for(int i = 1; i<=9; i++) {
			if(sudoku[i][y] == num) return false; // y행에 num이 있다면 못넣기에 false리턴
		}
		return true;// num을 쓸 수 있기에 true리턴
	}
	// 3*3구역 검증.
	private static boolean check33(int x, int y, int num) {
		// x y 좌표 재정의
		if(x == 0) x = 1; 
		else if(x == 1) x = 4; 
		else if(x == 2) x = 7; 
		if(y == 0) y = 1;
		else if(y == 1) y = 4;
		else if(y == 2) y = 7;
		
		//33 구역 검증.
		for(int i = x; i<x+3; i++) {
			for(int j = y; j<y+3; j++){
				if(sudoku[i][j]==num) return false; // num이 발견되면 false리턴
			}
		}
		return true; 
	}

}

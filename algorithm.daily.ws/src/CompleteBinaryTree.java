import java.util.ArrayDeque;
import java.util.Queue;

// 완전이진트리 : 1차원 배열 구현
public class CompleteBinaryTree<T> {

	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new Object[size+1];
	}
	
	private boolean isFull() {
		return lastIndex == SIZE;
	}
	public void add(T e) {
		if(isFull()) return;

		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		//큐에는 탐색노드의 번호 저장.
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1); // 루트노드부터 
		// 큐에 대기하고 있는 순서대로 노드 처리
		int current =0;
		while(!queue.isEmpty()) {
			current = queue.poll(); //  현재 탐색해야하는 도드 번호
			System.out.println(nodes[current]);
			
			//현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게 하기
			// 완전 이진 트리: 자식이 최대 2개
			
			//외쪽자식
			if(current*2 <= lastIndex) queue.offer(current*2);
			//오른쪽자식
			if(current*2 <= lastIndex) queue.offer(current*2+1);
		}
		
	}
}

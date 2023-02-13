
public class LinkedLisyStack<E> implements Istack<E> {

	
	public Node<E> top;
	@Override
	public void push(E e) {
		//top으로 삽입
		top = new Node<E>(e, top);		
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("공백스택이어서 불가능합니다.");
		}
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("공백스택이어서 불가능합니다.");
			return null;
		}		
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == null;
	}

	@Override
	public int size() { // top부터 노드 따라가서 마지막 노드까지의 수
		// TODO Auto-generated method stub
		int res = 0;
		for(Node<E> temp = top; temp != null; temp = temp.link) {
			res++;
		}
		return res;
	}

}

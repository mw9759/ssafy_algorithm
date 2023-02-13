
public class StackTest {

	public static void main(String[] args) {
		
		//Istack<String> stack = new LinkedLisyStack<String>();
		LinkedLisyStack<String> stack = new LinkedLisyStack<String>();
		
		stack.push("저러언");
		stack.push("아이고");
		stack.push("배고파");
		stack.push("꼬르륵");
		stack.push("오늘은");
		stack.push("뭐묵징");
		
		System.out.println(stack.size()+ "//"+stack.isEmpty());
		System.out.println(stack.top.toString());
		System.out.println(stack.peek());
		System.out.println(stack.size()+ "//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size()+ "//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size()+ "//"+stack.isEmpty());
		System.out.println(stack.pop());
		
	}

}

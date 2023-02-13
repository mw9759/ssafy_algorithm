
public interface Istack<T> {
	void push(T t);
	T pop();
	T peek();
	boolean isEmpty();
	int size();
}

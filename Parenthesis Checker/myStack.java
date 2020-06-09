import java.util.Iterator; 
/*Data Structure Lecture, Assignment 1 : Parenthesis Checker
 * There is a stack class. The functions I need in the stack are included in this class 
 * when checking parentheses. We keep items in an array and we need to keep 
 * the size of the stack to check against the stack is full or not. 
 * When adding items with "push" to the stack is full, 
 * the "resize" function will automatically increase the space once it is full. 
 * "pop" will remove the item, but first check the fullness of the stack. 
 * "peek" controls the beginning of the stack.
 * It was given by instructor
 * 
 */
import java.util.NoSuchElementException; 
public class myStack<Item> implements Iterable<Item> {  
	private Item[] a; // array of items  
	private int n; // number of elements on stack 

	public myStack() {   
		a = (Item[]) new Object[2];   
		n = 0;  } 
	public boolean isEmpty() { 
		return n == 0; 
	}  
	public int size() { 
		return n; 
	} 
	private void resize(int capacity) {   
		assert capacity >= n;  
		Item[] temp = (Item[]) new Object[capacity];   
		for (int i = 0; i < n; i++) {    
			temp[i] = a[i];   
		}   
		a = temp;  
	}    
	public void push(Item item) {   
		if (n == a.length) {    
			resize(2 * a.length); // double size of array if necessary    
			System.out.print("\n\n    << stack doubled >>    \n\n");   
		}   
		a[n++] = item; // add item  
	} 

	public Item pop() {   
		if (isEmpty())    throw new NoSuchElementException("Stack underflow");   
		Item item = a[n - 1];   
		a[n - 1] = null; // to avoid loitering   
		n--;   // shrink size of array if necessary   
		if (n > 0 && n == a.length / 4)    
			resize(a.length / 2);   
		return item;  } 
	public Item peek() {   
		if (isEmpty())    throw new NoSuchElementException("Stack underflow");   
		return a[n - 1];  } 
	public Iterator<Item> iterator() {   
		return new ReverseArrayIterator();  } 
	private class ReverseArrayIterator implements Iterator<Item> {   
		private int i;   
		public ReverseArrayIterator() { 
			i = n - 1; }   
		public boolean hasNext() { 
			return i >= 0; }   
		public void remove() { throw new UnsupportedOperationException(); }   
		public Item next() {    
			if (!hasNext())     throw new NoSuchElementException();    
			return a[i--];   
		}  
	}
}

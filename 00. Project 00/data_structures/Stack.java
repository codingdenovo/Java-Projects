/** 
 *  Program #2
 *  A generic stack (Stack) class built from the linear list (LinearList)
 *  class via composition.
 *  CS310-1
 *  12 March 2019
 *  @author Mariano Hernandez cssc1479
 */

package data_structures;

import java.util.Iterator;

public class Stack<E extends Comparable<E>> implements Iterable<E> {
	private LinearListADT<E> stk;
	
	 public Stack() {
	    	stk = new LinearList<E>();
	    }
	
	/* inserts the object obj into the stack
	 */
	public void push(E obj) {
		stk.addLast(obj);
	}
	
	/* pops and returns the element on the top of the stack
	 */
	public E pop( ) {
		return stk.removeLast();
	}
	
	/* returns the number of elements currently in the stack
	 */
	public int size() {
		return stk.size();
	}
	                          
	/* return true if the stack is empty, otherwise false
	 */
	public boolean isEmpty() {
		return stk.isEmpty();
	}
	
	/* returns but does not remove the element on the top of the stack
	 */
	public E peek() {
		return stk.peekLast();
	}
	
	/* returns true if the object obj is in the stack,
	 * otherwise false
	 */
	public boolean contains(E obj) {
		return stk.contains(obj);
	}
	
	/* returns the stack to an empty state
	 */
	public void makeEmpty() {
		stk.clear();
	}
	
	/* removes the Object obj if it is in the stack and
	 * returns true, otherwise returns false.
	 */
	public boolean remove(E obj) {
		if(stk.contains(obj)) {
			stk.remove(obj);
			return true;
		}
		return false;
	}
	
	/* returns a iterator of the elements in the stack. The elements * must be in the same sequence as pop() would return them.
	 */
	public Iterator<E> iterator() {
		return stk.iterator();
	}

}

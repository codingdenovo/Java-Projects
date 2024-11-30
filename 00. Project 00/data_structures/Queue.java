/** 
 *  Program #2
 *  A generic queue (Queue) class built from the linear list (LinearList)
 *  class via composition.
 *  CS310-1
 *  12 March 2019
 *  @author Mariano Hernandez cssc1479
 */

package data_structures;

import java.util.Iterator;

public class Queue<E extends Comparable<E>> implements Iterable<E> {
    private LinearListADT<E> q;
    
    public Queue() {
    	q = new LinearList<E>();
    }
	
	/* inserts the object obj into the queue
	 */
	public void enqueue(E obj) {
		q.addLast(obj);
	}
	
	/* removes and returns the object at the front of the queue
	 */
	public E dequeue() {
		return q.removeFirst();
	}
	
	/* returns the number of objects currently in the queue 
	 */
	public int size() {
		return q.size();
	}
	
	/* returns true if the queue is empty, otherwise false
	 */
	public boolean isEmpty() {
		return q.isEmpty();
	}
	
	/* returns but does not remove the object at the front of the queue
	 */
	public E peek() {
		return q.peekFirst();
	}
	
	/* returns true if the Object obj is in the queue
	 */
	public boolean contains(E obj) {
		return q.contains(obj);
	}
	
	/* returns the queue to an empty state
	 */
	public void makeEmpty() {
		q.clear();
	}
	
	/* removes the Object obj if it is in the queue and
	 * returns true, otherwise returns false.
	 */
	public boolean remove(E obj) {
		if(q.contains(obj)) {
			q.remove(obj);
			return true;
		}
		return false;
	}
	
	/* returns an iterator of the elements in the queue. The elements
	 * must be in the same sequence as dequeue would return them.
	 */
	public Iterator<E> iterator() {
		return q.iterator();
	}
}

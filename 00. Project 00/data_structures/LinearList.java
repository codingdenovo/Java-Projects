/** 
 *  Program #2
 *  A generic linear list (LinearList) class that implements the linear list
 *  abstract data type (LinearListADT) interface using doubly linked list.
 *  CS310-1
 *  12 March 2019
 *  @author Mariano Hernandez cssc1479
 */

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

class Node<E> {

	public E data;
	public Node<E> next;
	public Node<E> previous;

	public Node() {
		this(null, null, null);
	}

	public Node(E a) {
		this(a, null, null);
	}

	public Node(E a, Node<E> b, Node<E> c) {
		this.data = a;
		this.next = b;
		this.previous = c;
	}
}

public class LinearList<E extends Comparable<E>> implements LinearListADT<E> {
	private Node<E> firstNode, lastNode;
	private int length, modCounter;

	public LinearList() {
		this.firstNode = this.lastNode = null;
		this.length = 0;
		this.modCounter = 0;
	}

	public boolean addFirst(E obj) {
		Node<E> newFirst = new Node<E>(obj);

		if(this.isEmpty())
			this.firstNode = this.lastNode = newFirst;
		else {
			newFirst.next = this.firstNode;
			this.firstNode.previous = newFirst;
			this.firstNode = newFirst;
		}
		this.length++;
		this.modCounter++;
		return true;
	}

	public boolean addLast(E obj) {
		Node<E> newLast = new Node<E>(obj);

		if(this.isEmpty())
			this.firstNode = this.lastNode = newLast;
		else {
			this.lastNode.next = newLast;
			newLast.previous = this.lastNode;
			this.lastNode = newLast;
		}
		this.length++;
		this.modCounter++;
		return true;
	}

	public E removeFirst() {
		if(this.isEmpty())
			return null;

		E dataToRemove;
		dataToRemove = this.firstNode.data;
		this.firstNode = this.firstNode.next;
		
		if(this.length > 1)
			this.firstNode.previous = null;
		if(this.length == 1)
			this.lastNode = null;
		
		this.length--;
		this.modCounter++;
		return dataToRemove;
	}

	public E removeLast() {
		if(this.isEmpty())
			return null;
		if(this.length == 1)
			return this.removeFirst();
		
		E dataToRemove;
		Node<E> nodeBefore = this.lastNode.previous;
		dataToRemove = this.lastNode.data;
		this.lastNode = nodeBefore;
		this.lastNode.next = null;
		this.length--;
		this.modCounter++;
		return dataToRemove;
	}

	public E remove(E obj) {
		if(this.isEmpty())
			return null;

		E dataToRemove;
		int position = this.nodePosition(obj);

		if(position == 1)
			return this.removeFirst();
		if(position == this.length)
			return this.removeLast();

		Node<E> nodeBefore = this.getNodeAt(position - 1);
		Node<E> nodeToRemove = nodeBefore.next;
		Node<E> nodeAfter = nodeToRemove.next;
		dataToRemove = nodeToRemove.data;
		nodeBefore.next = nodeAfter;
		nodeAfter.previous = nodeBefore;
		this.length--;
		this.modCounter++;
		return dataToRemove;
	}

	public E peekFirst() {
		if(this.isEmpty())
			return null;
		return this.firstNode.data;
	}

	public E peekLast() {
		if(this.isEmpty())
			return null;
		return this.lastNode.data;
	}

	/* Returns the current integer position of a Node with respect to its
	 * object.
	 */
	private int nodePosition(E obj) {
		Node<E> currentNode = this.firstNode;
		int counter = 1;
		while(currentNode != null) {
			if(obj.equals(currentNode.data))
				return counter;
			currentNode = currentNode.next;
			counter++;
		}
		throw new RuntimeException("Not found");
	}

	/* Returns a Node given its position in the list.
	 */
	private Node<E> getNodeAt(int position) {
		if(position < 1 || position > this.length)
			return null;

		Node<E> currentNode = this.firstNode;
		for(int i = 1; i < position; i++) 
			currentNode = currentNode.next;
		return currentNode;
	}

	public boolean contains(E obj) {
		Node<E> currentNode = this.firstNode;
		
		while(currentNode != null) {
			if(obj.equals(currentNode.data))
				return true;
			currentNode = currentNode.next;
		}
		return false;
	}

	public E find(E obj) {
		Node<E> currentNode = this.firstNode;
		
		while(currentNode != null) {
			if(obj.equals(currentNode.data))
				return currentNode.data;
			currentNode = currentNode.next;
		}
		throw new RuntimeException("Not found");
	}

	public void clear() {
		this.firstNode = null;
		this.lastNode = null;
		this.length = 0;
		this.modCounter++;
	}

	public boolean isEmpty() {
		return this.length == 0;
	}

	public boolean isFull() {
		return false;
	}

	public int size() {
		return this.length;
	}

	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

	class IteratorHelper implements Iterator<E> {
		Node<E> iteratorIdx;
		private int check;

		public IteratorHelper() {
			iteratorIdx = firstNode;
			check = modCounter;
		}

		public boolean hasNext() {
			if(check != modCounter)
				throw new ConcurrentModificationException();
			return iteratorIdx != null;
		}

		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E tmp = iteratorIdx.data;
			iteratorIdx = iteratorIdx.next;
			return tmp;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}

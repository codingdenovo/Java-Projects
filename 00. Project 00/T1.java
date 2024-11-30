import java.util.Iterator;
import data_structures.*;

public class T1 {
    public static void main(String [] args) { 
    LinearListADT<Integer> list1 = new LinearList<Integer>();
    if(list1.peekFirst()!= null) System.out.println("Error in peekFirst");
    if(list1.peekLast()!= null) System.out.println("Error in peekLast");
    
     for(int i = 1; i<=10; i++) {
    	 list1.addFirst(i);
    	 System.out.print(i+ " ");
     }
   
     System.out.println("Current size is: "+ list1.size()); 
     
     list1.remove(3); 
     
     for(int i: list1)
    	 System.out.print(i+ " ");
     if(list1.contains(3)) System.out.println("Error in remove");
     
     System.out.println("Your peekFirst is: " + list1.peekFirst());
     System.out.println("Your peekLast is: " + list1.peekLast());
     System.out.println("Current size is: "+ list1.size()); 
     
     System.out.println("Your element is " + list1.find(1));
     
     //if(list1.peekFirst()!= null) System.out.println("Error in peekFirst");
     //if(list1.peekLast()!= null) System.out.println("Error in peekLast");
     
     System.out.println();
     System.out.println("Now Testing Strings");
     LinearListADT<String> list2 = new LinearList<String>();
     
     list2.addFirst("Bob");
     list2.addLast("Gaby");
     list2.addFirst("Jon");
     System.out.println("Your peekLast is: " + list2.peekLast());
     list2.remove("Bob");
     System.out.println("Your peekFirst is: " + list2.peekFirst());
     System.out.println("Your peekLast is: " + list2.peekLast());
     System.out.println("Current size is of list2: "+ list2.size()); 
     
     //stk
     System.out.println();
     System.out.println("Now Testing Strings in a Stack");
     Stack<String> list3 = new Stack<String>();
     
     list3.push("Bob");
     list3.push("Gaby");
     list3.push("Jon");
     System.out.println("Your last element is " + list3.peek());
     System.out.println("Current size is of list3: "+ list3.size()); 
     
     //q
     System.out.println();
     System.out.println("Now Testing Strings in a Queue");
     Queue<String> list4 = new Queue<String>();
     
     list4.enqueue("Bob");
     list4.enqueue("Gaby");
     list4.enqueue("Jon");
     System.out.println("Your last element is " + list4.peek());
     System.out.println("Current size is of list4: "+ list4.size()); 
    }
}

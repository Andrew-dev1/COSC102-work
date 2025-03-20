import java.util.*;

//An implementation of a Queue data structure to be used in
//the Lab 09 assignment
public class LabQueue<E>{
     
     //A LabQueue stores its elements in a LinkedList
     private LinkedList<E> elements;
     
     //Initializes an empty Queue
     public LabQueue(){
        this(null);
     }
     
     
     //Initializes a Queue containing the argument elements
     //Elements are enqueued in order, starting at index 0
     public LabQueue(E[] initElements){
        this.elements = new LinkedList<E>();
        if (initElements != null){
           for (E ele : initElements)
              this.elements.add(ele);
        }        
     }

     //Adds the argument element to back of the LabQueue
     public void enqueue(E element){
        this.elements.add(element);
     }
     
     //Removes and returns the frontmost element
     public E dequeue(){
        if (this.elements.size() == 0)
           throw new IllegalStateException("You can't dequeue() from an empty LabQueue!");
        return this.elements.remove(0);               
     }     
     
     //Returns but does NOT remove the frontmost element of the LabQueue
     public E peek(){
        if (this.elements.size() == 0)
           throw new IllegalStateException("You can't peek() from an empty LabQueue!");
        return this.elements.get(0);               
     }     
     
     //Removes and returns the frontmost element, or null if the LabQueue is empty
     public E poll(){
        if (this.elements.size() == 0)
           return null;
        return this.elements.remove(0);               
     }     
     
     //Returns the number of elements in this LabQueue
     public int size(){
        return this.elements.size();
     }
     
     
     //Returns a String of the elements in the LabQueue (listed front-to-back)
     public String toString(){
        return this.elements.toString();
     }
     
     
}
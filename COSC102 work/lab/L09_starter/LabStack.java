import java.util.*;

//An implementation of a Stack data structure to be used in
//the Lab 09 assignment
public class LabStack<E>{
     
     //using the Java implementation of Stack here...
     private Stack<E> elements;
     
     
     //Initializes an empty Stack
     public LabStack(){
        this(null);
     }
          
     //Initializes a Stack containing the argument elements
     //Elements are pushed in order, starting at index 0     
     public LabStack(E[] initElements){
        this.elements = new Stack<E>();
        if (initElements != null){
           for (E ele : initElements)
              this.elements.push(ele);
        }        
     }

     
     
     
     
     //Adds the argument element to the top of the LabStack
     public void push(E element){
        this.elements.push(element);
     }
     
     //Removes and returns the topmost element
     public E pop(){
        if (this.elements.size() == 0)
           throw new IllegalStateException("You can't pop() from an empty LabStack!");
        return this.elements.pop();               
     }
     
     //Returns but does NOT remove the topmost element
     public E peek(){
        if (this.elements.size() == 0)
           throw new IllegalStateException("You can't peek() on an empty LabStack!");
        return this.elements.peek();               
     }     
     
     //Returns a boolean indicating if the stack is empty (true) or not (false)
     public boolean isEmpty(){
        return this.elements.size() == 0;
     }
     

     //Returns a String of the elements in the LabStack (listed bottom-to-top)
     public String toString(){
        return this.elements.toString();
     }     
     
     
}
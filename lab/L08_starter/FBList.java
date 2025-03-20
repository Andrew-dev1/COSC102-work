public class FBList<E> {

    private int size;
    private Node<E> front, back;


    //returns the element that the back reference points to
    public E getBackElement(){
       if (back == null)
          return null;
       return back.data;
    }
    
    
    //Returns the number of items in the list
    public int size(){
        return size;
    }


    public E getValue(int idx){
        if (idx >= size || idx < 0)
            throw new IndexOutOfBoundsException("Index out of range! Requested idx: " + idx + ", size = " + size);
        return getNode(idx).data;
    }

    //only intended to be called from inside the FBList class
    private Node<E> getNode(int idx){
        Node<E> current = front;
        for (int i = 0; i < idx; i++)
            current = current.next;
        return current;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        if (size == 0)
            return "[]";
        Node<E> current = front;
        for (int i = 0; i < size - 1; i++){
            sb.append(current.data + " ==> ");
            current = current.next;
        }
        sb.append(current.data + "]");
        return sb.toString();
    }


    
    
    private static class Node<E>{
       
       private E data;                 /** The data value. */
       private Node<E> next = null;    /** The link to the next Node in the list*/
       
       //Our Nodes are SINGLY-LINKED, meaning they maintain only a next 
       //reference, NOT a previous.  You MAY NOT add a previous reference.
       
       public Node(E data, Node<E> next) {
          this.data = data;
          this.next = next;
       }
       
       public Node(E data) {
          this(data, null);
       }               
    }    

    
    
            
    
    
   
    //***************************************************************
    //**                                                           **
    //**     YOU DON"T NEED TO MODIFY ANYTHING ABOVE THIS LINE     **
    //**                     YOUR TASKS ARE BELOW                  **
    //**                                                           **
    //***************************************************************

    
            
    
    
    
    //Appends argument element to the end of the list
    public void add(E toAdd){
        Node<E> node = new Node<E>(toAdd);
        if(size == 0)
            front = node;
        else{
            back.next = node;
        }
        back = node;
        size += 1;
    }    
    
    

    //Inserts the argument element at the specified index 
    //can also be used to append to the end of the list
    //If an invalid index is provided, throws an IndexOutOfBoundsException
    public void add(int index, E toAdd){
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index out of range! Requested idx: " + index + ", size = " + size);
        if(index == size){
            add(toAdd);
            return;
        }
        if(index == 0){
            Node<E> node = new Node<E>(toAdd, front);
            front = node;
        }
        else{
            Node<E> current = front;
            for (int i = 0; i < index-1; i++){
                current = current.next;
            }
            Node<E> next = current.next;
            Node<E> node = new Node<E>(toAdd, next);
            current.next = node;
        }
        
        size += 1;
    }

    
    
    
    
    

    //Removes all elements from other and adds them to the end of the 
    //referenced list.  For example, if:
    //list1 = {A->B->C->D}   and   list2 = {X->Y->Z}
    //after list1.concatList(list2);
    //list1 = {A->B->C->D->X->Y->Z}   and   list2 = { }
    public void concatList(FBList<E> other){
        if(other.size == 0)
            return;
            
        if(size == 0){
            front = other.front;
            back = other.back;
        }
        else{
            back.next = other.front;
            back = other.back;
        }
        size += other.size;
        other.front = null;
        other.back = null;
        other.size = 0;
        
       
    }
    
    

    

}


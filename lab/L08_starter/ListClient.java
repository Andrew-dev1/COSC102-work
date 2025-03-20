import java.util.*;

public class ListClient{
    
    
    
    private static void testAdd(){
        System.out.println("*****    ADD TESTS    *****");
        
        //Test 1.1
        FBList<String> test1 = new FBList<String>();
        test1.add("cat");
        test1.add("dog");
        test1.add("bird");
        System.out.println("Test1.1 (append to end):\n\t" + test1);
        
        
        //Test 1.2
        FBList<String> test2 = new FBList<String>();
        test2.add("cat");
        test2.add("dog");
        test2.add(1, "frog");
        System.out.println("Test1.2 (insert at idx 1):\n\t" + test2);        
        
        
        //Add more of your own!
        test2.add(0, "penguin");
        System.out.println("Test1.2 (insert at idx 0):\n\t" + test2);
        test2.add(4, "lame");
        System.out.println("Test1.2 (insert at idx 4):\n\t" + test2);  

    }


    
    private static void testConcatList(){
        System.out.println("\n*****    CONCAT LIST TESTS    *****");
        
        FBList<String> test1 = new FBList<String>();
        test1.add("A");
        test1.add("B");        
        
        FBList<String> test2 = new FBList<String>();
        test2.add("C");
        test2.add("D");
        test2.add("E");
        
        System.out.println("Concatenate Before: list1: " + test1 + ", list2: " + test2);
        test1.concatList(test2);
        System.out.println("Concatenate After:  list1: " + test1 + ", list2: " + test2);
        
        System.out.println("\ntesting for null in second list");
        System.out.println("Concatenate Before: list1: " + test1 + ", list2: " + test2);
        test1.concatList(test2);
        System.out.println("Concatenate After:  list1: " + test1 + ", list2: " + test2);
        
        System.out.println("\ntesting for null in first list");
        System.out.println("Concatenate Before: list1: " + test1 + ", list2: " + test2);
        test2.concatList(test1);
        System.out.println("Concatenate After:  list1: " + test1 + ", list2: " + test2);
    }
        
    
    
    public static void main(String[] args){

        //Come up with test cases of your own
        //the provided tests are not sufficient!
                
        testAdd();          //uncomment me for Part 2.3!     
        testConcatList();   //uncomment me for Part 2.6!
                
    }
    

    
}
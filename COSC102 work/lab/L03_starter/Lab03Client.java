import java.util.Arrays;


public class Lab03Client{
  
  
  public static void main(String[] args){
    
    
    //Below are the test cases provided to you in the lab writeup.
    //They are NOT SUFFICIENT!  You must add tests of your own
    //This will make up part of your lab grade!
    
    
    
    //****  2.1  ****
    
    //Before tackling the coding problems, complete the memory diagram exercise
    //in Lab03MemTrace.java per the instructions in the lab writeup!
    
    
    
    
    //*****  2.2 Tests  *****
    
    
     System.out.println("\n*** Test Sorted Evens ***");

     int[] nums1 = {2, 4, 8, 10};     
     System.out.println(Arrays.toString(nums1) + " -> " + Lab03Code.sortedEvens(nums1));
    
     int[] num = {2,8,4,10};
     System.out.println(Arrays.toString(num) + " -> " + Lab03Code.sortedEvens(num));
     int[] num1 = {2,7,4,5,3,10};
     System.out.println(Arrays.toString(num1) + " -> " + Lab03Code.sortedEvens(num1));
     int[] num2 = {-4, -2, 2,2,0,4,6,8, 9};
     System.out.println(Arrays.toString(num2) + " -> " + Lab03Code.sortedEvens(num2));
    
    
    
    //*****  2.3 Tests  *****
    
    
       
    System.out.println("\n\n*** Test Prefix Remover ***");    
 
    String[] str1 = {"catfish", "sunFish", "CatDog"};
    String pre1 = "cat";
    System.out.print(Arrays.toString(str1) + ", " + pre1  + "-> ");
    Lab03Code.prefixRemover(str1, pre1);
    System.out.println(Arrays.toString(str1));
   
    String[] str2 = {"prefix", "process", "proefficient", "problematic", "premix"};
    String pre2 = "pro";
    System.out.print(Arrays.toString(str2) + ", " + pre2  + "-> ");
    Lab03Code.prefixRemover(str2, pre2);
    System.out.println(Arrays.toString(str2));
    
    
    
    //*****  2.4 Tests  *****
    
        
    
    System.out.println("\n\n*** Test Find Formable Percentage ***");
    
    String[] words1 = {"cat", "bat", "elk", "deer", "moose"};
    String pool1 = "camtesopedblr";
    System.out.println(Arrays.toString(words1) + ", " + pool1 + " -> " + Lab03Code.findFormablePercentage(words1, pool1));
   
    String[] words2 = {"rat", "alphabet", "zebra", "canniboid", "ansterdam", ""};
    String pool2 = "qwertyuiopasdfghjklzxcvbnma";
    System.out.println(Arrays.toString(words2) + ", " + pool2 + " -> " + Lab03Code.findFormablePercentage(words2, pool2));
    
    
    
  }
  
  
}

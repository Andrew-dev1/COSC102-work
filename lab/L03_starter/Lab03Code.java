import java.util.Arrays;


public class Lab03Code{
    
   
    //***COMPLETE 2.1 BEFORE YOU START WRITING ANY CODE! ***
  
    //Start writing your code for 2.2 here!
    public static boolean sortedEvens(int[] arr){
      int max = Integer.MIN_VALUE;
      for(int num: arr){
        if(num%2 == 0 && num != 0 ){
          if(max <= num){
            max = num; 
          }
          else
            return false;
        }
        
      }
      return true;
    }

    public static void prefixRemover(String [] strs, String str){
      // iterates through the array of strings and grabs a substring 
      // of the word that is the length of the prefix
      for (int i = 0; i < strs.length; i++){
        String word = strs[i].substring(0,str.length()).toLowerCase();
        str = str.toLowerCase();

        // compares the substring with the prefix 
        if (str.equals(word)){
          strs[i] = strs[i].substring(str.length());
        }
        else{
          strs[i] = strs[i];
        }
      }

    }

    public static double findFormablePercentage(String[] words, String pool){
      double formable = 0;
      for(String word: words){
        String chars = isolateCharacters(word);
        int correctLetters = 0;
        
        // checks if the pool has enough occurence of each letter from 
        // the strings in the array 
        for (int i = 0; i < chars.length(); i++){
          char letter = chars.charAt(i);
          if(charCount(pool, letter) >= charCount(word, letter))
            correctLetters += 1;
            
        }
        if(correctLetters == chars.length())
          formable += 1;

      }
      return formable/ words.length;
    }
    
    //Helper function provided to you, might be useful for 2.4...
    //returns number of occurrences of ch in str
    //is this function case sensitive or insensitive??
    public static int charCount(String str, char ch){
      int count = 0;
      String upper = str.toUpperCase();
      String lower = str.toLowerCase();
      for (int i = 0; i < str.length(); i++){
        if (ch == lower.charAt(i) || ch == upper.charAt(i))
          count++;
      }
      return count;
    }

    // helper function that returns a string of all the different 
    // characters that occurred in the word 
    public static String isolateCharacters(String word){
      String wordChars = "";
      if(word == null || word.length() == 0){
        System.out.println("The given string was blank");
        return wordChars;
      }
          
      for(int i = 0; i < word.length();i++){
        String letter = word.substring(i,i+1).toLowerCase();
        if(! wordChars.contains(letter))
          wordChars += letter;
        
      }
      return wordChars;
    }
    



}

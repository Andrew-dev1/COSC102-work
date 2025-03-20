import java.util.*;
import java.io.*;

/* A mapping of words to the frequencies at which they appear,
   used by the bot to choose a word that follows another.
   Meant to be used as the value in the bigram map,
   each TransitionMap is associated with some word in the training text. */

public class TransitionMap{
  
  /* The words and their frequencies as keys and values, respectively */
  private HashMap<String, Integer> frequencies;
  
  /* The total number of words added to this object (i.e. the sum of the frequencies)
     Ex: given a map of {"the": 4, "quick":1, "brown":2, "fox":3}, wordCount would be 10
  */
  private int wordCount;
  
  /* Use me for your random number generation! */
  public static Random rand = ShakespeareBot.rand;
     
  /* Constructor */
  public TransitionMap(){
    this.wordCount = 0;
    frequencies = new HashMap<String, Integer>();    
  }
   
  
  /* addWord method:
      
      Adds the argument word to the transition map,
      updating the frequencies map and wordCount accordingly
  */
  public void addWord(String word){
    wordCount ++;
    if(frequencies.containsKey(word)){
      frequencies.replace(word,frequencies.get(word)+1);
    }
    else{
      frequencies.put(word, 1);
    }
    
  }
    
  /* getRandomWord method:
      
      Returns a random word from the TransitionMap, weighted by the frequencies.
      
      For example, given a freqMap of {"the": 4, "quick":1, "brown":2, "fox":3},
      this function would have a 40% chance to return "the", a 10% chance to return "quick", and so on...
      
      If the TransitionMap has no words added to it, this method returns null.
  */
  public String getRandomWord(){
    if(wordCount > 0){
      int randomNumber = rand.nextInt(wordCount)+1;
      int counter = 0;
      for(String word: frequencies.keySet()){
        if((counter+= frequencies.get(word)) >= randomNumber)
          return word;
      }
    }

    return null; 
  }
      
  
  /* toString method
  
      A nice, pretty String of the transition maps's words and frequencies,
      similar to the instructions.
  */
  public String toString(){
    if (frequencies.size() == 0)
      return "{}";
    StringBuilder sb = new StringBuilder("{");
    for (String key : frequencies.keySet())
      sb.append(key + ":" + frequencies.get(key) + ", ");
    return sb.substring(0,sb.length()-2) + "}";    
  }
  
  
  //--Accessors-- 
  public int getWordCount(){
    return this.wordCount;
  }  
   
}
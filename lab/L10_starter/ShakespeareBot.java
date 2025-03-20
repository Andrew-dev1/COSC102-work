import java.util.*;
import java.io.*;

/* A bot capable of procedurally generating Shakespeare text
   after being "trained" on any number of his work(s).
*/
public class ShakespeareBot{
  
  /* Mapping all words the bot has seen in its training
     to all the words that follow it */
  private HashMap<String, TransitionMap> bigramMap;
  
  /* Set of all words that start sentences. */
  private HashSet<String> sentenceStarters;
  
  /* Constants used in detecting sentence enders. */
  private static final String[] ENDPUNCT = {".", "?", "!"};
  private static final String[] ENDQUOT = {"", "\"", "'"};
  
  /* Use me for random number generation! */
  public static Random rand = new Random();
  
  /* Constructor */
  public ShakespeareBot(){
    
    bigramMap = new HashMap<String, TransitionMap>();
    sentenceStarters = new HashSet<String>();
  }
  
  
  /* train method
  
      Trains the bot on the text in the argument file name;
      updates the bot's bigram map with the text in the argument file.
      
      Returns a boolean indicating if the file was able to be open and read (true)
      or not (false... if file cannot be found or doesn't contain sufficient text).
  */
  public boolean train(String fname){
    try{
      Scanner scan = new Scanner(new File(fname));
      String first = "";
        if (scan.hasNext())
          first = scan.next();
        if (!scan.hasNext()){
          System.err.printf("Error! File %s does not contain at least two words\n", fname);
          return false;
        }   
      processFile(scan, first);
      scan.close();
    }
    catch (FileNotFoundException fnfe){
      System.err.printf("Could not read file %s\n", fname);
      return false;
    }
    return true;
  }
  
  
  /* processFile method
  
    - Helper method to process the text in a file once its been deemed valid.
    - Updates the bot's bigram map as well as sets of sentence starters and enders.
    - Arguments include a Scanner of the file to be processed (pointing at the second word in the file) and the first word in the file.
  */
  private void processFile(Scanner scan, String first){
    boolean firstUnused = true; 
    String oldWord = first;
    sentenceStarters.add(first);
    TransitionMap newMap;

    while(scan.hasNext()){
      String word = scan.next();
      if(firstUnused){
        newMap = new TransitionMap();
        firstUnused = false;
      }
      else if(!bigramMap.containsKey(oldWord)){
        if(isSentenceEnder(oldWord)){
          sentenceStarters.add(word);
        }
        newMap = new TransitionMap();
      }
      else {
        newMap = bigramMap.get(oldWord); 
      }

      newMap.addWord(word);
      bigramMap.put(oldWord, newMap);
      oldWord = word;
    }
    
  }
  
 
  /* isSentenceEnder helper method
  
      Determines if a particular word is a sentence ender;
      returns a boolean indicating if this word is a sentence ender or not.
      
      A word is a sentence ender if it ends with a ./?/!,
      with or without a single or double quote following.
      
      The following would all be considered sentence enders:
          day.  day?  day!  day."  day!'
  */
  private boolean isSentenceEnder(String word){
    for (String p : ENDPUNCT){
      for (String m : ENDQUOT){
        if (word.endsWith(p + m)){
          return true;
        }
      }
    }
    return false;
  }


  /* getRandomSentenceStarter method
  
      Returns a random sentence starter from the bot's data.
      If the bot's sentence starter set is empty, throws an IllegalStateException
      When picking, all sentence starters should be equally weighted
  */
  public String getRandomSentenceStarter(){
    if(sentenceStarters.size() <= 0) throw new IllegalStateException();
    int randomNumber = rand.nextInt(sentenceStarters.size());
    int counter = 0;
    for(String starter: sentenceStarters){
      if(counter++ == randomNumber){
        return starter;
      }
    }
    return null;
  }
  
  
  
  /* generateText(int)
  
      Generates and PRINTS the argument number of sentences,
      beginning with a random sentence starter 
  */
  public void generateText(int numOfSentences){
    if (numOfSentences <= 0)
      throw new IllegalArgumentException("Invalid number of lines specified: " + numOfSentences);    
    // initates variables
    String starter = getRandomSentenceStarter();
    String oldWord = starter;
    int number_of_sentence_enders = 0;

    // bases sentences on sentence enders. prints out each word as they get generated
    // creates next word by looking through the transition map of current word
    while(number_of_sentence_enders< numOfSentences){
      String newWord = bigramMap.get(oldWord).getRandomWord();
      System.out.print(oldWord + " ");
      if(isSentenceEnder(newWord))
        number_of_sentence_enders++;
      oldWord = newWord;
    }
    System.out.println(oldWord);

  }
  
  

  /* generateText(int, String)
    
      Generates and PRINTS the argument number of sentences,
      using the second argument as the seed word.

      These sanity checks are done for you; failing them throws an exception:
      - Number of sentences is invalid
      - The sentence starter doesn't exist in the bot's bigram map
  */
  public void generateText(int numOfSentences, String seedWord){
    if (numOfSentences <= 0)
      throw new IllegalArgumentException("Invalid number of lines specified: " + numOfSentences);      
    if (!bigramMap.containsKey(seedWord))
      throw new IllegalArgumentException("Seed word: \"" + seedWord + "\" doesn't exist in bot's model!");

      String oldWord = seedWord;
      int number_of_sentence_enders = 0;
      while(number_of_sentence_enders< numOfSentences){
        String newWord = bigramMap.get(oldWord).getRandomWord();
        System.out.print(oldWord + " ");
        if(isSentenceEnder(newWord))
          number_of_sentence_enders++;
        oldWord = newWord;
      }
      System.out.println(oldWord);
    
    
  }
  
  
  /* toString method
  
      Returns a nice, pretty string of the bot's words and their transitions
  */
  public String toString(){
    if (bigramMap.size() == 0)
      return "{}";
    StringBuilder sb = new StringBuilder("{");
    for (String key : bigramMap.keySet())
      sb.append(key + "->" + bigramMap.get(key) + "\n");
    return sb.substring(0,sb.length()-1) + "}";    
  }     
  
  
  
  
  //--Accessors--   
  public HashSet<String> getSentenceStarters(){
    return this.sentenceStarters;
  }
  
  
  public HashMap<String, TransitionMap> getBigramMap(){
    return this.bigramMap;
  }
  //-------------
  
     

    
}


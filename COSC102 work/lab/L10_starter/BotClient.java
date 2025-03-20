import java.util.*;
import java.io.*;

//Client class used to test your various ShakespeareBot 
//and word bank functionalities
public class BotClient{
  
  public static void main(String[] args){
    
    ShakespeareBot bot = new ShakespeareBot();
    bot.train("AsYouLikeIt.txt");
    
    System.out.println(bot.getRandomSentenceStarter());    
    
    
    TransitionMap map = new TransitionMap();
    map.addWord("null");    map.addWord("null");    map.addWord("space");     map.addWord("null");     map.addWord("hi");
    System.out.println(map);
    System.out.println(map.getRandomWord());
    System.out.println(map.getRandomWord());System.out.println(map.getRandomWord());
    
    System.out.println(bot);
    System.out.println("\nAll Sentence Starters:");
    System.out.println(bot.getSentenceStarters());

    System.out.println("\nAnother random sentence starter:");
    System.out.println(bot.getRandomSentenceStarter());

    System.out.println("\ngenerating text of 20 lines");
    bot.generateText(20);



    bot.train("RomeoAndJuliet.txt");
    bot.train("TwelfthNight.txt");
    System.out.println("\ngenerating text of 20 lines after training bot on all three files");
    bot.generateText(20);

    System.out.println("\ngenerating text of 20 lines with seed word, Romeo");
    bot.generateText(20, "Romeo");

    System.out.println("\nTesting on test textfile of donald trump's speech in reno 12/17/23");
    ShakespeareBot bot1 = new ShakespeareBot();
    bot1.train("test.txt");
    System.out.println("Generating text of 10 lines");
    bot1.generateText(10);



  }
  
}


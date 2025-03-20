import java.util.Random;

//Use this class to test your individual Plantlets!
public class PlantletClient{
   

   public static void main(String[] args){

      FlubFlubRoot ffr = new FlubFlubRoot();
      System.out.println("before: \"" + ffr + "\"");
      System.out.println("grew by: " + ffr.handleOneDayGrowth(Plantlet.TEMP_WARM, false, true));
      System.out.println("after: \"" + ffr + "\"");                   
      
      System.out.println("\nDay 2");
      System.out.println("before: \"" + ffr + "\"");
      System.out.println("grew by: " + ffr.handleOneDayGrowth(Plantlet.TEMP_HOT, false, false));
      System.out.println("after: \"" + ffr + "\"");    
      
      System.out.println("\nDay 3");
      System.out.println("before: \"" + ffr + "\"");
      System.out.println("grew by: " + ffr.handleOneDayGrowth(Plantlet.TEMP_CHILLY, false, true));
      System.out.println("after: \"" + ffr + "\"");    

      System.out.println("\nDay 4");
      System.out.println("before: \"" + ffr + "\"");
      System.out.println("grew by: " + ffr.handleOneDayGrowth(Plantlet.TEMP_HOT, false, false));
      System.out.println("after: \"" + ffr + "\"");   


      KupoBerry berr = new KupoBerry();
      System.out.println("before: \"" + berr + "\"");
      System.out.println("grew by: " + berr.handleOneDayGrowth(Plantlet.TEMP_WARM, false, true));
      System.out.println("after: \"" + berr + "\"");   
      
      System.out.println("\nDay 2");
      int GU = berr.handleOneDayGrowth(Plantlet.TEMP_WARM, true, true);
      System.out.println("before: \"" + berr + "\"");
      System.out.println("grew by: " + GU);
      System.out.println("after: \"" + berr + "\"");  
      System.out.println("chance of being eaten is " + berr.getEatChance());

      System.out.println("\nDay 3, eaten");
      berr.eatPlantlet();
      System.out.println("after: \"" + berr + "\"");  
      berr.eatPlantlet();
      System.out.println("eaten again: \"" + berr + "\"");  

      System.out.println("\nDay 4");
      GU = berr.handleOneDayGrowth(Plantlet.TEMP_WARM, true, true);
      System.out.println("before: \"" + berr + "\"");
      System.out.println("grew by: " + GU);
      System.out.println("after: \"" + berr + "\"");  
      System.out.println("chance of being eaten is " + berr.getEatChance());

      SoakOak soakky = new SoakOak();
      System.out.println("\nDay 1");
      System.out.println("before: \"" + soakky + "\"");
      System.out.println("grew by: " + soakky.handleOneDayGrowth(Plantlet.TEMP_WARM, false, true));
      System.out.println("after: \"" + soakky + "\"");       

      System.out.println("\nDay 2");
      System.out.println("before: \"" + soakky + "\"");
      System.out.println("grew by: " + soakky.handleOneDayGrowth(Plantlet.TEMP_HOT, true, true));
      System.out.println("after: \"" + soakky + "\"");

      System.out.println("\nDay 3");
      System.out.println("before: \"" + soakky + "\"");
      System.out.println("grew by: " + soakky.handleOneDayGrowth(Plantlet.TEMP_CHILLY, false, false));
      System.out.println("after: \"" + soakky + "\"");

      System.out.println("\nDay 4");
      System.out.println("before: \"" + soakky + "\"");
      System.out.println("grew by: " + soakky.handleOneDayGrowth(Plantlet.TEMP_WARM, true, true));
      System.out.println("after: \"" + soakky + "\"");  

      KupoPrickle pricky = new KupoPrickle();
      System.out.println("\nDay 1");
      System.out.println("before: \"" + pricky + "\"");
      System.out.println("grew by: " + pricky.handleOneDayGrowth(Plantlet.TEMP_WARM, true, true));
      System.out.println("after: \"" + pricky + "\"");  

      System.out.println("\nDay 2");
      System.out.println("before: \"" + pricky + "\"");
      System.out.println("grew by: " + pricky.handleOneDayGrowth(Plantlet.TEMP_CHILLY, false, false));
      System.out.println("after: \"" + pricky + "\"");  

      System.out.println("\nDay 3");
      System.out.println("before: \"" + pricky + "\"");
      System.out.println("grew by: " + pricky.handleOneDayGrowth(Plantlet.TEMP_HOT, false, true));
      System.out.println("after: \"" + pricky + "\"");  

      System.out.println("\nDay 4");
      System.out.println("before: \"" + pricky + "\"");
      System.out.println("grew by: " + pricky.handleOneDayGrowth(Plantlet.TEMP_WARM, true, false));
      System.out.println("after: \"" + pricky + "\"");

      KupoPrickle wiltyPricks = new KupoPrickle();
      System.out.println("\nTwo days with same conditions");
      System.out.println("before: \"" + wiltyPricks + "\"");
      System.out.println("grew by: " + wiltyPricks.handleOneDayGrowth(Plantlet.TEMP_WARM, true, false));
      System.out.println("grew by: " + wiltyPricks.handleOneDayGrowth(Plantlet.TEMP_WARM, true, false));
      System.out.println("after: \"" + wiltyPricks + "\"");

      KupoPrickle wiltyPricks2 = new KupoPrickle();
      System.out.println("\nDay 1 and 3 with same conditions");
      System.out.println("before: \"" + wiltyPricks2 + "\"");
      System.out.println("grew by: " + wiltyPricks2.handleOneDayGrowth(Plantlet.TEMP_WARM, true, false));
      System.out.println("grew by: " + wiltyPricks2.handleOneDayGrowth(Plantlet.TEMP_WARM, false, false));
      System.out.println("grew by: " + wiltyPricks2.handleOneDayGrowth(Plantlet.TEMP_WARM, true, false));
      System.out.println("after: \"" + wiltyPricks2 + "\"");
      System.out.println("wiltyPricks2's chances of being eaten is " + wiltyPricks2.getEatChance() );

      System.out.println("\nDay 5, pricky eaten three times");
      System.out.println("before: \"" + pricky + "\"");
      System.out.println("Munchies by a zebrasaurous, kangaroo, and rainbow horse with horn");
      pricky.eatPlantlet();
      pricky.eatPlantlet();
      pricky.eatPlantlet();
      System.out.println("grew by: " + pricky.handleOneDayGrowth(Plantlet.TEMP_WARM, true, false));
      System.out.println("after: \"" + pricky + "\"");
      System.out.println("pricky's chances of being eaten is " + pricky.getEatChance() );


      KupoPrickle pricky2 = new KupoPrickle();
      System.out.println("\nDay 1");
      System.out.println("before: \"" + pricky2 + "\"");
      System.out.println("grew by: " + pricky2.handleOneDayGrowth(Plantlet.TEMP_WARM, true, true));
      System.out.println("after: \"" + pricky2 + "\"");  
      System.out.println("pricky2's chances of being eaten is " + pricky2.getEatChance() );

      System.out.println("\nDay 2, eaten");
      System.out.println("before: \"" + pricky2 + "\"");
      pricky2.eatPlantlet();
      System.out.println("after: \"" + pricky2 + "\"");
      System.out.println("pricky2's chances of being eaten is " + pricky2.getEatChance() );

      System.out.println("\nDay 6");
      System.out.println("before: \"" + berr + "\"");
      System.out.println("grew by: " + berr.handleOneDayGrowth(Plantlet.TEMP_WARM, true, true));
      System.out.println("after: \"" + berr + "\"");  
      System.out.println("chance of being eaten is " + berr.getEatChance());

      System.out.println("\nDay 7");
      System.out.println("before: \"" + berr + "\"");
      System.out.println("grew by: " + berr.handleOneDayGrowth(Plantlet.TEMP_WARM, true, true));
      System.out.println("after: \"" + berr + "\"");  
      System.out.println("chance of being eaten is " + berr.getEatChance());

      System.out.println("\nDay 8");
      System.out.println("before: \"" + berr + "\"");
      System.out.println("grew by: " + berr.handleOneDayGrowth(Plantlet.TEMP_WARM, true, true));
      System.out.println("after: \"" + berr + "\"");  
      System.out.println("chance of being eaten is " + berr.getEatChance());


      System.out.println(ffr instanceof AnimalEdible);
   }
   

}

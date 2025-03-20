//Representation of a FlubFlubRoot Plantlet
//FlubFlubRoots likes dry heat, but dislikes the cold and rain!
//Animals don't like FlubFlubRoots and won't try to eat them

//A FlubFlubRoot *IS-A* Plantlet
public class FlubFlubRoot extends Plantlet{  
    
    //Requires 11 GUs to be fully grown
    public static final int REQ_GU = 11;
    //FlubFlubRoot's character identifier
    public static final String ID = "FR";
    

    //No arguments constructor
    public FlubFlubRoot(){
        //Pass the ID and required GUs to the parent constructor
        super(REQ_GU);
    }
    
    
    //Simulates one day's growth, determines how much (if at all)
    //the Plantlet grows by and/or if the Plantlet wilts.
    //Updates the seedling's state accordingly.
    //
    //Accepts as arguments:
    //  int temp: value 0 to 2 (inclusive) indicating one of three temps (Chilly/Warm/Hot)
    //  boolean getsSun: indicates if the Plantlet gets sun on this day (true) or not (false) 
    //  boolean getsRain: indicates if the Plantlet gets rain on this day (true) or not (false)
    //
    //Returns:
    //  the number of GUs the Plantlet grew by, if it grew, or
    //  -1 if the Plantlet wilted on this day, or    
    //  0 if the Plantlet didn't grow or was already wilted      
    public int handleOneDayGrowth(int temp, boolean getsSun, boolean getsRain){  
       
      int dailyGU; 
      if(isWilted())
         return 0;
      else if(temp == 0){
         if(getsRain){
            wilt();
            return -1;
         }
         else
            dailyGU = 1;
      }
      else{
         if(temp == 2 && ! getsRain){
            dailyGU = 4;
         }
         else
            dailyGU = 2;
      }
      dailyGU = grow(dailyGU);
      
      return dailyGU;
    }
    
    
   //Accessor for the ID String of the Plantlet 
   public String getID(){
      return ID;
   }               
    
}

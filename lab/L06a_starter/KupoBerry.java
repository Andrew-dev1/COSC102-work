public class KupoBerry extends Plantlet implements AnimalEdible{

    //Requires 15 GUs to be fully grown
    public static final int REQ_GU = 15;
    //Kupoberry's character identifier
    public static final String ID = "KB";
    
    public int GU = 3;
     

    //No arguments constructor
    public KupoBerry(){
        //Pass the ID and required GUs to the parent constructor
        super(REQ_GU);
    }
    
    public double getEatChance(){
        return GU * 0.04;
    }
    public void eatPlantlet(){
        resetGU();
        GU ++;
    }
    
    //Simulates one day's growth, determines how much (if at all)
    //the Plantlet grows by and/or if the Plantlet wilts. Updates the seedling's state accordingly. 
    public int handleOneDayGrowth(int temp, boolean getsSun, boolean getsRain){  
       
        int dailyGU;
        if(! getsSun)
            dailyGU =1;
        else 
            dailyGU = GU;
      
        dailyGU = grow(dailyGU);
        return dailyGU;
    }

    // public boolean eatenToday(int dailyGU){
    //     double chance = (int) (Math.random()* 100)+ 1/ 100;
    //     if(getEatChance(dailyGU)< chance)
        
    // }
    
    
   //Accessor for the ID String of the Plantlet 
   public String getID(){
      return ID;
   }               
    
}

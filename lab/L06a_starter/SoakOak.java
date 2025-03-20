public class SoakOak extends Plantlet{
    //Requires 11 GUs to be fully grown
    public static final int REQ_GU = 17;
    //SoakOak's character identifier
    public static final String ID = "SO";
    
    public int priorDayGU;

    //No arguments constructor
    public SoakOak(){
        //Pass the ID and required GUs to the parent constructor
        super(REQ_GU);
    }
    
    
    //Simulates one day's growth, determines how much (if at all)
    //the Plantlet grows by and/or if the Plantlet wilts.
    //Updates the seedling's state accordingly.
   
    public int handleOneDayGrowth(int temp, boolean getsSun, boolean getsRain){  
       
      int dailyGU; 
      if(getGU() == 0){
        dailyGU = 1;
      }
      else{
        if(! getsRain)
            dailyGU = 1;
        else
            dailyGU = priorDayGU +2;
      }
      dailyGU = grow(dailyGU);
      priorDayGU = dailyGU;
      return dailyGU;
    }
    
    
   //Accessor for the ID String of the Plantlet 
   public String getID(){
      return ID;
   }      
}
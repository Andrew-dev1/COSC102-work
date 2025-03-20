import java.util.Random;

//A Plantlet of a Plant to be planted in your garden
//Plantlet is an *ABSTRACT CLASS*... All common Plantlet 
//attributes/functionality defined here and inherited by children
public abstract class Plantlet{
    
    
    //***************************************************************
    //*                                                             *
    //*             DO NOT MODIFY ANY CODE IN THIS FILE             *
    //*              Except for the toString() method!              *
    //*                                                             *       
    //***************************************************************
    
    //ints for the different temperature possibilities on a given day
    public static final int TEMP_CHILLY = 0;
    public static final int TEMP_WARM = 1;
    public static final int TEMP_HOT = 2;   
   
   
    //The string label used to represent a wilted seedling    
    public static final String WILTED_STR = "WILT";
    //The GU (ie "grow units") value used to represent a wilted seedling
    public static final int WILTED_VALUE = -1;
    //Used for generating random values here and in children classes
    protected static Random rand = new Random();
    public boolean covered = false;
    
    //The required GUs for the Plantlet to be considered "fully grown"
    private int maxGU;
    //The number of GUs the Plantlet has currently grown
    private int currentGU = 0;


    //At instantiation, the required GU and an ID is required for the Plantlet
    public Plantlet(int maxGU) {        
        this.maxGU = maxGU;    
    }
 
    //Sets the Plantlet to be wilted
    //Once a Plantlet is wilted, it cannot grow nor can it become un-wilted
    protected void wilt(){
        currentGU = WILTED_VALUE;
    }
    
    //Returns how much the Plantlet has grown (its current accumulated GUs)
    public int getGU(){
        return currentGU;
    }
    
    //Returns how many GUs are required for this Plantlet to be "fully grown"
    public int getMaxGU(){
        return maxGU;
    }
    
    //returns a boolean indicating if the Plantlet is wilted (true) or not (false)
    public boolean isWilted(){
        return (currentGU == WILTED_VALUE);
    }
    
    
    //Increases the Plantlet's current GUs by the argument amount.  Returns 
    //the GUs the Plantlet *actually* grew by (as GUs cannot exceed required)
    //
    //For example:
    //  Given a KupoBerry (requires 15 GUs) w/ a current GU of 12, a call of
    //  grow(4) would increase the KupoBerry's GUs by 3 and thus return 3.
    //
    //An exception is thrown if:
    //  a negative argument is passed
    //  the Plantlet is currently wilted (wilted Plantlets cannot grow)
    protected int grow(int increasedGU){
        if (isWilted())
            throw new IllegalStateException("Error! A wilted plant cannot grow!");
        if (increasedGU < 0)
            throw new IllegalArgumentException("Error! Cannot grow a plant by a negative amount!");
        int oldGU = this.currentGU;
        this.currentGU = Math.min(maxGU, currentGU + increasedGU);   
        return currentGU - oldGU;
    }
    
    
    
    //Resets this Plantlet's GU back to 0.  Wilted Plantlets can't be reset.
    //Will be used by AnimalEdible Plantlets.
    protected void resetGU(){
      if (this.currentGU == WILTED_VALUE)
         throw new IllegalStateException("A wilted Plantlet cannot recover from a wilted state!");
      this.currentGU = 0;
    }
    
    
    //Returns a String representation of the Plantlet.
    //The String will include the Plantlet's ID and a percentage (truncated to an int) 
    //indicating how fully grown it is (its current GU out of its required GU).
    //The String returned ***MUST ALWAYS BE EXACTLY 7 CHARACTERs LONG!***
    //
    //For Example: 
    //  a FlubFlubRoot at 6 GU would return (w/out the quotes): "FR  63%"
    public String toString(){
        
        if(isWilted())
            return this.getID() + " WILT";
        int percentage = (int) (getGU()*100 /getMaxGU() );
        if(percentage == 0){
            return this.getID() + "   " + percentage + "%";
        }
        return this.getID() + "  " + percentage + "%";
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
    public abstract int handleOneDayGrowth(int temp, boolean getsSun, boolean getsRain);
    
    public abstract String getID();
    
}

public class WibbleWort extends Plantlet implements AnimalEdible{

    //Requires 22 GUs to be fully grown
    public static final int REQ_GU = 22;
    //Wibblewort's character identifier
    public static final String ID = "WW";
    public int growthLimit;
    public int hotDays; 

    public WibbleWort(){
        this(4);
    }
    public WibbleWort(int growRange){
        super(REQ_GU);
        if(growRange >= 4){
            growthLimit = growRange;
        }
        else
            throw new IllegalArgumentException("The growth range has to be more than 3") ;
    }

    public double getEatChance(){
        if(hotDays == 0)
            return 0.03;
        else if(hotDays == 1)
            return 0.07;
        else 
            return 0.15;
    }


    public void eatPlantlet(){
        resetGU();
        hotDays = 0;
    } 


    public int handleOneDayGrowth(int temp, boolean getsSun, boolean getsRain){  
        int dailyGU = rand.nextInt(1, growthLimit +1);
        if(isWilted())
            return 0;
        if(temp == 1){
            if(getsSun)
                dailyGU *= 2;
            else
                dailyGU *= 3;
        }
        if(temp == 2){
            hotDays += 1;
        }
        if(hotDays >= 3){
            wilt();
            return -1;
        }
        dailyGU = grow(dailyGU);
        return dailyGU;
    
    }



    //Accessor for the ID String of the Plantlet 
    public String getID(){
        return ID;
    }

}

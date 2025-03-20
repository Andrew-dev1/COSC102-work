public class KupoPrickle extends KupoBerry{

    //Kupoprickle's character identifier
    public static final String ID = "KP";
    private int[] priorTemps = new int[3];
    private boolean[] priorSun = new boolean[3]; 
    private boolean[] priorRain = new boolean[3];
    int growDay = 0;
    
    public KupoPrickle(){
        super();
    }

    public double getEatChance(){
        if(isWilted() || growDay > 2){
            return 0;
        }
        return super.getEatChance();
    }

    public void eatPlantlet(){
        if(isWilted() || growDay > 2){
        }
        else{
            resetGU();
            GU ++;
        }
    }

    public int handleOneDayGrowth(int temp, boolean getsSun, boolean getsRain){         
        int dailyGU;
        if(isWilted())
            return 0;
        if(growDay < 3 && checkWilting(temp, getsSun, getsRain)){
            wilt();
            return -1;
        }
        growDay ++;
        dailyGU = super.handleOneDayGrowth(temp, getsSun, getsRain);
        return dailyGU;
    }

    public boolean checkWilting(int temp, boolean getsSun, boolean getsRain){
        for(int i = 0; i < growDay; i++){
            if(priorTemps[i] == temp && priorSun[i] == getsSun && priorRain[i] == getsRain){
                return true;
            }
        }
        priorTemps[growDay] = temp;
        priorSun[growDay] = getsSun;
        priorRain[growDay] = getsRain;
        return false;
    }

    //Accessor for the ID String of the Plantlet 
    public String getID(){
        return ID;
    }             
}

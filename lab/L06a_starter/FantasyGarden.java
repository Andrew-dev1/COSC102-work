import java.util.Random;
//An abstraction of your fantasy garden
//Stores a collection of seedlings via a 2D array
public class FantasyGarden{
    
    
    
    //********       DO NOT MODIFY THESE VARIABLES       ********
    
    //ints for the different temperature possibilities on a given day
    public static final int TEMP_CHILLY = Plantlet.TEMP_CHILLY;
    public static final int TEMP_WARM = Plantlet.TEMP_WARM;
    public static final int TEMP_HOT = Plantlet.TEMP_HOT;
    
    //Minimum garden dimensions
    public static final int MIN_ROWS = 2;
    public static final int MIN_COLS = 2;    
        
    
    //Used by Garden's toString to represent a plot with no seedling in it
    private static final String EMPTY_STR = "[       ] ";
    
    //An array representing the contents of your garden. Each index of this
    // array (row, col) represents one "plot" where a Plantlet can be planted.
    private Plantlet[][] garden;
        
    //***********************************************************
    
    
    
    
    
    private int plantedCT; 
    private static Random rand = new Random();
   
    
    //Accepts a row and col argument, representing the dimensions of the
    // garden (the garden will have rows * cols "plots" for Plantlets)
    public FantasyGarden(int rows, int cols){ 
      if(rows >= MIN_ROWS && cols >= MIN_COLS)
         garden = new Plantlet[rows][cols];
      else
         garden = new Plantlet[MIN_ROWS][MIN_COLS];
    }
    
    
    
    //Attempts to "plant" the argument seedling in the garden by adding it
    //to the next available plot in the garden array.
    //The garden is populated column by column, row by row. (i.e. first Plantlet
    //is planted in row=0, col=0, second is planted in row=0, col=1, and so on...
    //
    //Returns a boolean indicating if the Plantlet is succesfully planted or not.
    public boolean plant(Plantlet toPlant){
      
      for(int i = 0; i < garden.length; i++){
         for(int j = 0; j < garden[0].length; j ++){
            if(garden[i][j] == null){
               garden[i][j] = toPlant;
               return true;
            }
         }
      }
      
       return false; // placeholder      
    }
    
    // looks for any soak oaks within the garden and then 
    // checks to see if the nearby plants would be covered
    public void findCoveredPlants(){
      for(int i = 0; i < garden.length; i++){
         for(int j = 0; j < garden[0].length; j ++){
            if(garden[i][j] instanceof SoakOak){
               checkCovering(i, j);
            }
         }
      }
    }

    // changes the covering of plants in a one box radius from the central plant
    public void checkCovering(int row, int col){
      int upperBound = row -1; int lowerBound = row+1; int rightBound = col-1; int leftBound = col+1;
      if(upperBound < 0)
         upperBound = 0;
      if(lowerBound >= garden.length)
         lowerBound = row;
      if(rightBound < 0)
         rightBound = 0;
      if(leftBound >= garden[0].length)
         leftBound = col;

      for(int i = upperBound;i <= lowerBound; i ++){
         for(int j = rightBound; j <= leftBound; j ++){
            garden[i][j].covered = !(garden[i][j] instanceof SoakOak);
         }
      }
      

    }
    
    
    //Simulates the argument number of days in the garden.
    //Each day, a description of that days' progression is printed
    //along with a String representation of the garden's state as of
    //the end of that day.   
    public void runSimulation(int numOfDays){
      if(numOfDays >= 0){
         int currentDay = 1;
         if(currentDay == 1){
            findCoveredPlants();
         }

         while(currentDay <= numOfDays){
            int randomTemp = generateTemperature();
            boolean rain = generateRain();
            boolean sun = generateSun(rain);

            System.out.println("*** DAY "+ currentDay + "***");
            printWeather(randomTemp, sun, rain);

            oneDayGardenGrowth(randomTemp, sun, rain);
            oneDayOfAnimals();
            
            System.out.println("\n" + this.toString());
            currentDay ++;
         }
      }
      else
         throw new IllegalArgumentException("Negative days not possible ");
       
    }
   
   // generates a random integer for the temperature 
   public int generateTemperature(){
      return rand.nextInt(3);
   }

   // generates a random boolean for the sun based on if it's rainy or not
   public boolean generateSun(boolean rainy){
      if(rainy)
         return false;
      else
         return rand.nextBoolean();
   }

   // generates a random booleam for the rain
   public boolean generateRain(){
      return rand.nextBoolean();
   }
   
   // prints out the weather based on the weather conditions for the day
   public static void printWeather(int randomTemp,boolean sun,boolean rain){
      String statement = "Today's temp is: ";
      if(randomTemp == TEMP_CHILLY)
         statement += "chilly. ";
      else if(randomTemp == TEMP_WARM)
         statement += "warm. ";
      else 
         statement += "hot. ";
      statement += "There is: ";

      if(sun)
         statement += "sun"; 
      else
         statement += "no sun";
      statement += ", and it is: ";

      if(rain)
         statement += "raining.";
      else
         statement += "not raining. ";  
      System.out.println(statement);
   }
    
   // deals with one day of growth in the garden 
   // each plant is given the same weather conditions and 
   // and then displaying the results of each plant's growth
   public void oneDayGardenGrowth(int temp, boolean getsSun, boolean getsRain){
      for(int i = 0; i < garden.length; i++){
         for(int j = 0; j < garden[0].length; j ++){
            int GU;
            if(garden[i][j] == null)
               break;
            else{
               if(garden[i][j].covered){
                  GU = garden[i][j].handleOneDayGrowth(temp, false, false);
               }
               else
                  GU = garden[i][j].handleOneDayGrowth(temp, getsSun, getsRain);
               printPlantGrowth(i, j, GU);
            }
         }
      }
   }

   //prints out the change of the plant depending on if it is wilting, wilted, or growing
   public void printPlantGrowth(int row, int col, int GU){
      if(GU >= -1 && row >= 0 && col >= 0){
         if(GU == -1)
            System.out.println("\tPlantlet at row: " + row +", col: " + col + " wilts!");
         else if(GU == 0)
            System.out.println("\tPlantlet at row: " + row +", col: " + col + " is wilted!");
         else
            System.out.println("\tPlantlet at row: " + row +", col: " + col + " grew by: " + GU +" GU!");
      }
      
   }

   // runs the stimulation of a single day of animals prowling through
   // the garden and checks if the edible plants were eaten
   public void oneDayOfAnimals(){
      for(int i = 0; i < garden.length; i++){
         for(int j = 0; j < garden[0].length; j ++){
            if(! garden[i][j].isWilted() && garden[i][j] instanceof AnimalEdible){
               AnimalEdible plant = ((AnimalEdible) garden[i][j]);
               if(eaten(plant.getEatChance())){
                  plant.eatPlantlet();
                  System.out.println("\tAnimals ate the plantlet at row: "+ i +", col: " + j + "!");
               }
            }
            
         }
      }
   }

   // checks if the specific plant will be eaten
   public boolean eaten(double eatenPercentage){
      return eatenPercentage > rand.nextDouble();
   }
    
    
    //****************   Do not modify the below methods!    ****************    
    
    
    

    
    
    //Returns a String representation of the garden, printed col by col,
    //row by row in a matrix. ***Do not modify this method***
    public String toString(){
       
       String toReturn = "";
       for (int row = 0; row < garden.length; row++){
          for (int col = 0; col < garden[0].length; col++){
             if (garden[row][col] != null)
                toReturn += "[" + garden[row][col].toString() + "] ";
             else
                toReturn += EMPTY_STR;
          }
          toReturn += "\n";
       }              
       return toReturn;
    }
    
    
    
    //Accessor method for the 2D garden array
    public Plantlet[][] getGarden(){
      return garden;
    }
    
    
    
}

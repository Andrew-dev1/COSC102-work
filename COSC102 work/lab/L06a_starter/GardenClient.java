import java.util.Random;

//Use this class to test your Garden Simulation!
public class GardenClient{
   

   public static void main(String[] args){

      //make a garden
      FantasyGarden fg = new FantasyGarden(2, 4); 
      System.out.println(fg);
      
      //add a Plantlet (and check if it added successfully)
      System.out.println(fg.plant(new FlubFlubRoot()));
      System.out.println(fg);
      //and so on... 
      
      fg.plant(new KupoBerry());
      fg.plant(new KupoBerry());
      fg.plant(new KupoPrickle());
      fg.plant(new SoakOak());
      fg.plant(new WibbleWort());
      fg.plant(new FlubFlubRoot());
      fg.plant(new FlubFlubRoot());
      System.out.println(fg);

      System.out.println(fg.plant(new FlubFlubRoot()));
      System.out.println(fg);

      fg.runSimulation(0);
      fg.runSimulation(0);
      // fg.runSimulation(-1);

      FantasyGarden fg1 = new FantasyGarden(0, 0);
      System.out.println(fg1);
      fg1.plant(new SoakOak());
      fg1.plant(new SoakOak());
      fg1.plant(new SoakOak());
      fg1.plant(new SoakOak());
      System.out.println(fg1);
      fg1.runSimulation(7);

      fg.runSimulation(3);

      FantasyGarden fg2 = new FantasyGarden(2, 4);
      fg2.plant(new FlubFlubRoot());
      fg2.plant(new KupoBerry());
      fg2.plant(new KupoBerry());
      fg2.plant(new KupoPrickle());
      fg2.plant(new SoakOak());
      fg2.plant(new SoakOak());
      fg2.plant(new FlubFlubRoot());
      fg2.plant(new FlubFlubRoot());
      fg2.runSimulation(3);

      fg.runSimulation(1);
      fg2.runSimulation(1);

      System.out.println("Rainy: " +fg.generateRain());;
      System.out.println("Sunny: " +fg.generateSun(false));
      System.out.println("Sunny: " +fg.generateSun(true));
      System.out.println("Temp: " +fg.generateTemperature());
      System.out.println("Did this get eaten (100%): " + fg.eaten(1));
      System.out.println("Did this get eaten (50%): " + fg.eaten(0.5));
      System.out.println("Did this get eaten (0%): " + fg.eaten(0));
      System.out.println("Did this get eaten (1%): " + fg.eaten(0.01));
      System.out.println("Did this get eaten (1%): " +fg.eaten(0.99));

      System.out.println("Does row 0, col 4, GU 7 print?");
      fg.printPlantGrowth(0, 4, 7);
      System.out.println("Does row -1, col 4, GU 7 print?");
      fg.printPlantGrowth(-1, 4, 7);
      System.out.println("Does row 0, col -4, GU 7 print?");
      fg.printPlantGrowth(0, -4, 7);
      System.out.println("Does row 0, col 4, GU -7 print?");
      fg.printPlantGrowth(0, 4, -7);
      FantasyGarden.printWeather(0, false, false);
      
      fg.runSimulation(1);
      fg2.runSimulation(1);

      fg2.runSimulation(7);

   }
   

}

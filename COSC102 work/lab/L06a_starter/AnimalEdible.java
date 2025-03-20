//Interface implemented by Plantlets which are desirable by animals

public interface AnimalEdible{
   
   //Returns the probability of the referenced Plantlet
   //being eaten by animals per its behavior and current state.
   //
   //Returns the percentage as a decimal.  Ex: 0.07 represents 7%.
   public double getEatChance();
   
   
   //Called when a Plantlet has been eaten during the simulation.
   //In addition to the Plantlet's current GU being set to 0,
   //Each AnimalEdible Plantlet has unique behavior(s) when eaten.
   public void eatPlantlet();

   
}
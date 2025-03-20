public class Lab01Code{
   
   
   
   public static void main(String[] args){
      
      System.out.println("Hello World!");
      System.out.println("If you see this, your Lab 01 code ran successfully!");


      
      //2.2.1 - Java Math ==================================================
     
     /*
     
      int a = 18;
      int b = 10;
      int c = 6;
      System.out.println("Result #1: " + (a - b / c));
      
      double z = 100.0;
      System.out.println("Result #2: " + (a * b / z));
      
      
      System.out.println("Result #3: " + (a * b % z));
      
      
     */
  









      //2.2.2 - In the Range ==================================================

      
    
       /* 
       
      //----The below code should work for any values of num, low, and high!----
      int num = 2;
      int low = 2;
      int high = 15;
      //------------------------------------------------------------------------
      
      
      
      if (num >= low && num <= high) 
         System.out.println(true);
      else 
         System.out.println(false);
      
      */
          
      
      
      







      //2.2.3 - Check Positive Doubles ==============================================
      
   
       /* 
       
      //----The below code should work for any values of numA and numB!----
      int numA = 15;
      int numB = 30;
      //-------------------------------------------------------------------

      int big = Math.max(numA, numB );
      int small = Math.min(numA,numB);

      //You finish the rest!...
      if(numA <= 0 || numB <= 0)
         System.out.println(false);
      else if(small != (double) big /2)
         System.out.println(false);
      else
         System.out.println(true);
     
      */






      //2.2.4 - Neighbor Letters ==============================================
      
   
    
       /* 
       
      //----The below code should work for any LETTER values for ch1 and ch2!----
      char ch1 = 'Q';
      char ch2 = 'R';
      //-------------------------------------------------------------------


      if (ch1 == (ch2 + 1) || ch1 == (ch2 - 1))
        System.out.println("The chars are neighbors!");
      else if (ch1 == ch2)
        System.out.println("The chars are neighbors!");
      else 
      {
        int diff = Math.abs(ch1 - ch2);
        System.out.println("The chars are NOT neighbors -- they're " + diff + " letters apart!");
      }
      */
     







      //2.2.5 - Water State ================================================

      
     
    
    /*    
             
      //----    The below code should work for any values of temp/metric!    ----
      //----(Though you may assume metric is always an 'F', 'f', 'C', or 'c')----
      int temp = 60;      
      char metric = 'f';
      //------------------------------------------------------------------------0

      int boilingTemp;
      int freezingTemp;

      if (metric == 'f' || metric =='F'){
         boilingTemp = 212;
         freezingTemp = 32;
      }
      else{
         boilingTemp = 100;
         freezingTemp = 0;         
      }
      System.out.print("The water is currently...");
      
      //You finish the rest!
      if (temp <= freezingTemp)            
         System.out.println(" solid!");
      else if (temp >= boilingTemp)
         System.out.println(" gas!"); 
      else
         System.out.println(" liquid!");
      
      
      */     
      




      


      //2.2.6 - Same Rightmost Digit ============================================

      
      
    
       /* 
             
      int num1 = 47;
      int num2 = 1207;
      
            
      
      System.out.print("Same rightmost digit for " + num1 + ", " + num2 + "?: ");
      System.out.println(num1%10 == num2%10);
      
      //Complete the code above.  You can edit whatever you like, but you may 
      //only add **one** new additional line of code and NO CONDITIONAL (ie if/else statement)
      
      
      */
      
      


      //2.2.7 - Ice Cream Recommender ============================================

      
      
    
       /*
       
      int chocPref = 5;
      int vanPref = 9;
      boolean isVegan = false;
      
      
      //You complete the rest!
      System.out.print("We recommend ");
      if (isVegan)
         System.out.println("lemon sorbet!");
      else if (chocPref <= 2 || vanPref <= 2)
         System.out.println("strawberry!");
      else if (vanPref >= 8){
         if (chocPref >= 8)
            System.out.println("chocolate-vanilla twist!");
         else
            System.out.println("vanilla!");
      }
      else if (chocPref >= 8)
         System.out.println("chocolate!");
      else 
         System.out.println("neopolitan!");
      
      */
      
   }
   
   
}
public class Lab02Client{





    public static void main(String[] args){

        System.out.println("Hello World! You're ready for Lab 02!");

        //Below are the test cases provided to you in the lab writeup.
        //They are NOT SUFFICIENT!  You must add tests of your own
        //This will make up part of your lab grade!


        //*****  2.1 Tests  *****
       
        
        
        
        System.out.println("\n\n*** Order Of The Number ***");
        int num = 153;
        System.out.print("(The order of " + num + " ) -> ");
        System.out.println(Lab02Code.checkOrder(num));

        num = 0;
        System.out.print("(The order of " + num + " ) -> ");
        System.out.println(Lab02Code.checkOrder(num));

        num = -153;
        System.out.print("(The order of " + num + " ) -> ");
        System.out.println(Lab02Code.checkOrder(num));
        
        



        //*****  2.2 Tests  *****

        
                
        System.out.println("\n\n*** Raise To The Power ***");
        
        int base = 5;
        int pow = 3;   
        System.out.print("(" + base + " raised to the power of " + pow + ") -> ");
        System.out.println(Lab02Code.getPower(base, pow));
        
        base = 0;
        pow = 3;   
        System.out.print("(" + base + " raised to the power of " + pow + ") -> ");
        System.out.println(Lab02Code.getPower(base, pow));

        base = 2;
        pow = 5;   
        System.out.print("(" + base + " raised to the power of " + pow + ") -> ");
        System.out.println(Lab02Code.getPower(base, pow));


        //*****  2.3 Tests  *****

        
                 
        System.out.println("\n\n*** Is It Armstrong Number ***");
        
        int num1 = 153;
        int order = Lab02Code.checkOrder(num1);

        System.out.print("(Is " + num1 + " with the order of " + order + " an armstrong number) -> ");
        System.out.println(Lab02Code.isArmstrongNumber(num1, order));
        
        num1 = 132;
        order = Lab02Code.checkOrder(num1); 
        System.out.print("(Is " + num1 + " with the order of " + order + " an armstrong number) -> ");
        System.out.println(Lab02Code.isArmstrongNumber(num1, order));

        num1 = 1634;
        order = Lab02Code.checkOrder(num1); 
        System.out.print("(Is " + num1 + " with the order of " + order + " an armstrong number) -> ");
        System.out.println(Lab02Code.isArmstrongNumber(num1, order));

        num1 = 407;
        order = Lab02Code.checkOrder(num1); 
        System.out.print("(Is " + num1 + " with the order of " + order + " an armstrong number) -> ");
        System.out.println(Lab02Code.isArmstrongNumber(num1, order));

        //*****  2.4 Tests  *****
        
          
        System.out.println("\n\n*** Num Reverse ***");
        
        int num2 = 5462;
        System.out.println("(" + num2 + ") --> " + Lab02Code.numReverse(num2));        
        
        num2 = 120;
        System.out.println("(" + num2 + ") --> " + Lab02Code.numReverse(num2));    
     
        num2 = -928;
        System.out.println("(" + num2 + ") --> " + Lab02Code.numReverse(num2));    

        num2 = 0;
        System.out.println("(" + num2 + ") --> " + Lab02Code.numReverse(num2));    
        
        //*****  2.5 Tests  *****
        
        
        System.out.println("\n\n*** Roll Chance ***");
        
        int dieSides1 = 6;
        int sum1 = 12;
        int rolls1 = 10000;
        System.out.print("(" + dieSides1 + ", " + sum1 + ", " + rolls1 + ") -> ");
        System.out.println(Lab02Code.rollChance(dieSides1, sum1, rolls1));        
        
        dieSides1 = 20;
        sum1 = 17;
        rolls1 = 10000;
        System.out.print("(" + dieSides1 + ", " + sum1 + ", " + rolls1 + ") -> ");
        System.out.println(Lab02Code.rollChance(dieSides1, sum1, rolls1)); 
        
        dieSides1 = -1;
        sum1 = 12;
        rolls1 = 10000;
        System.out.print("(" + dieSides1 + ", " + sum1 + ", " + rolls1 + ") -> ");
        System.out.println(Lab02Code.rollChance(dieSides1, sum1, rolls1)); 

        dieSides1 = 6;
        sum1 = 12;
        rolls1 = 10000000;
        System.out.print("(" + dieSides1 + ", " + sum1 + ", " + rolls1 + ") -> ");
        System.out.println(Lab02Code.rollChance(dieSides1, sum1, rolls1)); 


        //*****  2.6 Tests  *****
        
        
        System.out.println("\n\n*** Most Divisible  ***");
        int bound1_1 = 22;
        int bound2_1 = 28;
        System.out.print(bound1_1 + ", " + bound2_1 + " -> ");
        System.out.println(Lab02Code.mostDivisible(bound1_1, bound2_1));
        
        bound1_1 = 28;
        bound2_1 = 22;
        System.out.print(bound1_1 + ", " + bound2_1 + " -> ");
        System.out.println(Lab02Code.mostDivisible(bound1_1, bound2_1));

        bound1_1 = -2;
        bound2_1 = 28;
        System.out.print(bound1_1 + ", " + bound2_1 + " -> ");
        System.out.println(Lab02Code.mostDivisible(bound1_1, bound2_1));

        bound1_1 = 1000000;
        bound2_1 = 0;
        System.out.print(bound1_1 + ", " + bound2_1 + " -> ");
        System.out.println(Lab02Code.mostDivisible(bound1_1, bound2_1));

        bound1_1 = 1;
        bound2_1 = 100;
        System.out.print(bound1_1 + ", " + bound2_1 + " -> ");
        System.out.println(Lab02Code.mostDivisible(bound1_1, bound2_1));
        //...You finish the rest, and add tests of your own for each function!        
        

    }


}

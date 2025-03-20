/*
 Lab 04
 
 This client program uses MyFraction objects.
*/

public class MyFractionClient {

     
     public static void main(String[] args) {
          
          //**** 2.1.1 - 2.1.3:   Getting Started ****
          // construct a MyFraction object
          // NOTE: initially there's no constructor
          
          MyFraction fract1 = new MyFraction();
          System.out.println("fract1: " + fract1);

          //What do you think will be printed by the above?
          // for 2.1.1, it will print fract1 and the id for fract1
          // for 2.1.2 it will print fract1: MyFraction = (0/0)
          // for 2.1.2 it will print fract1: MyFraction = (0/1)
          
          
          
          
          //**** 2.1.4 Second Constructor ****
          //Create a second constructor in MyFraction which takes 2 args!     
          //Test that below     
          MyFraction fract2 = new MyFraction(1,2);
          System.out.println("fract2: " + fract2);
          
          
          
          
          //**** 2.1.5 Zero Denominator Safeguard ****
          //Implement and test a safeguard so that a MyFraction can never
          //have a 0 denominator (should throw an Exception)
          
          // MyFraction fract0 = new MyFraction(1,0);
          // System.out.println("fract0: " + fract0);


          //**** 2.1.7 Third Constructor ****
          //Create a third constructor in MyFraction which takes 1 arg!     
          //Test that below     
          MyFraction fract3 = new MyFraction(7);
          System.out.println("fract3: " + fract3);

          

          
          
          
          
          
          
          
          
          //**** 2.2.1 Retrieve Individual Attributes ****
          //Uncomment the print statements below and try to compile/run
          //fix the issue WITHOUT modifying MyFraction.java!
          
          
           MyFraction fract5 = new MyFraction(3, 5);
           System.out.println("fract5's numerator is: " + fract5.getNum());
           System.out.println("fract5's denominator is: " + fract5.getDenom());
          
          
          
          
      
          
          
          
          //**** 2.2.2 Get Decimal Value ****
          //Fix the syntax error(s) in MyFraction's convertToDouble(...) method and test it!
          System.out.println("\nfract1 as a double: "+ fract1.convertToDouble());
          System.out.println("fract5 as a double: " + fract5.convertToDouble());
          System.out.println("fract3 as a double: "+ fract3.convertToDouble());

          
          
          
          
          
          
          
          
          //**** 2.2.3 Is Whole Number ****
          //Create test cases to check your isWholeNumber() while and after implementing it:
          
          System.out.println("\nfract1 is whole? " + fract1.isWholeNumber());
          System.out.println("fract2 is whole? " + fract2.isWholeNumber());
          System.out.println("fract3 is whole? " + fract3.isWholeNumber());


          


          
          
          //**** 2.3.1 Fractions that aren't the same don't look the same! ****
          //Uncomment the code below and observe what happens
          
          
          MyFraction f1 = new MyFraction(-6, 4);
          MyFraction f2 = new MyFraction(3, -2);
          
          System.out.println(f1 + " and " + f2);
          System.out.println(f1.equals(f2));
          
          
          



          //**** 2.3.2 Normalize ****
          //Create test cases to check your normalize() while and after implementing it:
          
          MyFraction f3 = new MyFraction(-4, -4);
          MyFraction f4 = new MyFraction(128, 4);
          
          System.out.println(f3 + " and " + f4);



          // When it's implemented properly, the example code above for 2.3.1
          // should show that f1 and f2 are the same!
          
          
          
          //**** 2.3.4 Invert ****
          //Uncomment the code snippet below, predict what will happen, and run it
          
          
          MyFraction mf1 = new MyFraction(2, -7);
          MyFraction mf2 = mf1.createInvert();
          System.out.println(mf1 + " inverted is " + mf2);

          // MyFraction mf3 = new MyFraction(0, 5);
          // MyFraction mf4 = mf3.createInvert();
          // System.out.println(mf3 + " inverted is " + mf4);
          
          
          
          

                   
     }
}

//A MyFraction is an abstraction of a fraction number
public class MyFraction {
  
     /******** Instance variables  *******/   
          
       
     //Each MyFraction has a numerator (top number) and 
     //   denominator (bottom number) as attributes
     private int numerator;                               
     private int denominator;                             
     

     /*******  toString  ********/
     //Uncomment for 2.1.2:
     
     public String toString() {
          return "MyFraction = (" + this.numerator + "/" + this.denominator + ")";
     }
     


     /******** Constructors  *******/   
     
     //No argument constructor
     //Makes the default fraction 0/1
     //Try uncommenting me for 2.1.3!

     
     public MyFraction(){
        this(0,1);
     }
     
     
     
     //For 2.1.4: Add a second constructor which takes 2 arguments
     
     public MyFraction(int numerator, int denominator){
        this.numerator = numerator;
        if(denominator == 0)
            throw new ArithmeticException("The denominator can't be 0");
        this.denominator = denominator;
        normalize();
    }
     
    
     //For 2.1.7: Add a third constructor which takes 1 argument
     // This constructor can be used for whole numbers
     // Add declaration and implementation below!
     
     public MyFraction(int numerator){
        this(numerator,1);
    }
     

     /******** Accessing data  *******/   
     

     public int getNum(){
         return this.numerator;
     }
     
     public int getDenom(){
         return this.denominator;
     }
         




     /******** Instance methods  *******/   
     
     
     
     //*** For 2.2.2 ***
     //Returns the decimal value represented by this MyFraction object
     //ex: a MyFraction with a numerator= 4 and denominator= 5 would return 0.8
     
     
     public double convertToDouble(){
    
       return ((double) this.numerator) / this.denominator;       
       
     }
     
     
     
     

     //**** 2.2.3 Is Whole Number ****
     //Returns a boolean indicating if the referenced MyFraction represents a whole 
     //number (true) or not (false).  Implement me below!:
     
     public boolean isWholeNumber(){
        if(convertToDouble() % 1 == 0)
            return true;
        return false;
     }
     
     

     
     //**** 2.3.2 Normalize ****
     //Ensures that:
     //  (1) The numerator and denominator are stored in a most reduced form
     //  (2) If the fraction is negative, the numerator (and not denominator) is negative
     private void normalize() {
        int diff = gcd(numerator, denominator);
        numerator /= diff;
        denominator /= diff;
        if(denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }
     }

    // Helper function to be used in 2.3.1
    // Returns the greatest common divisor of two integer arguments a and b.
    // This is the largest number that divides both.
    // NOTE: this is a static helper function.
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }


          
     
     //*** For 2.3.4 ***
     // Return a new fraction that is the reciprocal of the one this method is called on.
     // This means the numerator and denominator are swapped relative to what they are now.
     // For example, if called on 5/7, this should return something representing 7/5
     // If called on -2/3, this should return -3/2
     public MyFraction createInvert(){
     
        /* This implementation should be improved. Fix me! */
     
        MyFraction f = new MyFraction(denominator, numerator);
        return f;
       
     }
     
     
     
    // Checks if two fractions are equal -- no need to modify this.
     public boolean equals(Object other) {
        if (other instanceof MyFraction) {
            MyFraction f = (MyFraction) other;
            return (f.numerator == this.numerator &&
                    f.denominator == this.denominator);
        }
        return false;
     }
     
}

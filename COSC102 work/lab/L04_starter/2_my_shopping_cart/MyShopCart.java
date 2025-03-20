// Each MyShopCart object represents one user's purchase on our
// webstore, including customer name and subtotal

public class MyShopCart {
    

    private String name;
    private double subtotal;
    private boolean isTaxExempt;
    private double savings = 0; 

    private static final int minimumNameLength = 5;
    public static final int minimumShipping = 50;
    public static final double minimumItemPrice = 0.99;
    private static final int shippingFee = 5;
    public static final double tax = 0.08;


    // constructor for MyShopCart object
    public MyShopCart(String _name, boolean exempt){
        if(! _name.contains(" ") || _name.length() < minimumNameLength)
            name = "Default Customer";
        else
            name = _name;
        isTaxExempt = exempt;
        subtotal = 0;
    }
    
    //Adds an item to the cart, increasing the subtotal
    public void addItemToCart(double price){
        if(price >= minimumItemPrice)
            subtotal += price;       
    }
    
    //Applies a coupon to the cart, decreasing the subtotal
    public void applyCoupon(double couponAmount){
        if(couponAmount > 0 && subtotal - couponAmount >= 0){
            subtotal -= couponAmount;
            savings += couponAmount;       
        }
    }
        

    
    //returns the cart's final total, which 
    //is the subtotal with the sales tax applied
    public double calcFinalTotal(){
        double sub = getSubtotal();
        if(! isTaxExempt)
            sub *= (1 + tax);
        if(sub < minimumShipping)
            sub += shippingFee;
        return sub;

    }
    
    // prints the whole line about the object's details
    // including the subtotal, final total, tax exemption status, and savings made
    public String toString(){
        String line = getName() + " Subtotal: " + getSubtotal() + ", Final Total: " + calcFinalTotal();
        double saved = calcTotalSavings();
        if(saved > 0)
            line += ", (Saved: $" + saved + "!)";
        if(isTaxExempt()){
            return "[TAX EXEMPT] "+ line;
        }
        return line;
    }

    // returns the total savings made
    public double calcTotalSavings(){
        if(subtotal >= minimumShipping)
            return savings + shippingFee;
        return savings;
    }
    
    // attempts to split the bill in half with another 
    // cart object and returns if it was successful
    public boolean splitCartBill(MyShopCart other){
        double splitCost;
        if((isTaxExempt && other.isTaxExempt()) || (! isTaxExempt && ! other.isTaxExempt())){
            if(savings == 0){
            splitCost = subtotal /= 2;
            other.addItemToCart(splitCost);
            return true;
            }
        }
        return false;

    }

    //Accessor methods------------
    public double getSubtotal(){
        return this.subtotal;
    }
    
    public String getName(){
        return this.name;
    }

    public boolean isTaxExempt(){
        return this.isTaxExempt;
    }
    //----------------------------


}

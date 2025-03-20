/*
 Lab 04
 
 This client program uses MyShopCart objects.
*/

public class MyShopCartClient {
     
    //create a MAIN METHOD with test cases here!
    public static void main(String[] args) {
        MyShopCart cart = new MyShopCart("Andrew", false);
        cart.addItemToCart(10);
        cart.addItemToCart(0.98);
        cart.addItemToCart(20);
        cart.addItemToCart(10);
        cart.applyCoupon(0);
        cart.applyCoupon(-10);
        cart.applyCoupon(10);

        System.out.println(cart);

        MyShopCart cart2 = new MyShopCart("Andy", true);
        cart2.addItemToCart(100);
        System.out.println(cart2);
        
        System.out.println("\nBefore split \ncart's total: " + cart.calcFinalTotal());
        System.out.println("cart2's total: " + cart2.calcFinalTotal());
        System.out.println("Did cart split with cart2? " + cart.splitCartBill(cart2));
        System.out.println("cart's total: " + cart.calcFinalTotal());
        System.out.println("cart2's total: " + cart2.calcFinalTotal());

        System.out.println("\nBefore split \ncart's total: " + cart.calcFinalTotal());
        System.out.println("cart2's total: " + cart2.calcFinalTotal());
        System.out.println("Did cart2 split with cart? " +cart2.splitCartBill(cart));
        System.out.println("cart's total: " + cart.calcFinalTotal());
        System.out.println("cart2's total: " + cart2.calcFinalTotal());

        MyShopCart cart3 = new MyShopCart("Brother", true);
        
        System.out.println("\nBefore split \ncart3's total: " + cart3.calcFinalTotal());
        System.out.println("cart2's total: " + cart2.calcFinalTotal());
        System.out.println("Did cart2 split with cart3? " +cart2.splitCartBill(cart3));
        System.out.println("cart3's total: " + cart3.calcFinalTotal());
        System.out.println("cart2's total: " + cart2.calcFinalTotal());


    }
    


  
  
  
  
}

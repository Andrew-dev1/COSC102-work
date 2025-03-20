import java.util.Calendar;

public class MyVehicle{
    
    private static final String DEFAULT_NAME = "DEFAULT_NAME";
    // ... add more of your own!
    private final String vehicleOwner;
    private static int nextID = 600;
    private final int ID;
    private int expMonth; 
    private int expYear;
    private int vehicleMPG; 
    private double vehicleGasCap; 
    private double mileage;
    private double remainingGas = 0;
    private double gasExpenses;
    private static double gasPrice = 3.1; // between 2.00-5
    

    public MyVehicle(String name, int expirationMonth, int expirationYear, int mpg, double gasTankCapacity){
        if(name.length() >= 4)
            vehicleOwner = name;
        else
            vehicleOwner = DEFAULT_NAME;
        ID = nextID;
        nextID += 1;
        mileage = 0;
        if(expirationMonth > 0 && expirationMonth < 13){
            expMonth = expirationMonth;
        }
        else{
            expMonth = getCurrentMonth();
        }
        int year = getCurrentYear();
        if(expirationYear <= year +3 && expirationYear >= year-3)
            expYear = expirationYear;
        else
            expYear = year;
        
        if(mpg >= 20 && mpg <= 60)
            vehicleMPG = mpg;
        else 
            vehicleMPG = 30;

        if(gasTankCapacity >= 15.0 && gasTankCapacity <= 45.0)
            vehicleGasCap = gasTankCapacity;
        else 
            vehicleGasCap = 25.0;
    }

    public MyVehicle(String name, int expirationMonth, int expirationYear){
        this(name, expirationMonth, expirationYear, 0, 0);
    }

    public MyVehicle(String name){
        this(name, 0, 0, 0, 0);
    }

    public String toString(){
        String line = "[Vehicle #" + ID + " ] Owner: " + vehicleOwner + ", Mileage: " + roundDecimalPlaces(getMileage(), 1) + " miles, Gas Expenses: $";
        return line + roundDecimalPlaces(getGasExpenses(), 2) + ", Reg Expires: " + expMonth + "/" + expYear;
    }

    public static boolean setGasPrice(double price){
        if(price >= 2.00 & price <= 5 ){
            gasPrice = price;
            return true;
        }
        return false;
    }

    public double costToFill(){
        double gasDifference = getGasTankCapacity() - getRemainingGas();
        return roundDecimalPlaces(gasDifference * gasPrice, 2);
    }

    public boolean addGas(double prepayDollarAmount){
        if(prepayDollarAmount <= 0 || prepayDollarAmount > 100 || getRemainingGas() == getGasTankCapacity())
            return false;

        double gas = prepayDollarAmount/ gasPrice;
        if(gas + getRemainingGas() <= getGasTankCapacity()){
            gasExpenses += prepayDollarAmount;
            remainingGas += gas;
        }
        else{
            gasExpenses += costToFill();
            remainingGas = vehicleGasCap;
        }
        return true;
    }

    public double milesRemaining(){
        return getRemainingGas() * getMPG();
    }

    public boolean drive(double miles){
        boolean notExpired = getExpirationMonth() <= getCurrentMonth() && getExpirationYear() <= getCurrentYear();
        if(! notExpired || miles <= 0){
            return false;
        }
        if(miles >= milesRemaining()){
            mileage += milesRemaining();
            remainingGas = 0;
        }
        else{
            mileage += miles;
            remainingGas -= miles/getMPG();
        }
        return true;

    }
    public boolean isEligibleForRenewal(){
        return isEligibleForRenewal(this.expMonth, this.expYear);
        
    }

    public static boolean isEligibleForRenewal(int expMonth, int expYear){
        int month = getCurrentMonth(); 
        int year = getCurrentYear();
        if(month + 6 > 12){
            return(month-6 <= expMonth && expMonth <= 12 && year == expYear ) || (expMonth <= month-6 && year +1 == expYear);
        }
        else{
            return (month+6 >= expMonth && expMonth >= 1 && year == expYear) || (expMonth >= month+6 && year-1 == expYear);
        }
        
    }

    public boolean renewRegistration(){
        if(isEligibleForRenewal()){
            expYear += 2;
            return true;
        }
        return false;
    }

    public static MyVehicle compareAverageCostsPerMile(MyVehicle v1, MyVehicle v2){
        double v1Cost = (gasPrice) / (v1.getMPG());
        double v2Cost = gasPrice / v2.getMPG();
        if(v1Cost < v2Cost)
            return v1;
        else if (v2Cost > v1Cost)
            return v2;
        return null;
    }

    /*
     * *************************************
     * ***** PROVIDED HELPER FUNCTIONS *****
     * *************************************
     */
    
    // returns the current month as a number between 1-12 (January-December)
    public static int getCurrentMonth() {
        Calendar currentDate = Calendar.getInstance();
        return currentDate.get(currentDate.MONTH) + 1;
    }

    // returns the current year
    public static int getCurrentYear() {
        Calendar currentDate = Calendar.getInstance();
        return currentDate.get(currentDate.YEAR);
    }

    // rounds a number to n decimal places
    public static double roundDecimalPlaces(double num, int n) {
        return Math.round(num * Math.pow(10, n)) / Math.pow(10, n);
    }

    // returns vehicle owner's name
    public String getName(){
        return vehicleOwner;
    }

    // returns vehicle's ID
    public int getID(){
        return ID;
    }

    // returns vehicle's expiration month
    public int getExpirationMonth(){
        return expMonth;
    }

    // returns vehicle's expiration year
    public int getExpirationYear(){
        return expYear;
    }

    // returns vehicle's mpg
    public int getMPG(){
        return vehicleMPG;
    }

    // returns vehicle's mileage
    public double getMileage(){
        return mileage;
    }

    // returns vehicle's remaining gas
    public double getRemainingGas(){
        return remainingGas;
    }

    // returns vehicle's gas tank capacity
    public double getGasTankCapacity(){
        return vehicleGasCap;
    }

    // returns vehicle's gas expenses
    public double getGasExpenses(){
        return gasExpenses;
    }

    // returns the gas price for the vehicles
    public static double getGasPrice(){
        return gasPrice;
    }
}
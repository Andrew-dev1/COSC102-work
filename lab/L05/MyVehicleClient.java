public class MyVehicleClient{

    public static void main(String[] args) {
        MyVehicle car1 = new MyVehicle("Vroom");
        MyVehicle car2 = new MyVehicle("Honk", 9,2024);
        MyVehicle car3 = new MyVehicle("Brrrr",2,2026, 45, 33.3);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

        /* 
        System.out.println("Testing changing gas prices");
        System.out.println("Gas price before attempt to change " + MyVehicle.getGasPrice() );
        System.out.println(MyVehicle.setGasPrice(0));
        System.out.println("Gas price after attempt to change " + MyVehicle.getGasPrice());
        
        System.out.println("\nGas price before attempt to change " + MyVehicle.getGasPrice() );
        System.out.println(MyVehicle.setGasPrice(5.0));
        System.out.println("Gas price after attempt to change " + MyVehicle.getGasPrice() );

        System.out.println("\nGas price before attempt to change " + MyVehicle.getGasPrice() );
        System.out.println(MyVehicle.setGasPrice(-3));
        System.out.println("Gas price after attempt to change " + MyVehicle.getGasPrice() );
        System.out.println();
        */

        System.out.println(car1.costToFill());
        System.out.println("Gas remaining before attempt to add " + car1.getRemainingGas());
        System.out.println("Gas expenses: " + car1.getGasExpenses());
        System.out.println(car1.addGas(100));
        System.out.println("Gas remaining after attempt to add " + car1.getRemainingGas());
        System.out.println("Gas expenses: " + car1.getGasExpenses());
        
        System.out.println("\nGas remaining before attempt to add " + car1.getRemainingGas());
        System.out.println("Gas expenses: " + car1.getGasExpenses());
        System.out.println(car1.addGas(100));
        System.out.println("Gas remaining after attempt to add " + car1.getRemainingGas());
        System.out.println("Gas expenses: " + car1.getGasExpenses());

        System.out.println("\nGas remaining before attempt to add " + car2.getRemainingGas());
        System.out.println("Gas expenses: " + car2.getGasExpenses());
        System.out.println(car2.addGas(20));
        System.out.println("Gas remaining after attempt to add " + car2.getRemainingGas());
        System.out.println("Gas expenses: " + car2.getGasExpenses());

        System.out.println("Remaining miles in car1: "+ car1.milesRemaining());
        System.out.println("Car mileage for car1: " + car1.getMileage());
        System.out.println("Attempting to drive 50 miles: " + car1.drive(50));

        System.out.println("\nRemaining miles in car1: "+ car1.milesRemaining());
        System.out.println("Car mileage for car1: " + car1.getMileage());
        System.out.println("Attempting to drive 1000000 miles: " + car1.drive(1000000));
        System.out.println("Car mileage for car1: " + car1.getMileage());
        System.out.println("Remaining miles in car1: "+ car1.milesRemaining());

        MyVehicle car4 = new MyVehicle("Bookie", 9,2023);
        System.out.println("\ncar4's expiration date--" + car4.getExpirationMonth() + "/" + car4.getExpirationYear());
        System.out.println("car4's eligibility for renewal: " + car4.isEligibleForRenewal());

        System.out.println("car2's expiration date--" + car2.getExpirationMonth() + "/" + car2.getExpirationYear());
        System.out.println("car2's eligibility for renewal: " + car2.isEligibleForRenewal());

        System.out.println("car3's expiration date--" + car3.getExpirationMonth() + "/" + car3.getExpirationYear());
        System.out.println("car3's eligibility for renewal: " + car3.isEligibleForRenewal());

        System.out.println("\nTesting for isEligibleForRenewal(month, year)");
        System.out.println("Is any vehicle renewable with expiration date of 1-2025? " + MyVehicle.isEligibleForRenewal(1, 2025));
        System.out.println("Is any vehicle renewable with expiration date of 9-2023? " + MyVehicle.isEligibleForRenewal(9, 2023));
        System.out.println("Is any vehicle renewable with expiration date of 8-2024? " + MyVehicle.isEligibleForRenewal(9, 2024));

        System.out.println("\ncar1's expiration date--" + car1.getExpirationMonth() + "/" + car1.getExpirationYear());
        System.out.println("Attempting to renew car1: " + car1.renewRegistration());
        System.out.println("car1's expiration date--" + car1.getExpirationMonth() + "/" + car1.getExpirationYear());

        System.out.println("\ncar2's expiration date--" + car2.getExpirationMonth() + "/" + car2.getExpirationYear());
        System.out.println("Attempting to renew car1: " + car2.renewRegistration());
        System.out.println("car2's expiration date--" + car2.getExpirationMonth() + "/" + car2.getExpirationYear());

        System.out.println("\ncar3's expiration date--" + car3.getExpirationMonth() + "/" + car3.getExpirationYear());
        System.out.println("Attempting to renew car1: " + car3.renewRegistration());
        System.out.println("car3's expiration date--" + car3.getExpirationMonth() + "/" + car3.getExpirationYear());

        System.out.println(car1 +"\ncar1's dollar per mile price is $" + (MyVehicle.getGasPrice()/ car1.getMPG()));
        System.out.println(car2 + "\ncar2's dollar per mile price is $ " + (MyVehicle.getGasPrice()/ car2.getMPG()));
        MyVehicle cheaperCar = MyVehicle.compareAverageCostsPerMile(car1, car2);
        System.out.println("The cheaper car is " + cheaperCar + "\n");

        System.out.println(car3 + "\ncar3's dollar per mile price is $" + (MyVehicle.getGasPrice()/ car3.getMPG()));
        System.out.println(car4 + "\ncar4's dollar per mile price is $ " + (MyVehicle.getGasPrice()/ car4.getMPG()));
        MyVehicle cheaperCar2 = MyVehicle.compareAverageCostsPerMile(car3, car4);
        System.out.println("The cheaper car is " + cheaperCar2 + "\n");

    }

}
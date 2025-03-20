public class Lab02Code{
     


    //Start with Problem 2.1 here!
    
    public static int checkOrder(int num){
        int digits = 1;
        if(num < 0)
            num *= -1;
        while(num > 9){
            num /= 10;
            digits +=1;
        }
        return digits;
    }

    public static int getPower(int base, int pow){
        int num = base;
        for(int i = 1; i< pow; i++){
            num *= base;
        }
        return num;
    }

    public static boolean isArmstrongNumber(int num, int order){
        int counter = 0;
        int numCopy = num;
        for(int i = 0; i < order; i++){
            int lastNum = numCopy%10;
            counter += getPower(lastNum, order);
            numCopy /= 10;
        }
        return counter==num ;
    }
    
    public static int numReverse(int num){
        int reverseInt = 0;
        if(num < 0){
            return -1;
        }

        while(num != 0){
            reverseInt *= 10; 
            reverseInt += num%10;
            num /= 10;
        }
        return reverseInt;
    }
    
    public static double rollChance(int dieSides, int sum, int rolls){
        double winChances = 0;
        int factor1 = 1;
        

        if(dieSides < 0 || sum < 0 || rolls <0 ){
            return -1.0;
        }
        while(factor1 <= rolls){
            int dice1 = (int) (Math.random() * dieSides)+1;
            int dice2 = (int) (Math.random() * dieSides)+1;
            if((dice1+ dice2) == sum)
                winChances += 1;
            factor1 += 1;
        }
        
        return winChances/rolls;
    }

    public static int mostDivisible(int bound1, int bound2){
        int maxDivisions = 0; 
        int maxNum = 0;
        int bigNum;
        int smallNum;

        if(bound1 < 1 || bound2 < 1 )
            return -1;
        else
        {
            int difference = (bound2 - bound1);
            if(difference > 0)
            {
                bigNum = bound2; smallNum = bound1;
            }
            else if (difference == 0)
                return bound1;
            else
            {
                bigNum = bound1; 
                smallNum = bound2;
            }
            
            // iterates through all numbers between both ends inclusively
            while(smallNum <= bigNum)
                {
                    double counter = 1; 
                    int divisible = 0;
                    // finds all factors of the current number
                    while(counter < smallNum)
                    {
                        if((smallNum % counter) == 0 )
                            divisible += 1;
                        counter += 1;
                    }

                    // replaces the number with the one having the most factors 
                    if(divisible > maxDivisions)
                    {
                        maxNum = smallNum;
                        maxDivisions = divisible;
                    }
                    smallNum += 1;
                }
                return maxNum;
             
                
            
        }
        
    }

}

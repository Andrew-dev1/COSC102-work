import java.util.Arrays;
// Team Members: Tara Tanis-Greene, Andrew Li

public class Lab03MemTrace{
   
   private static char[] ch = {'f', 'g', 'h', 'i'};
   private static int ct = 1;
   
   public static void main(String[] args){
      
      int[] num1 = {3, 5, 9, 7};
      int[] num2 = num1;
      
      int x = 1;
      int y = 7;
      x++;      
      num2[x] = y;  
      printOut(num1, num2, x); //Trace, write your expected output, then uncomment!
      num1 = mystery1(x, y, num2);      
      printOut(num1, num2, x); //Trace, write your expected output, then uncomment!
      for (int i = 0; i < x; i++)
         num2[i] += y;
      printOut(num1, num2, y); //Trace, write your expected output, then uncomment!
   }
   
   
   public static void printOut(int[] arg1, int[] arg2, int arg3){
      System.out.println("***Call #" + ct + " to printOut(...)***");
      System.out.println("arg1  = " + Arrays.toString(arg1));
      System.out.println("arg2  = " + Arrays.toString(arg2));
      System.out.println("arg3  = " + arg3);
      System.out.println("ch    = " + Arrays.toString(ch) + "\n\n");      
      ct++;
   }      
   
   
   public static int[] mystery1(int y, int x, int[] num1){
      int[] newNums = new int[num1.length];
      for (int i = 0; i < 3; i++){
         newNums[i] = y * x;
         y -= 2;
      }
      int count = 0;
      for (int j = 0; j < newNums.length; j++){
         newNums[j] = Math.max(newNums[j], num1[j]);
         count += j;
      }
      printOut(num1, newNums, count); //Trace, write your expected output, then uncomment!
      mystery2(num1, count);
      return newNums;         
   }
   
         
   public static void mystery2(int[] num2, int count){
      for (int i = 0; i < ch.length; i++){
         ch[i] += (count + num2[i]);
         count *= -1;         
      }
   }
    
   
}

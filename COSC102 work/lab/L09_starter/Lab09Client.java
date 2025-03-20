
public class Lab09Client{
   
   
   public static void main(String[] args){
      
      
      //*** SMALLEST TO TOP TESTS ***
  
      LabStack<Integer> stt1 = new LabStack<Integer>();
      stt1.push(3);
      stt1.push(1);
      stt1.push(6);
      stt1.push(2);        
      stt1.push(4);
      stt1.push(7);
      stt1.push(3);
      stt1.push(9);
      System.out.println("Test 1 for smallest to top");
      System.out.println("LabStack before: " + stt1);
      Lab09.smallestToTop(stt1);
      System.out.println("LabStack after: " + stt1);   
      
      
      LabStack<Integer> stt2 = new LabStack<Integer>(new Integer[] {5,7,8,-1, 0, 200, -1000, 500});
      System.out.println("\nTest 2 for smallest to top");
      System.out.println("LabStack before: " + stt2);
      Lab09.smallestToTop(stt2);
      System.out.println("LabStack after: " + stt2);  

      
      LabStack<Integer> stt3 = new LabStack<Integer>();
      System.out.println("\nTest 3 for smallest to top");
      System.out.println("LabStack before: " + stt3);
      Lab09.smallestToTop(stt3);
      System.out.println("LabStack after: " + stt3);  
      
      
      //*** BRING TO FRONT TESTS ***
     
      String[] names1 = {"Cecil", "Golbez", "Rydia", "Cid", "Tellah"};
      LabQueue<String> btf1 = new LabQueue<String>(names1);    

      System.out.println("\nTesting bringing index 2 to front");
      System.out.println("LabQueue before: " + btf1);
      Lab09.bringToFront(btf1, 2);
      System.out.println("LabQueue after: " + btf1);

      System.out.println("\nTesting bringing index 0 to front");
      System.out.println("LabQueue before: " + btf1);
      Lab09.bringToFront(btf1, 0);
      System.out.println("LabQueue after: " + btf1);

      System.out.println("\nTesting bringing index 5 to front");
      System.out.println("LabQueue before: " + btf1);
      Lab09.bringToFront(btf1, 5);
      System.out.println("LabQueue after: " + btf1);
      
     
      
      
      
      
      
      
      //*** MIRRORED POSITIVES TESTS ***
      //create your tests here!      

      Integer[] numbers = {0,-1, 1, 13,4,13};
      LabQueue<Integer> mp1 = new LabQueue<Integer>(numbers);

      System.out.println("\nTest 1 if mirrored positive");
      System.out.println("LabQueue: " + mp1);
      System.out.println("Is this one mirrored? " + Lab09.mirroredPositives(mp1));
      
      System.out.println("\nTest 2 if mirrored positive");
      mp1.enqueue(1);
      System.out.println("LabQueue: " + mp1);
      System.out.println("Is this one mirrored? " + Lab09.mirroredPositives(mp1));

      Integer[] nums = {17, 4, 8, 9,8,4, -12, 17};
      LabQueue<Integer> mp2 = new LabQueue<Integer>(nums);
      System.out.println("\nTest 3 if mirrored positive");
      System.out.println("LabQueue: " + mp2);
      System.out.println("Is this one mirrored? " + Lab09.mirroredPositives(mp2));

      Integer[] num2 = {12, 2,6, 12};
      LabQueue<Integer> mp3 = new LabQueue<Integer>(num2);
      System.out.println("\nTest 4 if mirrored positive");
      System.out.println("LabQueue: " + mp3);
      System.out.println("Is this one mirrored? " + Lab09.mirroredPositives(mp3));

      Integer[] num3 = {0, -5, 13, 8, 13};
      LabQueue<Integer> mp4 = new LabQueue<Integer>(num3);
      System.out.println("\nTest 5 if mirrored positive");
      System.out.println("LabQueue: " + mp4);
      System.out.println("Is this one mirrored? " + Lab09.mirroredPositives(mp4));

      LabQueue<Integer> mp5 = new LabQueue<Integer>();
      System.out.println("\nTest 6 if mirrored positive");
      System.out.println("LabQueue: " + mp5);
      System.out.println("Is this one mirrored? " + Lab09.mirroredPositives(mp5));
      
      //*** GET COMMON NUMS TESTS ***
      //create your tests here!

      Integer[] ordered1 = {2,4,8,10,12};
      Integer[] ordered2 = {-5,0, 2,7,18};

      LabQueue<Integer> gcn1 = new LabQueue<Integer>(ordered1);
      LabQueue<Integer> gcn2 = new LabQueue<Integer>(ordered2);

      System.out.println("\nTest 1 for common numbers");
      System.out.println("LabQueue 1: " + gcn1);
      System.out.println("LabQueue 2: " + gcn2);
      System.out.println("The common numbers are: " + Lab09.getCommonNums(gcn1,gcn2));

      gcn1.enqueue(18);
      gcn1.enqueue(23);
      gcn1.enqueue(59);
      System.out.println("\nTest 2 for common numbers");
      System.out.println("LabQueue 1: " + gcn1);
      System.out.println("LabQueue 2: " + gcn2);
      System.out.println("The common numbers are: " + Lab09.getCommonNums(gcn1,gcn2));

      LabQueue<Integer> gcnblank = new LabQueue<Integer>();
      System.out.println("\nTest 3 for common numbers");
      System.out.println("LabQueue 1: " + gcn1);
      System.out.println("LabQueue 2: " + gcnblank);
      System.out.println("The common numbers are: " + Lab09.getCommonNums(gcn1,gcnblank));
      
      LabQueue<Integer> gcn3 = new LabQueue<Integer>( new Integer[] {-1,2,3,4,5,6,7,10,23});
      LabQueue<Integer> gcn4 = new LabQueue<Integer>(new Integer[] {-1,0,1,2,3,4,5,7,23});

      System.out.println("\nTest 4 for common numbers");
      System.out.println("LabQueue 1: " + gcn3);
      System.out.println("LabQueue 2: " + gcn4);
      System.out.println("The common numbers are: " + Lab09.getCommonNums(gcn3,gcn4));

      
      
   }
}
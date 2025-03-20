import java.util.*;

public class Lab09{
     

          
    //Moves the biggest integer in the Stack to the top
    //while keeping all other values in their original position.
    //If multiple values are tied for biggest, moves the bottommost
    //value up.
    public static void smallestToTop(LabStack<Integer> s){
        if(s.isEmpty())
            return;
        Integer smallestNum = Integer.MAX_VALUE;
        LabStack<Integer> stack = new LabStack<Integer>();
        // iterates through the stack once to find the smallest number and stores reversed stack temporarily
        while(!s.isEmpty()){
            Integer num = s.pop();
            if(smallestNum > num){
                smallestNum = num;
            }
            stack.push(num);
        }
        
        // stores the smallest one as the temporary stack is reversed
        LabStack<Integer> smallest = new LabStack<Integer>();
        while(!stack.isEmpty()){
            Integer num = stack.pop();
            if(num == smallestNum){
                smallest.push(num);
            }
            else
                s.push(num);
        }

        // adds smallest number to end of the stack
        s.push(smallest.pop());
    }
    
    // brings the string at the requested index to the front 
    public static void bringToFront(LabQueue<String> q, int index){
        // input validation 
        if(q.size() == 0 || index <= 0 || index >= q.size()){
            return;
        }
        String target = ""; 
        int size = q.size();
        
        // looks for the string at the targetted index and saves it
        for(int i = 0; i < size; i++){
            if(i == index)
                target = q.dequeue();
            else{
                String temp = q.dequeue();
                q.enqueue(temp);
            }
        }
        // adds string to end of the queue and pushes all values in front of it to the back of the queue
        q.enqueue(target);
        for(int i = 0; i < size-1; i++){
            String temp = q.dequeue();
            q.enqueue(temp);
            
        }

    }

    public static boolean mirroredPositives(LabQueue<Integer> q){

        LabStack<Integer> stack = new LabStack<Integer>();
        LabStack<Integer> mirror = new LabStack<Integer>();
        int counter = countAndMovePositives(q,stack);

        for(int i = 0; i < counter/ 2; i ++){
            Integer temp = stack.pop();
            mirror.push(temp);
        }
        if(counter% 2 == 1){
            stack.pop();
        }

        while(!stack.isEmpty()){
            if(stack.pop() != mirror.pop())
                return false;
        }


        return true;
    }

    // takes in a queue and empty stack. Counts and moves all positives into the empty stack and returns the count
    public static int countAndMovePositives(LabQueue<Integer> q, LabStack<Integer> stack){
        if(!stack.isEmpty()){
            throw new IllegalArgumentException("LabStack should be empty");
        }
        int counter = 0;
        for(int i = 0; i < q.size(); i ++){ 
            Integer num = q.dequeue();
            if(num > 0){
                stack.push(num);
                counter ++;
            }
            q.enqueue(num);
        }
        return counter;
    }


    // accepts two lab queues and returns a lab queue that only has a set of duplicate numbers
    public static LabQueue<Integer> getCommonNums(LabQueue<Integer> arg1, LabQueue<Integer> arg2){
        if(arg1.size() == 0 || arg2.size() == 0)
            return null;

        LabQueue<Integer> extraSet = createMergedLabQueue(arg1, arg2);            

        // checks merged, ordered queue for any duplicates and adds if there are
        for(int i = 0; i < arg1.size() + arg2.size(); i++){
            int num = extraSet.dequeue();
            boolean add = false;
            while(extraSet.peek() == num){
                extraSet.dequeue();
                add = true;
                i++;
            }
            if(add)
                extraSet.enqueue(num);
        }


        return extraSet;
    }

    // merges the two lab queues into a new lab queue with all the numbers in an ordered manner
    public static LabQueue<Integer> createMergedLabQueue(LabQueue<Integer> arg1, LabQueue<Integer> arg2){
        LabQueue<Integer> extraSet = new LabQueue<Integer>();
            
        int k = 0;
        int count1 = 0;
        int count2 = 0;

        while(k < arg1.size() + arg2.size()){
            int peek1 = arg1.peek();
            int peek2 = arg2.peek();
            if(peek1 < peek2){
                addOneFromQueue(arg1,extraSet);
                count1 ++;
            }
            else{
                addOneFromQueue(arg2,extraSet);
                count2++;
            }

            if(count1 == arg1.size()){
                while(count2 < arg2.size()){
                    addOneFromQueue(arg2,extraSet);
                    count2++;
                }
                break;
            }
            else if(count2 == arg2.size()){
                while(count1 < arg1.size()){
                    addOneFromQueue(arg1,extraSet);
                    count1++;
                }
                break;
            }
            k++;   
        }
        return extraSet;
    }
    
    // adds one number from the first lab queue into the second lab queue 
    public static void addOneFromQueue(LabQueue<Integer> original, LabQueue<Integer> extraSet){
        int num = original.dequeue();
        original.enqueue(num);
        extraSet.enqueue(num);
    }
    
     
     
}

public class Launcher{
  
  //Set to true to enable debug mode
  //Debug mode will draw RED SQUARES to show the approximate
  //locations of each time the ball will hit a wall and where
  //it will be when it reaches the paddle.
  public static final boolean ASSIST_MODE = true;  
  

   
  //Run this to launch the JPong Game!
  public static void main(String[] args){
         
    //Change these two values to test your different paddles!
    HumanPaddle p1 = new HumanPaddle();
    CPUPaddle p2 = new CPUBasic();
    CPUChallenging p3 = new CPUChallenging();
    CPUGenius p4 = new CPUGenius();
    CreativeHuman p5 = new CreativeHuman();
    CreativeCPU p6 = new CreativeCPU(p5);
    //*******************************************************
        
    JPong game = new JPong(p5, p6);
    
    game.playGame();
  }
  

  
  
}
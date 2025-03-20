import java.awt.Color;

// CHallenging CPU Paddle
public class CPUChallenging extends CPUBasic{

    //CPU Challenging Paddle attributes
    public static final double CPU_CHALLENGING_PADDLE_LENGTH = 75.0;
    public static final double CPU_CHALLENGING_PADDLE_SPEED = 3.0;
    public static final Color CPU_CHALLENGING_PADDLE_COLOR = Color.orange; 
    public double predicted;
         
   
    //****************   CONSTRUCTORS  *************
    public CPUChallenging(){
      this(CPU_CHALLENGING_PADDLE_LENGTH, CPU_CHALLENGING_PADDLE_SPEED, CPU_CHALLENGING_PADDLE_COLOR);
    }
   
    public CPUChallenging(double length, double speed, Color color){ 
      super(length, speed, color);
    } 

   protected int reactBallMovingLeft(double bX, double bY, double bXVel, double bYVel){
      // resets the predicted region so the paddle can recalculate once the ball starts returning right
      if(predicted != 0)
         predicted = 0;
      return super.reactBallMovingRight(bX, bY, bXVel, bYVel);
   }

    protected int reactBallMovingRight(double bX, double bY, double bXVel, double bYVel){

        double paddleY = this.getY();
        // predicts the spot the ball will land at once and changes the state of prediction 
        if(predicted== 0)
            predicted = TrigHelpers.calcTargetY(bX, bY, bXVel, bYVel, this.getX());

         // adjusts the position of the paddle until it reachs the predicted state
         if (Math.abs(predicted - paddleY) < MOVE_THRESHOLD)
            return MOVE_NEUTRAL;
         else if (paddleY < predicted)
            return MOVE_DOWN;
         else
            return MOVE_UP;    
     }
    
}

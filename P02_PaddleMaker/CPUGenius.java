import java.awt.Color;

public class CPUGenius extends CPUChallenging {
    //CPU Challenging Paddle attributes
    public static final double CPU_GENIUS_PADDLE_LENGTH = 25.0;
    public static final double CPU_GENIUS_PADDLE_SPEED = 3.0;
    public static final Color CPU_GENIUS_PADDLE_COLOR = Color.pink; 
    public double predictedGenius;
         
   
    //****************   CONSTRUCTORS  *************
    public CPUGenius(){
      this(CPU_GENIUS_PADDLE_LENGTH, CPU_GENIUS_PADDLE_SPEED, CPU_GENIUS_PADDLE_COLOR);
    }
   
    public CPUGenius(double length, double speed, Color color){ 
      super(length, speed, color);
    } 

    protected int reactBallMovingLeft(double bX, double bY, double bXVel, double bYVel){
        if(predictedGenius != 0)
            predictedGenius = 0; 
        return super.reactBallMovingLeft(bX, bY, bXVel, bYVel);
     }

    protected int reactBallMovingRight(double bX, double bY, double bXVel, double bYVel){
    
        
        // initiates variables for calculations 
        double paddleY = this.getY();
        double bouncedX = TrigHelpers.calcNextWallBounceX(bX, bY, bXVel, bYVel, this.getWindowHeight());
        double bouncedY = TrigHelpers.calcTargetY(bX, bY, bXVel, bYVel, bouncedX);
        double copybouncedX;
        double copybouncedY;

        

        if(bouncedX > this.getX()){
            return super.reactBallMovingRight(bX, bY, bXVel, bYVel);
        }
        else{
            // continues calculating the bounce locations until we passed for CPU paddle 
            if(predictedGenius == 0){
                while (bouncedX < this.getX()) {
                    // holds the precalculated values to prevent errors in calculations
                    copybouncedX = bouncedX;
                    copybouncedY = bouncedY;
                    bYVel *= -1; // inverts y velocity after a bounce

                    bouncedX = TrigHelpers.calcNextWallBounceX(copybouncedX, copybouncedY, bXVel, bYVel, this.getWindowHeight());
                    bouncedY = TrigHelpers.calcTargetY(copybouncedX, copybouncedY, bXVel, bYVel, bouncedX);
                }
                //sets the predicted location to where the ball will be when it reaches the CPU Paddle.
                predictedGenius = TrigHelpers.calcTargetY(bouncedX, bouncedY, bXVel, bYVel, this.getX());
            }
            
            // returns the necessary movement of the ball based on predicted values
            if (Math.abs(predictedGenius - paddleY) < MOVE_THRESHOLD)
                return MOVE_NEUTRAL;
            else if (paddleY < predictedGenius)
                return MOVE_DOWN;
            else
                return MOVE_UP; 
            
        }
        
     }
}

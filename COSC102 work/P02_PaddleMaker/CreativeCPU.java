import java.awt.Color;
import java.util.Random;

public class CreativeCPU extends CPUGenius{

    // Creative CPU inherits attributes of speed, length and color from CPUgenius and has others
    HumanPaddle p1;
    private boolean colorChange = true;
    Random rand = new Random();


    public CreativeCPU(HumanPaddle human){
        super();
        p1 = human;
    }

    
    protected int reactBallMovingLeft(double bX, double bY, double bXVel, double bYVel){
        //changes the boolean and uses same logic from CPU genius
        if(colorChange == false)
            colorChange = true;
        return super.reactBallMovingLeft(bX, bY, bXVel, bYVel);
    } 

    protected int reactBallMovingRight(double bX, double bY, double bXVel, double bYVel){
        // randomly changes the paddle color after the ball goes right
        if(colorChange && p1.getVolleys() > 2){
            int red = rand.nextInt(254);
            int green = rand.nextInt(254);
            int blue = rand.nextInt(254);
            Color randomColor = new Color(red, green, blue);
            color = randomColor;
            colorChange = false;
        }

        // gives a chance that the CPU paddle freezes if it turns a certain of green
        if(color.getGreen() > 225){
            return 0; 
        }
        else
            return super.reactBallMovingRight(bX, bY, bXVel, bYVel);
        
     }

    
    // each time a point is scored by either paddle, the color is reset and then 
    // adjusts the length of paddle depending on whether it is losing or winning based on points
    public void pointScored(boolean didCPUScore){
        int diff = p1.getScore() - this.getScore();
        color = Color.PINK;
        if(this.getPaddleLength() > 15)
            this.setLength(CPU_GENIUS_PADDLE_LENGTH + (diff*10));
        
        super.pointScored(didCPUScore);
    }

    


}
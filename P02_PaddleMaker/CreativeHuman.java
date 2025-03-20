import java.awt.Color;
import java.util.Random;

public class CreativeHuman extends HumanPaddle{

    //Creative Human Paddle attributes
    public static final double CREATIVE_HUMAN_PADDLE_LENGTH = 60.0;
    public static final double CREATIVE_HUMAN_PADDLE_SPEED = 7.0;
    public static final Color CREATIVE_HUMAN_PADDLE_COLOR = Color.black;

    Random rand = new Random();
    private int random = newNum();
    
    public CreativeHuman(){
        super(CREATIVE_HUMAN_PADDLE_LENGTH, CREATIVE_HUMAN_PADDLE_SPEED,CREATIVE_HUMAN_PADDLE_COLOR);
    }  

    // called whenever a key is pressed 
    public int reactToKey(int keyPressed){
        // reversed the movements to make it more difficult
        if (keyPressed == KEY_MOVE_UP)
          return Paddle.MOVE_DOWN;
        if (keyPressed == KEY_MOVE_DOWN)
           return Paddle.MOVE_UP; 
        return 0;
    }

    public void pointScored(boolean didHumanScore){
        // resets the length of the paddle but reduces the speed if the person did not score #skill-issue
        if (didHumanScore){
            setSpeed(HUMAN_PADDLE_SPEED);
            this.score++;
        }
        else{
            setSpeed(HUMAN_PADDLE_SPEED-3);
        }
        setLength(HUMAN_PADDLE_LENGTH);
        volleys = 0;
    }

    // creates a random int from 1 to 4
    public int newNum(){
        return rand.nextInt(4)+1;
    }

    //Called automatically whenver the ball collides with this paddle
    public void ballVolleyed(){

        // adjusts the speed and length of the player paddle as it volleys the ball
        // based on the factors of a randomized number, each time the volley amount passes a 
        // factor, the speed decreases and length of paddle increases 
        int volleys = getVolleys();
        if(volleys > 0 && volleys % random == 0){
            setSpeed(getSpeed()+2);
            if(getPaddleLength() > 20)
                setLength(getPaddleLength()-5);
            random = newNum();
        }
        this.volleys += 1;
    }  


    
}

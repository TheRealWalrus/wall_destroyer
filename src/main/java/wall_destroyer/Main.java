package wall_destroyer;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {
    static PApplet p5;

    static boolean p1LeftPressed, p1RightPressed, p1FirePressed, p2LeftPressed, p2RightPressed, p2FirePressed;

    private List<Ball> balls = new ArrayList<Ball>();
    private Paddle paddle;

    public static void main(String[] args) {
        PApplet.main("wall_destroyer.Main");
    }

    @Override
    public void settings(){
        size(640, 480);
    }

    @Override
    public void setup(){
        p5 = this;

        balls.add(new Ball());
        paddle = new Paddle(new PVector(width / 2f, height - 40));
    }

    @Override
    public void draw(){
        background(0);

        paddle.update();
        paddle.display();

        for (Ball ball : balls) {
            paddle.hits(ball);
            ball.update();
            ball.display();
        }
    }

    @Override
    public void keyPressed() {
        setMove(keyCode, true);
        //println("keyPressed");
    }

    @Override
    public void keyReleased() {
        setMove(keyCode, false);
    }

    public boolean setMove(int k, boolean b) {
        switch (k) {
            case LEFT:
                return p1LeftPressed = b;

            case RIGHT:
                return p1RightPressed = b;

            case CONTROL:
                return p1FirePressed = b;

            case 83: // A
                return p2LeftPressed = b;

            case 70: // D
                return p2RightPressed = b;

            case 71: // F
                return p2FirePressed = b;

            default:
                return b;
        }
    }
}

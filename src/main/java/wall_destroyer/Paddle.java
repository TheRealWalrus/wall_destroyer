package wall_destroyer;

import processing.core.PVector;

import static wall_destroyer.Main.p5;

public class Paddle extends GameObject {
    private float speed = 9;
    private float width = 90;
    private float height = 15;

    public Paddle(PVector location) {
        super(location);
    }

    @Override
    public void update() {
        if (Main.p1RightPressed) {
            getLocation().x += speed;
        }

        if (Main.p1LeftPressed) {
            getLocation().x -= speed;
        }


    }

    @Override
    public void display() {
        p5.rect(getLocation().x, getLocation().y, width, height);
    }

    public void hits(Ball ball) {
        if (CollisionDetector.lineCircle(getLocation(), new PVector(getLocation().x + width, getLocation().y), ball.getLocation(), ball.getR())) {

            PVector newVelocity = PVector.random2D();
            newVelocity.setMag(7);

            ball.setVelocity(newVelocity);

            System.out.println("HIT REGISTERED");
        }
    }
}

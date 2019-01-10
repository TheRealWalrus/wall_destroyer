package wall_destroyer;

import processing.core.PVector;

import static processing.core.PApplet.constrain;
import static processing.core.PApplet.map;
import static processing.core.PConstants.CENTER;
import static processing.core.PConstants.PI;
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

        getLocation().x = constrain(getLocation().x, width / 2, p5.width - width / 2);
    }

    @Override
    public void display() {
        p5.rectMode(CENTER);
        p5.rect(getLocation().x, getLocation().y, width, height);
    }

    public void hits(Ball ball) {
        if (ball.getLocation().x >= getLocation().x - width / 2 &&
                ball.getLocation().x <= getLocation().x + width / 2 &&
                ball.getLocation().y + ball.getR() >= getLocation().y - height / 2 &&
                ball.getLocation().y + ball.getR() <= getLocation().y + height / 2) {
            float ballRelativeX = ball.getLocation().x - (getLocation().x - width / 2);
            float angle = map(ballRelativeX, 0, width, 5f / 4 * PI, 7f / 4 * PI);

            PVector newBallVelocity = PVector.fromAngle(angle);
            newBallVelocity.setMag(ball.getVelocity().mag());

            ball.setVelocity(newBallVelocity);
        }
    }
}

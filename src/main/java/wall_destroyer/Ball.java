package wall_destroyer;

import processing.core.PVector;

import static wall_destroyer.Main.p5;

public class Ball extends GameObject {

    Ball(PVector location) {
        super(location);
        setVelocity(PVector.random2D());
        getVelocity().setMag(7);
    }

    @Override
    public void update() {
        super.update();

        if (getLocation().x < 0) {
            getLocation().x = 0;
            getVelocity().x *= -1;
        } else if (getLocation().x > p5.width) {
            getLocation().x = p5.width;
            getVelocity().x *= -1;
        }

        if (getLocation().y < 0) {
            getLocation().y = 0;
            getVelocity().y *= -1;
        } else if (getLocation().y > p5.height) {
            getLocation().y = p5.height;
            getVelocity().y *= -1;
        }
    }

    @Override
    public void display() {
        p5.ellipse(getLocation().x, getLocation().y, 20, 20);
    }
}

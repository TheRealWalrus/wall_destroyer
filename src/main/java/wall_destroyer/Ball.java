package wall_destroyer;

import processing.core.PVector;

import static wall_destroyer.Main.p5;

public class Ball extends GameObject {
    private int r = 10;

    Ball(PVector location) {
        super(location);
        setVelocity(PVector.random2D());
        getVelocity().setMag(7);
    }

    @Override
    public void update() {
        super.update();

        if (getLocation().x < r) {
            getLocation().x = r;
            getVelocity().x *= -1;
        } else if (getLocation().x > p5.width - r) {
            getLocation().x = p5.width - r;
            getVelocity().x *= -1;
        }

        if (getLocation().y < r) {
            getLocation().y = r;
            getVelocity().y *= -1;
        } else if (getLocation().y > p5.height - r) {
            getLocation().y = p5.height - r;
            getVelocity().y *= -1;
        }
    }

    @Override
    public void display() {
        p5.ellipse(getLocation().x, getLocation().y, 2 * r, 2 * r);
    }

    public int getR() {
        return r;
    }
}

package wall_destroyer;

import processing.core.PVector;

import static wall_destroyer.Main.p5;

public class Paddle extends GameObject {
    private float speed = 5;

    public Paddle(PVector location) {
        super(location);
    }

    @Override
    public void update() {
        if (Main.p1RightPressed) {
            getVelocity().x -= speed;
        }

        if (Main.p1RightPressed) {
            getVelocity().x += speed;
        }

    }

    @Override
    public void display() {
        p5.rect(getLocation().x, getLocation().y, 100, 30);
    }
}

package wall_destroyer;

import processing.core.PVector;

import static wall_destroyer.Main.p5;

public class Paddle extends GameObject {
    private float speed = 9;

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
        p5.rect(getLocation().x, getLocation().y, 90, 15);
    }
}

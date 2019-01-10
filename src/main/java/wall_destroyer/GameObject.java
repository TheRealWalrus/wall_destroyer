package wall_destroyer;

import processing.core.PVector;

public abstract class GameObject {
    private PVector location;
    private PVector velocity;

    GameObject() {
    }

    GameObject(PVector location) {
        this.location = location;
    }

    public void update() {
        location.add(velocity);
    }

    public abstract void display();

    public PVector getLocation() {
        return location;
    }

    public void setLocation(PVector location) {
        this.location = location;
    }

    public PVector getVelocity() {
        return velocity;
    }

    public void setVelocity(PVector velocity) {
        this.velocity = velocity;
    }
}

package wall_destroyer;

import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("wall_destroyer.Main");
    }

    public void settings(){
        size(640, 480);
    }

    public void setup(){

    }

    public void draw(){
        background(0);

        ellipse(mouseX, mouseY, 40, 40);
    }
}

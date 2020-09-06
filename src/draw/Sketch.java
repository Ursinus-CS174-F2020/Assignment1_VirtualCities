package draw;

import processing.core.PApplet;

//https://processing.org/tutorials/p3d/

public class Sketch extends PApplet {

    @Override
    public void settings() {
        size(800, 800, "processing.opengl.PGraphics3D");
        //lights();
    }
    
    @Override
    public void setup() {
        stroke(155, 0, 0);
    }

    @Override
    public void draw() {
        background(0);
        lights();
        camera(mouseX, mouseY, (height/2) / tan(PI/6), width/2, height/2, 0, 0, 1, 0);
        
        translate(130, height/2, 0);
        //rotateY(1.25f);
        //rotateX(-0.4f);
        box(100);
    }
}


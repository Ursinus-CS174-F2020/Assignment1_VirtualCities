package draw;

import processing.core.PApplet;
import processing.core.PMatrix;

//https://processing.org/tutorials/p3d/

public class Sketch extends PApplet {
    private Camera3D camera;

    @Override
    public void settings() {
        size(800, 800, "processing.opengl.PGraphics3D");
    }
    
    @Override
    public void setup() {
        camera = new Camera3D(-400, -440, -540, 10f, 0.1f);
    }

    @Override
    public void keyPressed() {
        camera.pressKey(key);
        redraw();
    }
    
    @Override
    public void keyReleased() {
        camera.releaseKey(key);
        redraw();
    }
    
    @Override
    public void mousePressed() {
        camera.pressMouse(mouseX, mouseY);
    }
    
    @Override
    public void mouseReleased() {
        camera.releaseMouse();
    }
    
    @Override
    public void mouseDragged() {
        camera.dragMouse(mouseX, mouseY);
        redraw();
    }
    
    public void moveToCamera() {
        float[] pos = camera.getPos();
        //rotateY(camera.getRotX());
        translate(-pos[0], -pos[1], -pos[2]);
        //rotateY(camera.getRotX());
        //rotateX(camera.getRotX());
    }
    
    @Override
    public void draw() {
        background(0);
        lights();
        directionalLight(0, 255, 0, 0, -1, 0);
        //camera(xpos, ypos, zpos, 0, 0, 0, 0, 1, 0);
        
        float fov = 3.14f/2;
        float cameraZ = (height/2.0f) / tan(fov/2.0f);
        
        moveToCamera();
        
        PMatrix matrix = getMatrix();
        float[] m = new float[16];
        matrix.get(m);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(m[i*4+j] + " ");
            }
            System.out.println("");
        }
        
        
        pushMatrix();
        box(100);
        popMatrix();
        
        pushMatrix();
        translate(200, 0, 0);
        box(100);
        popMatrix();
        
        pushMatrix();
        translate(200, 0, -200);
        box(100);
        popMatrix();
        
        pushMatrix();
        translate(200, -100, -200);
        rotateY(1);
        box(50);
        popMatrix();
        
        if (camera.isWalking()) {
            camera.walk();
            redraw();
        }
    }
}


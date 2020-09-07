/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;
import processing.core.PMatrix3D;
import processing.core.PVector;

/**
 *
 * @author ctralie
 */
public class Camera3D {
    private float walkspeed;
    private float rotspeed;
    private float xpos, ypos, zpos;
    private float[] walkDirs = {0, 0, 0}; // Direction of walking
    private boolean isWalking = false;
    private boolean isRotating = false;
    private float lastX;
    private float lastY;
    private float[] right;
    private float[] up;
    
    public Camera3D(float xpos, float ypos, float zpos, float walkspeed, float rotspeed) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.zpos = zpos;
        this.walkspeed = walkspeed;
        this.rotspeed = rotspeed;
        right = new float[3];
        right[0] = 1;
        right[1] = 0;
        right[2] = 0;
        up = new float[3];
        up[0] = 0;
        up[1] = -1;
        up[2] = 0;
    }
    
    public void pressKey(char key) {
        if (key == 'w' || key == 'W') {
            walkDirs[2] = -1;
            isWalking = true;
        }
        else if (key == 's' || key == 'S') {
            walkDirs[2] = 1;
            isWalking = true;
        }
        else if (key == 'a' || key == 'A') {
            walkDirs[0] = -1;
            isWalking = true;
        }
        else if (key == 'd' || key == 'D') {
            walkDirs[0] = 1;
            isWalking = true;
        }
        else if (key == 'e' || key == 'E') {
            walkDirs[1] = -1;
            isWalking = true;
        }
        else if (key == 'c' || key == 'D') {
            walkDirs[1] = 1;
            isWalking = true;
        }
    }
    
    public void releaseKey(char key) {
        if (key == 'w' || key == 'W') {
            walkDirs[2] = 0;
        }
        else if (key == 's' || key == 'S') {
            walkDirs[2] = 0;
        }
        else if (key == 'a' || key == 'A') {
            walkDirs[0] = 0;
        }
        else if (key == 'd' || key == 'D') {
            walkDirs[0] = 0;
        }
        else if (key == 'e' || key == 'E') {
            walkDirs[1] = 0;
        }
        else if (key == 'c' || key == 'D') {
            walkDirs[1] = 0;
        }
        if (walkDirs[0] == 0 && walkDirs[1] == 0 && walkDirs[2] == 0) {
            isWalking = false;
        }
    }
    
    public boolean isWalking() {
        return isWalking;
    }
    
    public void walk() {
        xpos += walkspeed*walkDirs[0];
        ypos += walkspeed*walkDirs[1];
        zpos += walkspeed*walkDirs[2];
    }
    
    public float[] getPos() {
        float[] ret = new float[3];
        ret[0] = xpos;
        ret[1] = ypos;
        ret[2] = zpos;
        return ret;
    }
    
    public void pressMouse(float mouseX, float mouseY) {
        lastX = mouseX;
        lastY = mouseY;
        isRotating = true;
    }
    
    public void dragMouse(float mouseX, float mouseY) {
        float dX = mouseX - lastX;
        float dY = mouseY - lastY;
        if (isRotating) {
            rotate(dX, dY);
        }
        lastX = mouseX;
        lastY = mouseY;
    }
    
    public void releaseMouse() {
        isRotating = false;
    }
    
    public void rotate(float dX, float dY) {
        
    }
    
    public PMatrix3D getMatrix() {
        // Figure out the towards vector by a cross product
        
        float[] m = new float[16];
        PMatrix3D M = new PMatrix3D();
        
        return M;
    }
}

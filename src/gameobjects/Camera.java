/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

/**
 *
 * @author nguyen
 */
public class Camera extends GameObject {
    private float widthView;
    private float heightView;
    
    private boolean isLocked = false;

    public Camera(float x, float y, float widthView, float heightView, GameWorld gameWorld) {
        super(x, y, gameWorld);
        this.widthView = widthView;
        this.heightView = heightView;
    }

    public void lock(){
        isLocked = true;
    }
    
    public void unlock(){
        isLocked = false;
    }
    @Override
    public void Update() {
        if(!isLocked){
            Megaman mainCharacter = getGameWorld().megaman;
            
            if(mainCharacter.getPosX() - getPosX() > 400) setPosX(mainCharacter.getPosX() - 400);
            if(mainCharacter.getPosX() - getPosX() <200) setPosX(mainCharacter.getPosX() -200);
            
            if(mainCharacter.getPosY() - getPosY() >400) setPosY(mainCharacter.getPosY() -400);
            else if(mainCharacter.getPosY() -getPosY() <250) setPosY((mainCharacter.getPosY() -250));
        }
    }

    public float getWidthView() {
        return widthView;
    }

    public void setWidthView(float widthView) {
        this.widthView = widthView;
    }

    public float getHeightView() {
        return heightView;
    }

    public void setHeightView(float heightView) {
        this.heightView = heightView;
    }

    
    
}

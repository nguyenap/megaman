/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import com.sun.glass.events.KeyEvent;
import gameobjects.GameWorld;
import gameobjects.Megaman;

/**
 *
 * @author phamn
 */
public class InputManger {

    private GameWorld gameWorld;
    
    public InputManger(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }
    
    public void setPressedButton(int code){
        
        switch(code){
            
            case KeyEvent.VK_UP:
                gameWorld.megaman.jump();
                break;
            case KeyEvent.VK_DOWN:
                gameWorld.megaman.dick();
                break;
                
            case KeyEvent.VK_LEFT:
                gameWorld.megaman.setDirection(gameWorld.megaman.LEFT_DIR);
                gameWorld.megaman.run();
                break;
            case KeyEvent.VK_RIGHT:
                gameWorld.megaman.setDirection(gameWorld.megaman.RIGHT_DIR);
                gameWorld.megaman.run();
                break;
                
            case KeyEvent.VK_ENTER:
                if(gameWorld.state == gameWorld.PAUSEGAME){
                    if(gameWorld.previousState == gameWorld.GAMEPLAY){
                        gameWorld.switchState(gameWorld.GAMEPLAY);
                    }else {
                        gameWorld.switchState(GameWorld.TUTORIAL);
                    }
                    
                    gameWorld.bgMusic.loop();
                    gameWorld.bgMusic.play();
                }
                if(gameWorld.state == GameWorld.TUTORIAL && gameWorld.storyTutorial >=1){
                    if(gameWorld.storyTutorial <= 3){
                        gameWorld.storyTutorial ++;
                        gameWorld.currentSize = 1;
                        gameWorld.textTutorial = gameWorld.texts1[gameWorld.storyTutorial - 1];
                    }else{
                        gameWorld.switchState(GameWorld.GAMEPLAY);
                    }
                    // for meeting boss
                    if(gameWorld.tutorialState == GameWorld.MEETFINALBOSS){
                        gameWorld.switchState(GameWorld.GAMEPLAY);
                    }
                }
                break;
                
            case KeyEvent.VK_SPACE:
                gameWorld.megaman.jump();
                break;
           case KeyEvent.VK_A:
                gameWorld.megaman.attack();
                break;
            
        }
        
    }
    
    
    public void setReleasedButton(int code){
        
        switch(code){
            
            case KeyEvent.VK_UP:
//                System.out.println("You released UP");
                break;
                
            case KeyEvent.VK_DOWN:
//                System.out.println("You released DOWN");
                gameWorld.megaman.standUp();
                break;
                
            case KeyEvent.VK_RIGHT:
                if(gameWorld.megaman.getSpeedX() > 0)
                    gameWorld.megaman.stopRun();
                break;
                
            case KeyEvent.VK_LEFT:
                if(gameWorld.megaman.getSpeedX() < 0)
                    gameWorld.megaman.stopRun();
                break;
                
            case KeyEvent.VK_ENTER:
                
                break;
                
            case KeyEvent.VK_SPACE:
                
                break;
            case KeyEvent.VK_A:
                
                break;
            
        }
        
    }
    
}

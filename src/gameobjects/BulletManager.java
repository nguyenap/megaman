/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

public class BulletManager extends ParticularObjectManager {

    public BulletManager(GameWorld gameWorld) {
        super(gameWorld);
    }
    
    @Override
    public void UpdateObjects() {
        super.UpdateObjects(); 
        synchronized(particularObjects){
            for(int id = 0; id < particularObjects.size(); id++){
                
                ParticularObject object = particularObjects.get(id);
                
                if(object.isObjectOutOfCameraView() || object.getState() == ParticularObject.DEATH){
                    particularObjects.remove(id);
                    //System.out.println("Remove");
                }
            }
        }
    }
    
    
    
}

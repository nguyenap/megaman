/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.awt.Graphics2D;

/**
 *
 * @author nguyen
 */
public abstract class Bullet extends ParticularObject {

    public Bullet(float x, float y, float width, float height, float mass, int damage, GameWorld gameWorld) {
            super(x, y, width, height, mass, 1, gameWorld);
            setDamage(damage);
    }
    
    public abstract void draw(Graphics2D g2);

    public void Update(){
        super.Update();
        setPosX(getPosX() + getSpeedX());
        setPosY(getPosY() + getSpeedY());
        // getCollisionWidthEnemyObject(this) trả về cái đuối tượng mà va chạm với đối tượng mà đã truyền vào (this) và khác team
        ParticularObject object = getGameWorld().particularObjectManager.getCollisionWidthEnemyObject(this);
        if(object!=null && object.getState() == ALIVE){
            setBlood(0);// set máu cho viên đạn, = 0 là biến mất
            object.beHurt(getDamage());// khi đó object sẽ bị trừ máu, máu bị trừ = dame của viên đạn getdame()
//            System.out.println("Bullet set behurt for enemy");
        }
    }
    
}

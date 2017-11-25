/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import gameobjects.GameWorld;
import gameobjects.Megaman;
import gameobjects.PhysicalMap;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author phamn
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {

    private Thread gameThread;

    private boolean isRunning = true;

    private InputManger inputManger;
    private Graphics2D bufG2D;

    public GameWorld gameWorld;

    public GamePanel() {

        gameWorld = new GameWorld();
        inputManger = new InputManger(gameWorld);
//        bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

    }

    public void startGame() {
            gameThread = new Thread(this);
            gameThread.start();
    }

    @Override
    public void run() {

        long previousTime = System.nanoTime();
        long FPS = 80;
        long period = 1000 * 1000000 / FPS;
        long sleepTime;
        long currentTime;

        while (isRunning) {

            gameWorld.Update();
            gameWorld.Render();
            repaint();

            currentTime = System.nanoTime();
            sleepTime = period - (currentTime - previousTime);

            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime / 1000000);
                } else {
                    Thread.sleep(period / 2000000);
                }
            } catch (Exception ex) {
            }

            previousTime = System.nanoTime();

        }

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(gameWorld.getBufferedImage(), 0, 0, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) { // callback method

        inputManger.setPressedButton(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {

        inputManger.setReleasedButton(e.getKeyCode());
    }

}

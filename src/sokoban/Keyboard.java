/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Gökhan
 */
public class Keyboard implements KeyListener{
    private SokobanFrame frame;
    private SokobanWorld world;
    
    public Keyboard(SokobanFrame frame, SokobanWorld world){
        this.frame = frame;
        this.world = world;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        
        //Misc
        if(keycode == KeyEvent.VK_Q){
            frame.switchState(STATE.MENU);
        }
        if(keycode == KeyEvent.VK_R){
            world.resetLevel();
        }
        
        //Pull
        if(keycode == KeyEvent.VK_W){
            world.pullBox(DIRECTION.NORTH);
        }
        if(keycode == KeyEvent.VK_A){
            world.pullBox(DIRECTION.WEST);
        }
        if(keycode == KeyEvent.VK_S){
            world.pullBox(DIRECTION.SOUTH);
        }
        if(keycode == KeyEvent.VK_D){
            world.pullBox(DIRECTION.EAST);
        }
        
        //Walk
        if (keycode == KeyEvent.VK_UP) {
            world.movePlayer(DIRECTION.NORTH);
        }
        if (keycode == KeyEvent.VK_DOWN) {
            world.movePlayer(DIRECTION.SOUTH);
        }   
        if (keycode == KeyEvent.VK_LEFT) {
            world.movePlayer(DIRECTION.WEST);
        }
        if (keycode == KeyEvent.VK_RIGHT) {      
            world.movePlayer(DIRECTION.EAST);
        }
        
        world.checkLevel();
        world.repaint();
        
        if(world.getGameFinished()){
            frame.switchState(STATE.MENU);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Gökhan
 */
public class SokobanFrame extends JFrame{
    private JPanel infoPanel;
    private SokobanWorld world;
    
    
    private static final int FRAME_WIDTH = 512;
    private static final int FRAME_HEIGHT = 638;
    
    private JPanel menuPanel;
    
    private static final int WORLD_DIMENSION = 512;

    private STATE state = STATE.MENU;
    
    public SokobanFrame() {
        createComp();
        switchState(state);
    }

    private void createComp() {
        infoPanel = new InfoPanel();
        menuPanel = new MenuPanel(this);
        
        this.setLayout(new BorderLayout());
        this.setTitle("Super Sokoban World");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);      
        
        this.setVisible(true);
    }

    public void switchState(STATE state) {
        switch(state){
            case MENU:
                setMenuComp();
                break;
            case GAME:
                setComp();
                break;
            default:
                setMenuComp();
                break;
        }
    }
    
    private void setMenuComp() {
        if(world != null){
            this.remove(world);
            this.remove(infoPanel);
        }
        this.add(menuPanel);
        this.repaint();
    }
    
    private void setComp() {
        this.remove(menuPanel);
        this.setFocusable(false);
        
        world = new SokobanWorld();
        world.setPreferredSize(new Dimension(WORLD_DIMENSION, WORLD_DIMENSION));
        
        KeyListener kl = new Keyboard(this, world);
        world.addKeyListener(kl);
        
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(world, BorderLayout.CENTER);
        
        world.grabFocus();
        
        this.revalidate();
        this.repaint();
    }

    public void quitGame(){
        this.dispose();
    }
}
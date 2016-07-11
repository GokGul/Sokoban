/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gokhan
 */
public class ClickListener implements ActionListener{
    DIFFICULTY difficulty = DIFFICULTY.NORMAL;
    
    SokobanFrame frame;
    MenuPanel mp;
    
    public ClickListener(SokobanFrame frame, MenuPanel mp) {
        this.frame = frame;
        this.mp = mp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mp.play){
            frame.switchState(STATE.GAME);
        }
        if(e.getSource() == mp.kidmode){
            frame.switchState(STATE.GAME);
            difficulty.setDifficulty(DIFFICULTY.KIDMODE);
        }
        if(e.getSource() == mp.quit){
            frame.quitGame();
        }
    }
}

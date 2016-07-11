/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Gökhan
 */
public class DrawPanel extends JPanel {

    public DrawPanel() {
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Super Sokoban World!", 100, 100);
    }
}

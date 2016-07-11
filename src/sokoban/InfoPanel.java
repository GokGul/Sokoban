/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gökhan
 */
public class InfoPanel extends JPanel {
    private static final int PANEL_WIDTH = 512;
    private static final int PANEL_HEIGHT = 100;
    
    private JLabel imgLabelArrows;
    private JLabel textLabelQ;
    private JLabel textLabelR;
    
    private ImageIcon image_arrows = new ImageIcon("src/img/arrow_key.png");
    
    public InfoPanel(){
        createComp();
    }

    private void createComp() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        
        textLabelQ = new JLabel();
        textLabelQ.setText("Q = Quit.  ");
        textLabelQ.setForeground(Color.white);
        
        textLabelR = new JLabel();
        textLabelR.setText(" R = Reset level. ");
        textLabelR.setForeground(Color.white);
        
        imgLabelArrows = new JLabel(image_arrows);
        imgLabelArrows.setPreferredSize(new Dimension(64,64));
        this.add(imgLabelArrows, BorderLayout.EAST);
        this.add(textLabelQ, BorderLayout.WEST);
        this.add(textLabelR, BorderLayout.CENTER);
    }
}

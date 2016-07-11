/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gökhan
 */
public class MenuPanel extends JPanel{
    private JPanel buttonPanel;
    private JPanel drawPanel;
    
    private static final int PANEL_WIDTH = 512;
    private static final int PANEL_HEIGHT = 612;
    
    JButton play;
    JButton quit;
    JButton kidmode;
    
    private static final int BUTTON_WIDTH = 100;
    private static final int BUTTON_HEIGHT = 22;
    
    private ActionListener al;
    
    private ImageIcon imgIcon;
    private JLabel imgLabel;
    
    public MenuPanel(SokobanFrame frame){
        createComp(frame);
        setComp();
    }

    private void createComp(SokobanFrame frame) {
        buttonPanel = new JPanel();
        drawPanel = new DrawPanel();
        
        play = new JButton("Play");
        play.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        kidmode = new JButton("Kid Mode");
        kidmode.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        quit = new JButton("Quit");
        quit.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        
        al = new ClickListener(frame, this);
        
        imgIcon = new ImageIcon("src/img/employee.png");
        imgLabel = new JLabel(imgIcon);
        
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        drawPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        
        this.setBackground(Color.DARK_GRAY);
        buttonPanel.setBackground(Color.red);
    }

    private void setComp() {
        buttonPanel.add(play);
        buttonPanel.add(kidmode);
        buttonPanel.add(quit);
        play.addActionListener(al);
        kidmode.addActionListener(al);
        quit.addActionListener(al);
        
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(drawPanel, BorderLayout.CENTER);
        this.add(imgLabel, BorderLayout.SOUTH);
    }
}

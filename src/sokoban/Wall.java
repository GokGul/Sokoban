/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Gökhan
 */
public final class Wall extends GameObject{

    public Wall(){
    }
    
    @Override
    public Image getImageSource() {
        imgIcon = new ImageIcon("src/img/wall.png");
        img = imgIcon.getImage();
        
        return img;
    }
    
    @Override
    public void move(DIRECTION direction) {
    }
}

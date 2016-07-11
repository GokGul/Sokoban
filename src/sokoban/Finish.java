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
public class Finish extends Tile {

    public Finish(){}
    
    public Finish(Tile tile){
        this.object = tile.getObject();
    }
    public boolean hasBox(){
        if(this.getObject() instanceof Box){
            return true;
        } 
        return false;
    }
    
    @Override
    public Image getImage(){
        this.imgIcon = new ImageIcon("src/img/finish.png");
        this.img = imgIcon.getImage();
        
        return this.img;
    }
}

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
public abstract class GameObject {
    protected Tile tile;
    protected DIFFICULTY difficulty = DIFFICULTY.NORMAL;
    
    protected ImageIcon imgIcon;
    protected Image img;
    
    public GameObject(){
    }
    
    public void setTile(Tile tile){
        this.tile = tile;
    }
    
    public Tile getTile(){
        return tile;
    }
    
    public abstract Image getImageSource();
    public abstract void move(DIRECTION direction);
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author Gokhan
 */
public class Tile {
    
    private HashMap<DIRECTION, Tile> neighbors;
    protected GameObject object;
    
    protected ImageIcon imgIcon;
    protected Image img;
    
    public Tile(){
        neighbors = new HashMap<>();
    }

    public void setObject(GameObject object){
        this.object = object;
        Tile lastTile = object.getTile();
        
        if(lastTile != null){
            lastTile.clearObject();
        }
        object.setTile(this);
    }
    
    public GameObject getObject(){
        return this.object;
    }
    
    public void clearObject(){
        object = null;
    }
    
    public Image getImage(){
        this.imgIcon = new ImageIcon("src/img/floor.png");
        this.img = imgIcon.getImage();
        
        return this.img;
    }
    
    public void addNeighbor(DIRECTION direction, Tile tile){
        neighbors.put(direction, tile);
    }
    
    public Tile getNeighbor(DIRECTION direction){
        return neighbors.get(direction);
    }
}
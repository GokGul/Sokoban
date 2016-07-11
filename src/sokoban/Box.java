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
public class Box extends GameObject{

    public Box(){
    }
    
    @Override
    public Image getImageSource() {
         if(this.getTile() instanceof Finish){
            imgIcon = new ImageIcon("src/img/boxFinish.jpg");
        }
        else{
            imgIcon = new ImageIcon("src/img/box.png");
        }
        img = imgIcon.getImage();
        return img;
    }

    @Override
    public void move(DIRECTION direction) {
        Tile nextTile = tile.getNeighbor(direction);
        
        if(difficulty.getDifficulty() == DIFFICULTY.KIDMODE){
            //Geen KidMode? comment de volgende drie regels  uit.
            if(nextTile.getObject() != null){
                nextTile.getObject().move(direction);
            }
        }
        
        if(nextTile.getObject() == null){
            nextTile.setObject(this);
        }
    }
}

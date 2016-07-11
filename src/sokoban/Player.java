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
public final class Player extends GameObject{
    private int moves = 0;
    
    public Player(){
        setPlayerDirection(DIRECTION.SOUTH);
    }
    
    public void setPlayerDirection(DIRECTION direction){
        switch(direction){
            case NORTH:
                imgIcon = new ImageIcon("src/img/player_up.png");
                break;
            case EAST:
                imgIcon = new ImageIcon("src/img/player_right.png");
                break;
            case WEST:
                imgIcon = new ImageIcon("src/img/player_left.png");
                break;
            case SOUTH:
                imgIcon = new ImageIcon("src/img/player_down.png");
                break;
        }
    }
  
    @Override
    public Image getImageSource() {
        img = imgIcon.getImage();
        
        return img;
    }
    
    public void alterMoves(int i){
        this.moves += i;
        
        if(moves < 0){
            moves = 0;
        }
    }
    
    public int getMoves(){
        return moves;
    }
    
    public void resetMoves(){
        moves = 0;
    }

    @Override
    public void move(DIRECTION direction) {
        setPlayerDirection(direction);
        Tile nextTile = tile.getNeighbor(direction);

        if(nextTile.getObject() != null){
            nextTile.getObject().move(direction);
        }
        if(nextTile.getObject() == null){
            nextTile.setObject(this);
            alterMoves(1);
        }
    }
    
    public void pull(DIRECTION direction){
        Tile nextTile = tile.getNeighbor(direction);
        
        DIRECTION oppositeDirection = getOppositeDirection(direction);
        Tile lastTile = tile.getNeighbor(oppositeDirection);
        setPlayerDirection(oppositeDirection);
        
        if(nextTile.getObject() == null && lastTile.getObject() != null){
            nextTile.setObject(this);
            lastTile.getObject().move(direction);
            alterMoves(1);
        }
    }
    
    public DIRECTION getOppositeDirection(DIRECTION direction){
        switch(direction){
            case NORTH:
                direction = DIRECTION.SOUTH;
                break;
            case WEST:
                direction = DIRECTION.EAST;
                break;
            case SOUTH:
                direction = DIRECTION.NORTH;
                break;
            case EAST:
                direction = DIRECTION.WEST;
                break;
        }
        
        return direction;
    }
}

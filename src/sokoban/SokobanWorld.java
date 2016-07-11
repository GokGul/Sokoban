/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gökhan
 */
public class SokobanWorld extends JPanel{
    private static final int row = 16;
    private static final int col = 16;
    
    private Tile[][] tile;
    private ArrayList<Finish> allFinish;
    
    private Player player;
    private LevelManager levelManager;
    
    private boolean gameFinished = false;
    
    public SokobanWorld(){
        tile = new Tile[row][col];
        
        player = new Player();
        levelManager = new LevelManager();

        setLayout();
        setNeighbor();
        
        setFocusable(true);
    }
    
    private void setLayout() {
        allFinish = new ArrayList();
        
        for(int x = 0; x < row; x++){
            for(int y = 0; y < col; y++){
                tile[x][y] = new Tile();
                
                if(levelManager.getMap()[x][y].equals("W")){
                    tile[x][y].setObject(new Wall());
                }
                if(levelManager.getMap()[x][y].equals("F")){
                    tile[x][y] = new Finish();
                    allFinish.add((Finish)tile[x][y]);
                }
                if(levelManager.getMap()[x][y].equals("B")){
                    tile[x][y].setObject(new Box());
                }
                if(levelManager.getMap()[x][y].equals("P")){
                    tile[x][y].setObject(player);
                }
            }
        }
    }

    public void movePlayer(DIRECTION direction){
        player.move(direction);
    }
    
    public void pullBox(DIRECTION direction){
        player.pull(direction);
    }
    
    private void setNeighbor(){
         for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (x > 0) {
                    tile[x][y].addNeighbor(DIRECTION.WEST, tile[x - 1][y]);
                }
                if (y > 0) {
                    tile[x][y].addNeighbor(DIRECTION.NORTH, tile[x][y - 1]);
                }
                if (x < row - 1) {
                    tile[x][y].addNeighbor(DIRECTION.EAST, tile[x + 1][y]);
                }
                
                if (y < col - 1) {
                    tile[x][y].addNeighbor(DIRECTION.SOUTH, tile[x][y + 1]);
                }
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                g.drawImage(tile[x][y].getImage(), x * 32, y * 32, this);
                
                if (tile[x][y].getObject() != null) {
                    g.drawImage(setImage(x, y), x * 32, y * 32, this);
                }
            }
        }
    }

    private Image setImage(int x, int y) {
        Image img = null;
        
        if(tile[x][y].getObject() != null){
            img = tile[x][y].getObject().getImageSource();
        }
        
        return img;
    }

    private boolean checkFinish() {
        for (Finish f : allFinish) {
            if (!f.hasBox()) {
                return false;
            }
        }
        return true;
    }

    public void checkLevel() {
        boolean flag = checkFinish();
        
        if (flag == true) {
            JOptionPane.showMessageDialog(this, "Gefeliciteerd! U heeft het level gehaald met "
                    + player.getMoves() + " zetten.");
            levelManager.nextLevel();
            
            if(levelManager.getMaxLevel()){
                JOptionPane.showMessageDialog(this, "Gefeliciteerd! U heeft het spel uitgespeeld!");
                gameFinished = true;
            }
            
            resetLevel();
        }
    }
    
    public boolean getGameFinished(){
        return gameFinished;
    }
    
    public void resetLevel(){
        setLayout();
        setNeighbor();
        
        player.resetMoves();
    }
}
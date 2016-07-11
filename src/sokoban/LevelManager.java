/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author Gökhan
 */
public class LevelManager {
    private int level = 1;
    private boolean maxLevel = false;
    
    private String[][] map;
    
    public LevelManager() {
        map = createLevel();
    }

    private String[][] createLevel() {
        switch (level) {
            case 1:
                map = new String[][]{
                    {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "P", "g", "g", "g", "g", "g", "g", "g", "W", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "W", "W", "W", "W", "g", "g", "W", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "B", "g", "g", "W", "W", "g", "g", "g", "B", "g", "W"},
                    {"W", "g", "W", "W", "W", "W", "g", "g", "W", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "g", "W", "W", "W", "W", "g", "g", "g", "W"},
                    {"W", "g", "B", "W", "W", "W", "g", "g", "F", "g", "g", "W", "g", "g", "g", "W"},
                    {"W", "g", "B", "g", "F", "W", "g", "g", "g", "g", "g", "W", "F", "g", "g", "W"},
                    {"W", "g", "g", "W", "W", "W", "g", "g", "g", "W", "W", "W", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "g", "g", "W", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "W", "W", "g", "W", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "F", "g", "W", "g", "g", "W", "F", "g", "g", "g", "g", "W"},
                    {"W", "g", "B", "g", "g", "g", "W", "W", "W", "W", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
                };
                break;
            case 2:
                map = new String[][]{
                    {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "F", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "B", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "B", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "F", "B", "F", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "F", "B", "P", "B", "F", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "F", "B", "F", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "B", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "B", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "F", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
                    {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
                };
                break;
            case 3:
                map = new String[][]{
                    {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "g", "g", "g", "F", "g", "W", "g", "g", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "g", "g", "W", "g", "g", "g", "g", "g", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "g", "B", "W", "F", "F", "W", "g", "g", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "B", "g", "W", "F", "g", "W", "g", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "g", "B", "W", "F", "F", "W", "g", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "g", "B", "g", "F", "F", "g", "W", "g", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "P", "g", "W", "W", "g", "g", "W", "g", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "g", "g", "W", "W", "W", "W", "g", "g", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "g", "B", "W", "g", "g", "B", "B", "g", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "g", "g", "W", "g", "g", "W", "g", "g", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "g", "B", "W", "W", "g", "W", "g", "g", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "g", "g", "g", "g", "g", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "W", "W", "W", "g", "g", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                    {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
                };
                break;
        }
        return map;
    }
    
    public void nextLevel(){     
        level++;
        
        if(level > 3){
            maxLevel = true;
        }
        
        map = createLevel();
    }
    
    public String[][] getMap(){
        return map;
    }
    
    public int getLevel(){       
        return level;
    }
    
    public boolean getMaxLevel(){
        return maxLevel;
    }
}

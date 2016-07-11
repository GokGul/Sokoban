/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author Gökhan
 */
public enum DIFFICULTY {
    NORMAL,
    KIDMODE;
    
    private DIFFICULTY difficulty;
    
    public DIFFICULTY getDifficulty(){
        return this.difficulty;
    }
    
    public void setDifficulty(DIFFICULTY difficulty){
        this.difficulty = difficulty;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author boyke
 */
public class PlayerTest {

    private DIFFICULTY mode;
    private Tile playerTile, westWallTile, southEmptyTile, 
            northBoxTile, eastBoxTile, eastEmptyTile, northWallTile;
        
    private Player player;
    private Box northBox, eastBox;
    private Wall westWall, northWall;
        
    

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
      
        mode = DIFFICULTY.NORMAL;
        playerTile = new Tile();
        westWallTile = new Tile();
        southEmptyTile = new Tile();
        northBoxTile = new Tile();
        eastBoxTile = new Tile();
        eastEmptyTile = new Tile();
        northWallTile = new Tile();
        player = new Player();
        
        northBox = new Box();
        eastBox = new Box();
        
        westWall = new Wall();
        northWall = new Wall();
        
        playerTile.addNeighbor(DIRECTION.NORTH, northBoxTile);
        playerTile.addNeighbor(DIRECTION.EAST, eastBoxTile);
        playerTile.addNeighbor(DIRECTION.SOUTH, southEmptyTile);
        playerTile.addNeighbor(DIRECTION.WEST, westWallTile);
        
        northBoxTile.addNeighbor(DIRECTION.NORTH, northWallTile);
        eastBoxTile.addNeighbor(DIRECTION.EAST, eastEmptyTile);
        
        playerTile.setObject(player);
        northBoxTile.setObject(northBox);
        westWallTile.setObject(westWall);
        eastBoxTile.setObject(eastBox);
        northWallTile.setObject(northWall);

    }
    @After
    public void tearDown() {
    }

    //Test als de speler naar boven loopt, in dit geval staat er een box boven speler
    //en een wall boven de box. Er bevindt nu geen beweging plaats.
    //Hiermee wordt ook het duwen van een doos getest
    @Test 
    public void testMoveNorth(){
        northWall.move(DIRECTION.NORTH);
        northBox.move(DIRECTION.NORTH);
        player.move(DIRECTION.NORTH);
        assertEquals(player, playerTile.getObject());
        assertEquals(northBox, northBoxTile.getObject());
        assertEquals(northWall, northWallTile.getObject());
    }
    
    //Test als de speler naar rechts loopt, in dit geval staat er een box rechts van
    //speler en een leeg vak rechts van de box. Er bevindt nu wel beweging plaats.
    //Hiermee wordt ook het duwen van een doos getest.
    @Test
    public void testMoveEast(){
        eastBox.move(DIRECTION.EAST);
        player.move(DIRECTION.EAST);
        assertEquals(eastBox, eastEmptyTile.getObject());
        assertEquals(player, eastBoxTile.getObject());
    }
   
    //Test als de speler naar beneden loopt, in dit geval staat er een leeg vakje
    //onder de speler. Er bevindt nu wel beweging plaats.
    @Test
    public void testMoveSouth(){
        player.move(DIRECTION.SOUTH);
        assertEquals(player, southEmptyTile.getObject());
    }
    
    //Test als de speler naar links loopt, in dit geval staar een een wall links
    // van de speler. Er bevindt nu geen beweging plaats.
    @Test
    public void testMoveWest(){
        player.move(DIRECTION.WEST);
        assertEquals(player, playerTile.getObject());
    }
    
   
}

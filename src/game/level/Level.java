/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.level;

import game.Game;
import java.awt.Graphics2D;

/**
 *
 * @author Владимир
 */
public class Level {
    
    public static final int  TILE_SCALE =          8;
    public static final int  TILE_IN_GAME_SCALE =  1;
    public static final int  TILES_IN_WIDTH  = Game.WIDTH / (TILE_SCALE * TILE_IN_GAME_SCALE);
    public static final int  TILES_IN_HEIGHT  = Game.HEIGHT / (TILE_SCALE * TILE_IN_GAME_SCALE);
    private int[][] tileMap;
    
    public Level(){
        tileMap = new int[TILES_IN_WIDTH][TILES_IN_HEIGHT];
    }
    
    public void update(){
        
    }
    
    public void render(Graphics2D g){
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import graphics.SpriteSheet;
import graphics.Sprite;
import utils.Time;
import Display.Display;
import game.level.Level;
import graphics.TextureAtlas;
import io.Input;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Владимир
 */
public class Game implements Runnable{
    public static final int         WIDTH               = 800;
    public static final int         HEIGHT              = 600;
    public static final String      TITLE               = "Tanks";
    public static final int         CLEAR_COLOR         = 0xff000000;
    public static final int         NUM_BUFFERS         = 2;
    
    public static final float       UPDATE_RATE         = 60.0f;
    public static final float       UPDATE_INTERVAL     = Time.SECOND / UPDATE_RATE;
    public static final long        IDLE_TIME           = 1;
    
    public static final String      ATLAS_FILE_NAME     ="texture_atlas.png";
    
    private boolean                 running;
    private Thread                  gameThread;
    
    private Graphics2D              graphics;
    private Input                   input;
    
    private TextureAtlas            atlas;
    private SpriteSheet             sheet;
    private Sprite                  sprite;
    private Level                   lvl;
    public Player                  player;
    
    public Game(){
        running = false;
        Display.create(WIDTH, HEIGHT, TITLE, CLEAR_COLOR, NUM_BUFFERS);
        graphics = Display.getGraphics();
        input = new Input();
        Display.addInputListener(input);
        atlas = new TextureAtlas(ATLAS_FILE_NAME);
        player = new Player(300, 300, 2, 3, atlas);
        lvl = new Level(atlas);
    }
    public synchronized void start(){
        if(running)
            return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    public synchronized void stop(){
        
        if(!running)
            return;
        running = false;
        
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        cleanUp();
    }
    private void update(){ //физика, расчеты
        player.update(input);
        lvl.update();
    }
    private void render(){
        Display.clear();
        graphics.setColor(Color.red);
        
        lvl.render(graphics);
        player.render(graphics);
        lvl.renderGrass(graphics);
        //graphics.fillOval((int)(x+Math.sin(delta)*200), (int)y, (int)radius*2, (int)radius*2);
        //graphics.drawImage(atlas.cut(0, 0, 16, 16), (int)x+300, (int)y+300, null);
        //sprite.render(graphics, x, y);
        Display.swapBuffers();
    }
    public void run(){
        int fps = 0;
        int upd = 0;
        int updl = 0;
        
        long count = 0;
        
        float delta = 0;
        long lastTime = Time.get();
        while(running){
            long now = Time.get();
            long elapsedTime = now - lastTime;
            lastTime = now;
            
            count+=elapsedTime;
            
            boolean render = false;
            delta += (elapsedTime / UPDATE_INTERVAL);
            while(delta>1){
                update();
                upd++;
                delta --;
                if(render){
                    updl++;
                }else{
                    render = true;
                }
            }
            if(render){
                render();
                fps++;
            }else{
                try {
                    Thread.sleep(IDLE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            if(count>= Time.SECOND){
                Display.setTitle(TITLE+" || Fps: "+fps+" | Upd: "+ upd+" | Updl: "+updl+" | Count="+count);
                upd = 0;
                fps = 0;
                updl = 0;
                count =0;
            }
            
        }
    }
    private void cleanUp(){//очистка ресурсов
        Display.destroy();
    }
}

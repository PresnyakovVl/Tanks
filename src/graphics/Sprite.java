/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import utils.Utils;

/**
 *
 * @author Владимир
 */
public class Sprite {
    
    private SpriteSheet sheet;
    private float scale;//на сколько большим рисовать спрайт
    private BufferedImage image;
    
    public Sprite(SpriteSheet sheet, float scale){
        this.sheet = sheet;
        this.scale = scale;
        image = sheet.getSprite(0);
        image = Utils.resize(image,(int)(image.getWidth()*scale), (int)(image.getHeight()*scale));
    }
    
    public void render(Graphics2D g, float x, float y){
        
        g.drawImage(image, (int)x, (int)y, null);
    }
    
}

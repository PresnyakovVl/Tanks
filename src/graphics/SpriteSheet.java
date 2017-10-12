/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author Владимир
 */
public class SpriteSheet {
    private BufferedImage       sheet;
    private int                 spriteCount;
    private int                 scale; //значение в пикселях одного спрайта
    private int                 spritesInWidth;
    public SpriteSheet(BufferedImage sheet, int spriteCount, int scale){
        this.sheet = sheet;
        this.spriteCount = spriteCount;
        this.scale = scale;
        
        this.spritesInWidth = sheet.getWidth() / scale;
                
    }
    
    public BufferedImage getSprite(int index){
        
        index = index % spriteCount;
        
        int x= index % spritesInWidth*scale;
        int y = index / spritesInWidth*scale;
        
        return sheet.getSubimage(x, y, scale, scale);
    }
}

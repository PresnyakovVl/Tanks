/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.image.BufferedImage;
import utils.ResourceLoader;

/**
 *
 * @author Владимир
 */
public class TextureAtlas {
    BufferedImage image;
    public TextureAtlas(String imagename){
        image = ResourceLoader.loadImage(imagename);
    }
    
    public BufferedImage cut(int x, int y, int w, int h){
        return image.getSubimage(x, y, w, h);
    }
}

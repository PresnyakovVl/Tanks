/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Владимир
 */
public class ResourceLoader {
    public static final String  PATH = "src/res/";
    public static BufferedImage loadImage(String filename){
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(new File(PATH + filename));
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return image;
    }
}

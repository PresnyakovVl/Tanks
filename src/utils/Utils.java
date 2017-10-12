/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.image.BufferedImage;

/**
 *
 * @author Владимир
 */
public class Utils {
    
    public static BufferedImage resize(BufferedImage image, int width, int height){
        
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        newImage.getGraphics().drawImage(image, 0, 0, width, height, null);
        
        return newImage;
    }
}


// Class: BufferedImageLoader

package WizardGame;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class BufferedImageLoader {

   private BufferedImage m_buffImage;  
    
   public BufferedImage loadImage(String strPath) { 
       
      try { 
         m_buffImage = ImageIO.read(getClass().getResource(strPath));
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      
      return m_buffImage;
      
   }    
        
}

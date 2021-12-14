
// Class: Animation

package WizardGame;


import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Animation {

   private int m_iSpeed;
   private int m_iFrames;
   private int m_iIndex = 0;
   private int m_iCount = 0;
   
   private BufferedImage[] m_pImage;    
    
   private BufferedImage m_CurrentImage;  
   
   public Animation(int iSpeed, BufferedImage[] pImage, int iFrames) {
      
      int iCount;  
      
      // Correct size on the vector with BufferedImages.
      if (pImage.length >= iFrames) {
          
         this.m_pImage = new BufferedImage[iFrames];
         
         this.m_iFrames = iFrames;
         
         for (iCount = 0; iCount < iFrames; ++iCount)
         {
            this.m_pImage[iCount] = pImage[iCount];
         }
         
      }
      
      // Wrong input data or wrong size on pImage.
      else {
          
         m_pImage = null;
         m_iFrames = 0;
         
      }
       
   }   
   
   public void runAnimation() {
   
      ++m_iIndex;
      
      if (m_iIndex > m_iSpeed) {
          
         m_iIndex = 0;
         nextFrame();
         
      }
       
   }
   
   public void nextFrame() {
   
      m_CurrentImage = m_pImage[m_iCount];
      
      ++m_iCount;
      
      if (m_iCount > m_iFrames - 1) {
         m_iCount = 0;
      }
   
   }
   
   public void drawAnimation(Graphics g, double iX, double iY, int iOffset) {
       
      g.drawImage(m_CurrentImage, (int) iX - iOffset, (int) iY, null);
      
   }
   
   public int getCount() {
      return m_iCount;
   }
   
   public void setCount(int iCount) {
      this.m_iCount = iCount;
   }
   
   public int getSpeed() {
      return m_iSpeed;
   }
   
   public void setSpeed(int iSpeed) {
      this.m_iSpeed = iSpeed;
   }   
   
}

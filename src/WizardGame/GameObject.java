
// Class: GameObject

package WizardGame;

import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class GameObject {

   protected int m_iX;
   protected int m_iY;
   protected ID m_ID;
   
   protected float m_fVelX = 0;
   protected float m_fVelY = 0;
   
   protected SpriteSheet m_SpriteSheet;
   
   public GameObject(int iX, int iY, ID id, SpriteSheet spriteSheet) {
      
      this.m_iX = iX;
      this.m_iY = iY;
      this.m_ID = id;
      this.m_SpriteSheet = spriteSheet;
      
   }  
   
   public abstract void tick();
   public abstract void render(Graphics g);
   public abstract Rectangle getBounds();
   
   public int getX() {
      return m_iX;
   }
   
   public void setX(int iX) {
      this.m_iX = iX;
   }
   
   public int getY() {
      return m_iY;
   }
   
   public void setY(int iY) {
      this.m_iY = iY;
   }   
   
   public float getVelocityX() {
      return m_fVelX;
   }
   
   public void setVelocityX(float fVelX) {
      this.m_fVelX = fVelX;
   }   
   
   public float getVelocityY() {
      return m_fVelY;
   }
   
   public void setVelocityY(float fVelY) {
      this.m_fVelY = fVelY;
   }
   
   public ID getID() {
      return m_ID;
   }
   
   public void setID(ID id) {
      this.m_ID = id;
   }
   
}

package harsh.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Sprite {
	// protected - with in the package but outside package needs inheritance. 
	protected int x; //by default it has default scope(Package level scope)
	int y;
	int w;
	int h;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public BufferedImage getBi() {
		return bi;
	}
	public void setBi(BufferedImage bi) {
		this.bi = bi;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	BufferedImage bi;
	int speed;
	
	
   public void draw(Graphics pen) {
	   pen.drawImage(bi, x, y, w, h, null);
   }
   public abstract void move();
   }



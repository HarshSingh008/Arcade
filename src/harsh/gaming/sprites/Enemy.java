package harsh.gaming.sprites;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends Sprite {
	public boolean isAlive ;
	public Enemy(int x, int speed) throws IOException{
		this.x= x;
		y = 50;
		w = 100;
		h = 100;
		isAlive = true;
		this.speed= speed;
		bi = ImageIO.read(Enemy.class.getResource("spider.gif"));
	}
	public void move() {
		y=y+speed;
	}
	public void outOfScreen() {
		if(y>600 && isAlive)
		{
			y=0;
		}
	}
public void fall() {
		
		
		y = y + 10;
	}
	
	
}



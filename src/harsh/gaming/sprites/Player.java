package harsh.gaming.sprites;

import javax.imageio.ImageIO;

import java.util.ArrayList;
import harsh.gaming.Board;
import harsh.gaming.Constants;

public class Player extends Sprite implements Constants{
	int force;
	boolean isJump;
	ArrayList<Bullet> bullets = new ArrayList<>();
	public Player() throws Exception{
		x = 20;
		y=450;
		w=100;
		h=100;
		isJump = false;
		speed = 4;
		bi = ImageIO.read(Player.class.getResource("player-img.gif"));
		
	}
	public ArrayList<Bullet> getBullets(){
		return bullets;
	}
	
	public void addBullet(int x, int y) {
		bullets.add(new Bullet(x,y));
	}

 public void move() {
	 
	 x = x + speed;
	 
 }
 public void jump() {
	 if(!isJump) {
	 force = -15;
	 y = y + force;
	 isJump = true;
	 }
	 
 }
 public void fall() {
	 if(y<=BOARD_HEIGHT-100-h) {
		 isJump = false;
		 return;
	 }
	 force = force + Gravity;
	 y = y + force;
	 } 
	 
	 
 
 
public boolean outOfScreen() {
	// TODO Auto-generated method stub
	if(x>BOARD_HEIGHT) {
		return true;
	}
	return false;
}
	
 
 
}

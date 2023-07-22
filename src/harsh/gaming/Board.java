package harsh.gaming;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;

import harsh.gaming.sprites.Enemy;
import harsh.gaming.sprites.Player;
import harsh.gaming.sprites.Sprite;
import harsh.gaming.sprites.Bullet;


public class Board extends JPanel implements Constants{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Constructor (Initialize)
	BufferedImage bi ;
	Player player ;
	//Enemy enemy;
	Enemy enemies[] ;
	String gameMessage="";

	
	int x[] = new int[10];
	int count = 0 ;
	Board() throws Exception{
		setSize(1000,600); // Board Size Set
		bi = ImageIO.read(Board.class.getResource("ga"
				+ ""
				+ "me -bg.jpg")); // Image Read
		player = new Player();
		enemies = new Enemy[3]; // all enemies are null
		loadEnemies();
		setFocusable(true);
		bindEvents();
        gameloop();
	
	}
	void enemyFall() {
		for(Enemy e : enemies) {
			if(!e.isAlive) {
			e.fall();
			}
		}
	}
	
	boolean isCollide(Sprite one, Sprite two) {
		int xDistance = Math.abs(one.getX()- two.getX());
		int yDistance = Math.abs(one.getY()- two.getY());
		int w =Math.max(one.getW(), two.getW());
		int h =Math.max(one.getH(), two.getH());
		return xDistance<=w-40 && yDistance<=h-20;
		
			}
	void checkCollison() {
		//check player is collide with enemy or not
		for(Enemy e:enemies) {
			if(isCollide(player, e)) {
				gameMessage = "Game Over";
			    timer.stop();
			    return;
			}
		}
		for(Bullet bullet : player.getBullets()) {
			for(Enemy e : enemies) {
				if(isCollide(e, bullet)) {
					e.isAlive = false;
				}
			}
		}
	
	
	
	}
		void isGameWin() {
			if(player.outOfScreen()) {
				gameMessage = "Game Win";
				timer.stop();
			}
		}
	
	void bindEvents() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				///TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {;
				player.move();
				}
				else if(e.getKeyCode()== KeyEvent.VK_SPACE) {
					player.jump();
					
					}
				else if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					player.addBullet(player.getX() + player.getW(), player.getY() + player.getH()/2);
				}
				}
		});
	}
	Timer timer;
	
	void gameloop() {
		//Delay
		Timer timer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				checkCollison();
				isGameWin();
				player.fall();
				enemyFall();
				count++;
			}
		});
		timer.start();
	}
	void loadEnemies() throws Exception
	{
		int x=200;
		int speed=6;
		int GAP =200;
		
		for(int i=0;i<enemies.length;i++)
		{
			enemies[i]=new Enemy(x,speed);
			x=x+GAP;
			speed=speed+2;
		}
	}
	void printBullets(Graphics pen) {
		ArrayList<Bullet> bullets = player.getBullets();
		for(int i = 0; i<bullets.size(); i++) {
			Bullet currentBullet = bullets.get(i);
			currentBullet.draw(pen);
			currentBullet.move();
			if(currentBullet.outOfScreen()) {
				bullets.remove(i);
				System.out.println(bullets.size());
			}
		}
//		for(Bullet bullet : bullets) {
//			bullet.draw(pen);
//			bullet.move();
//			if(bullet.outOfScreen()) {
//				bullets.remove(bullet);
//			}
//		}
	}
	
	
	void printEnemies(Graphics pen) {
		for(Enemy e : enemies) {
			e.draw(pen);
			e.move();
			e.outOfScreen();
		}
	}
	
	void printMessage(Graphics pen) {
		pen.setColor(Color.RED);
		pen.setFont(new Font("times", Font.BOLD, 40));
		pen.drawString(gameMessage, BOARD_WIDTH/2, BOARD_HEIGHT/2);
		
	}
	// Painting on Board
	@Override
	public void  paintComponent(Graphics pen){
//		pen.setColor(Color.RED);
//		pen.fillRect(10, 50, 70, 50);
//		pen.drawRect(20, 100, 100, 100);
//		pen.drawOval(300, 50, 100, 100);
//		pen.setFont(new Font("times", Font.BOLD, 50));
//		pen.drawString("Game 2022", 300, 300);
		pen.drawImage(bi,0,0,1000,600, null);
		player.draw(pen);
		printEnemies(pen);
		printBullets(pen);
		//enemy.draw(pen);
		if(gameMessage.length()>0)
		{
			printMessage(pen);
		}
		
	}

}

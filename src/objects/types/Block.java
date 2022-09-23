package objects.types;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

import game.Game;
import objects.GameObject;
import objects.ObjectID;

public class Block extends GameObject {
	
	int blockx, blocky;
	
	public Block(int x, int y, ObjectID id, int blockx, int blocky) {
		super(x, y, id);
		this.blockx = blockx;
		this.blocky = blocky;
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		// TODO Auto-generated method stub
	}
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2D = (Graphics2D) g;

		Image image = new ImageIcon("src/resources/numbers/closed.png").getImage();
		width = image.getWidth(null); height = image.getHeight(null);
		g2D.drawImage(image, x, y, width * 2, height * 2, null);
	}

	@Override
	public void mousePressed(int mx, int my) {
		// TODO Auto-generated method stub
		if (Game.gameboard.getBlockInfo(mx / 32, my / 32) == -1) {
			Game.canInput = false;
		} else if (Game.gameboard.getBlockInfo(mx / 32, my / 32) == 0) {
			if (Game.gameboard.checkOuter(mx / 32, my / 32) == 0) {
				
			}
		}
		
		x = -100;
		y = -100;
	}
	
	public void brick(int mx, int my) {
		if (Game.gameboard.checkOuter(mx / 32, my / 32) == 0) {
			
		}
	}

	@Override
	public void mouseReleased() {
		// TODO Auto-generated method stub
		x = -100;
		y = -100;
		
	}
}

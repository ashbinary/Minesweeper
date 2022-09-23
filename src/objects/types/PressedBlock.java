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

public class PressedBlock extends GameObject {
	
	int blockx, blocky;
	
	public PressedBlock(int x, int y, ObjectID id, int blockx, int blocky) {
		super(x, y, id);
		this.blockx = blockx;
		this.blocky = blocky;
		// TODO Auto-generated constructor stub
		//velX = 1;
	}

	public void tick() {
		// TODO Auto-generated method stub
	}
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2D = (Graphics2D) g;

		Image image = new ImageIcon("src/resources/numbers/" + Game.gameboard.getBlockInfo(blockx, blocky) + ".png").getImage();
		width = image.getWidth(null); height = image.getHeight(null);
		g2D.drawImage(image, x, y, width * 2, height * 2, null);
	}

	@Override
	public void mousePressed(int mx, int my) {
		// TODO Auto-generated method stu		
	}

	@Override
	public void mouseReleased() {
		// TODO Auto-generated method stub
		
	}
}

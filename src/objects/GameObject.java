package objects;

import java.awt.Graphics;
import java.util.HashMap;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class GameObject {

	protected int x, y;
	protected ObjectID id;
	protected int width = 0, height = 0;
	
	HashMap<String, Rectangle> customHitboxes = new HashMap<String, Rectangle>();
	
	public GameObject(int x, int y, ObjectID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void mousePressed(int mx, int my);
	public abstract void mouseReleased();
	
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public void setID(ObjectID id) { this.id = id; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	
	public int getX() { return x; }
	public int getY() { return y; }
	public ObjectID getID() { return id; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public Rectangle getBounds() {
	    return new Rectangle(x, y, width * 4, height * 4);
	}
	
	public Rectangle getHitbox(String type) {
		Rectangle objectHitbox;
		if (type == null) { objectHitbox = new Rectangle(x, y, width * 4, height * 4); }
		else { objectHitbox = customHitboxes.get(type); }
		
	    return objectHitbox;
	}
	
	public void setHitbox(String type, Rectangle hitbox) {
		if (customHitboxes.put(type, hitbox) != null) customHitboxes.replace(type, hitbox);
		else customHitboxes.put(type, hitbox);
	}
	
}

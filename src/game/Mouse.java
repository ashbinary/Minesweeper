package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import objects.GameObject;
import objects.ObjectHandler;
import objects.ObjectID;

public class Mouse extends MouseAdapter {
	
	 private ObjectHandler objectHandler;
	 
	 public Mouse(ObjectHandler objectHandler) {
		 this.objectHandler = objectHandler;
	 }
	 
	 public void mousePressed(MouseEvent e) {
		 int mx = e.getX(), my = e.getY();
		 
		 Debug.logln("press");
		 
		 for (int curObj = 0; curObj < objectHandler.objectList.size(); curObj++) {
			 GameObject tempObject = objectHandler.objectList.get(curObj);
			 if ((mx >= tempObject.getX() && mx <= tempObject.getX() + tempObject.getWidth() * 2) 
			  && (my >= tempObject.getY() && my <= tempObject.getY() + tempObject.getHeight() * 2)) {
				 if (Game.canInput) tempObject.mousePressed(mx, my);
			 }
		 }
	 }
}

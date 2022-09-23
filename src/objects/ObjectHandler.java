package objects;

import java.awt.Graphics;
import java.util.LinkedList;

import game.Debug;

//	Handles the objects used in the game (current frame, current vars) along with adding and removing them.

public class ObjectHandler {

	public LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	
	public void tick() {
		for (int curObj = 0; curObj < objectList.size(); curObj++) {
			GameObject tempObj = objectList.get(curObj);
			//Debug.logln(tempObj.id + " -> [x: " + tempObj.x + ", y: " + tempObj.y + "]");
			tempObj.tick();
		}
		//Debug.logln("-----------------------");
	}
	
	public void render(Graphics g) {
		for (int curObj = 0; curObj < objectList.size(); curObj++) {
			GameObject tempObj = objectList.get(curObj);
			tempObj.render(g);
		}
	}
	
	public void addObj(GameObject object) {
		this.objectList.add(object);
	}
	
	public void removeObj(GameObject object) {
		this.objectList.remove(object);
	}
}

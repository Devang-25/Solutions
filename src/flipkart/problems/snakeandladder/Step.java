package flipkart.problems.snakeandladder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Step {
	public Step(int i) {
		this.stepNo = i;
		gameObjects = new LinkedList<GameObject>();// catch here.
	}

	public void addGameObject(GameObject obj) {
		if (validate(obj)) {
			this.gameObjects.add(obj);
		}
	}

	private boolean validate(GameObject obj) {
		if(this.gameObjects.isEmpty()){
			return true;
		}
		return false;
	}

	private List<GameObject> gameObjects;
	private int stepNo;

	public List<GameObject> getGameObjects() {
		return new ArrayList<GameObject>(this.gameObjects);
	}

}

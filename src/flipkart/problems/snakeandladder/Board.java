package flipkart.problems.snakeandladder;

public class Board {
	private Step[] steps; 
	public Board() {
		steps = new Step[101];
		for (int i = 1; i < 101; i++) {
			steps[i] = new Step(i);
		}
	}

	public void addGameObjectAt(GameObject obj) {
		this.steps[obj.getPosition()].addGameObject(obj);
	}

	public Step getStep(int pos) {
		return this.steps[pos];
	}
}

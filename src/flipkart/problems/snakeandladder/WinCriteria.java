package flipkart.problems.snakeandladder;

public class WinCriteria {
	private Game game;
	public WinCriteria(Game game) {
		this.game=game;
	}
	
	public boolean winSituation(Player p){
		if(p.getPosition()==100){
			return true;
		}
		return false;
	}

  
}

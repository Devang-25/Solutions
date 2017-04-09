package flipkart.problems.cardgame;

public interface NextPicker {

	public abstract GamePlayer pickNextPlayer();
	
	public void setReferncePlayer(GamePlayer player);

}
package flipkart.problems.cardgame;

public interface GamePlayer {

	public abstract void addCard(Card card);

	public abstract Card getResponseCard(Card card);

	public abstract boolean isFinished();

	public abstract Card selectCard();

	public int getPosition();

}
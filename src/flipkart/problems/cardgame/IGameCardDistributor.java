package flipkart.problems.cardgame;

public interface IGameCardDistributor {

	public abstract void distributeDeck(int nCards, int mColors,
			GamePlayer[] players);

}
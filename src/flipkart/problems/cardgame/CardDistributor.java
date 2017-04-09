package flipkart.problems.cardgame;

public class CardDistributor implements IGameCardDistributor {
	/* (non-Javadoc)
	 * @see flipkart.problems.cardgame.IGameCardDistributor#distributeDeck(int, int, flipkart.problems.cardgame.GamePlayer[])
	 */
	@Override
	public void distributeDeck(int nCards, int mColors, GamePlayer[] players) {
		int k = 0;
		for (int i = 1; i <= nCards; i++) {
			int cardNo = (int) (Math.random() * 5);
			int color = (int) (Math.random() * mColors);
			Card card = new Card(cardNo, color);
			players[k].addCard(card);
			k++;
			if (k == players.length) {
				k = 0;
			}
		}
	}
}

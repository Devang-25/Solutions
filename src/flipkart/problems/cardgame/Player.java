package flipkart.problems.cardgame;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Player implements GamePlayer{

	private List<Card> cards;

	Player(Game g, int position) {
		cards = new LinkedList<Card>();
		this.position=position;
	}
	
	int position=-1;

	/* (non-Javadoc)
	 * @see flipkart.problems.cardgame.GamePlayer#addCard(flipkart.problems.cardgame.Card)
	 */
	@Override
	public void addCard(Card card) {
		cards.add(card);
	}

	/* (non-Javadoc)
	 * @see flipkart.problems.cardgame.GamePlayer#getResponse(flipkart.problems.cardgame.Card)
	 */
	@Override
	public Card getResponseCard(Card card) {
		ListIterator<Card> i = cards.listIterator();
		while (i.hasNext()) {
			Card c = i.next();
			if (card.getCardNo() == c.getCardNo()
					|| card.getColor() == c.getColor()) {
				i.remove();
				return c;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see flipkart.problems.cardgame.GamePlayer#isFinished()
	 */
	@Override
	public boolean isFinished() {
		return cards.isEmpty();
	}

	/* (non-Javadoc)
	 * @see flipkart.problems.cardgame.GamePlayer#selectCard()
	 */
	@Override
	public Card selectCard() {
		return cards.remove(0);
	}


	@Override
	public int getPosition() {
		return this.position;
	}

}

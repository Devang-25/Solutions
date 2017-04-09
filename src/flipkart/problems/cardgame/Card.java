package flipkart.problems.cardgame;

public class Card {
	private int cardNo;
	private int color;

	public int getCardNo() {
		return cardNo;
	}

	public int getColor() {
		return color;
	}

	public Card(int cardNo, int color) {
		this.cardNo = cardNo;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return this.cardNo+"-"+this.color;
	}

}

package flipkart.problems.cardgame;

public class Game {
	private int noOfPlayers;
	private int cards;
	private int colors;
	private IGameCardDistributor distributor;
	private WinDecider winDecider;

	public int getPlayers() {
		return noOfPlayers;
	}

	public int getCards() {
		return cards;
	}

	public int getColors() {
		return colors;
	}

	public Game(int players, int cards, int colors) {
		super();
		this.noOfPlayers = players;
		this.cards = cards;
		this.colors = colors;
	}

	public static void main(String[] args) {
		Game g = new Game(5, 50, 3);
		IGameCardDistributor distributor = new CardDistributor();
		g.setCardDistributor(distributor);
		g.setWinDecider(new WinDeciderImpl());
		g.play();
	}

	private void setWinDecider(WinDeciderImpl winDeciderImpl) {
		this.winDecider = winDeciderImpl;
	}

	public void setCardDistributor(IGameCardDistributor distributor) {
		this.distributor = distributor;
	}

	private GamePlayer[] players;
	private NextPicker whoSelects;
	private NextPicker whoseTurn;

	public GamePlayer play() {
		players = new GamePlayer[this.noOfPlayers];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(this, i);
		}
		this.whoSelects = new NextPlayerPicker(players);
		this.whoseTurn=new NextTurnPicker(players);
		distributor.distributeDeck(cards, colors, players);
		GamePlayer winner = null;
		while (winner == null) {
			GamePlayer p=whoSelects.pickNextPlayer();
			Card card = p.selectCard();
			System.out.println("Player chose " + card);
			whoseTurn.setReferncePlayer(p);
			GamePlayer thisPlayer=null;
			while ((thisPlayer=whoseTurn.pickNextPlayer())!=null) {
				Card responseCard = thisPlayer.getResponseCard(card);
				System.out.println("Player " + thisPlayer.getPosition() + " response " + responseCard);
				if (winDecider.isWinSituation(thisPlayer, responseCard)) {
					// player threw a card
					// check if the players has consumed all his/her cards.
					winner = thisPlayer;
					break;
				}
			}
		}
		return winner;
	}

}

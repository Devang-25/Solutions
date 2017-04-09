package flipkart.problems.cardgame;

public class WinDeciderImpl implements WinDecider {

	@Override
	public boolean isWinSituation(GamePlayer gamePlayer, Card responseCard) {
		return responseCard != null && gamePlayer.isFinished();
	}

}

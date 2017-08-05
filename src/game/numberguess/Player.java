package game.numberguess;

public class Player {
	
	String name;
	int games;
	int wins;
	int losses;
	double winP;
	
	Player(String name) {
		this.name = name;
		games = 0;
		wins = 0;
		losses = 0;
		winP = 0.0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGames() {
		return games;
	}
	public void setGames(int games) {
		this.games = games;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	private double getWinP() {
		double val = this.wins/this.games;
		
		return val * 100;
	}
	
	public void getStats() {
		System.out.println("\nPlayer Stats: ");
		System.out.println("Name: " + this.name);
		System.out.println("Total games: " + this.games);
		System.out.println("Win %: " + getWinP());
	}
	
	

}

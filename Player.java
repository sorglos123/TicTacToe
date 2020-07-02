package cs14_tictactoe;

public class Player {
	String name;
	static final Player CROSS = new Player("cross");
	static final Player NAUGHT = new Player("naught");

	public Player(String name) {

		this.name = name;
		
	}

	public String toString() {
		return "Player [name=" + name + "]";
	}

}

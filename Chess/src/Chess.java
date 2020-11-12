
public class Chess {
	private Board board;
	private Player[] players;
	private Turn turn;
	private GestorIO gestorIO;
	
	public Chess() {
		initialize();
		gestorIO = new GestorIO();
	}
	
	private void initialize() {
		players = new Player[2];
		players[0] = new Player("white");
		players[1] = new Player("black");
		turn = new Turn();
	}
	
	public void play() {
		boolean resume = true;
		do {
			board.show();
			players[turn.toPlay()].movePiece(board);
			turn.change();			
			if(board.isMate()) {
				board.show();
				players[turn.notToPlay()].victory();
				gestorIO.out("RESUME? (y/n): ");
				if (gestorIO.inChar() != 'y')
					resume = false;
				else
					this.initialize();
			}
		} while(resume);
	}

	public static void main(String[] args) {
		new Chess().play();
	}

}

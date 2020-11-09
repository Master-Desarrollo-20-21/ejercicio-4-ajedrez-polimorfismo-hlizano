
public class Player {
	private int movements;
	
	private String color;
	
	public Player(String color){
		this.color = color;	
		this.movements = 0;
	}
	
	public boolean firstMovement() {
		return movements == 0;
	}

	public void movePiece(Board board) {
		new GestorIO().out("\nToca mover al jugador con fichas de color: " + color + "\n");		
		Coordinate origin = new Coordinate();
        Coordinate destiny = new Coordinate();
        String error = "";
        do {
            origin.position("Escoja la posición de la ficha que quiere mover \n");                     
            destiny.position("Escoja la posición donde quiere poner la ficha");            
            error = this.validateMove(board, origin, destiny);
            if (!error.equals("")) {
                new GestorIO().out(error + "\n");
            }
        } while (!error.equals(""));	
        this.movements++;
		board.movePiece(origin, destiny);
	}

	private String validateMove(Board board, Coordinate origin, Coordinate destiny) {	
		Piece piece = board.getPiece(origin); 		
		if (piece.color != this.color) {
			return "Solo puede mover en coordenadas donde existan fichas suyas";
		}
		piece.setProposedCoordinates(origin, destiny);
		return piece.validate(board, this);
	}
	
	public void victory() {
		new GestorIO().out("He ganado!! " + color + "\n");
		
	}
	
}

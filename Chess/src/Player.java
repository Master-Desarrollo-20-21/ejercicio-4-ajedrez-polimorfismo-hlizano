
public class Player {
	private String color;
	
	public Player(String color){
		this.color = color;	
	}
	
	public void movePiece(Board board) {
		new GestorIO().out("\nToca mover al jugador con fichas de color: " + color + "\n");		
		Coordinate origin = new Coordinate();
        Coordinate target = new Coordinate();
        Movement movement;
        String error = "";
        do {
            origin.position("Escoja la posición de la ficha que quiere mover \n");                     
            target.position("Escoja la posición donde quiere poner la ficha");  
    		Piece originPiece = board.getPiece(origin); 
    		Piece targetPiece = board.getPiece(target);
            movement = new Movement(board, originPiece, targetPiece, this.color);
            error = movement.validate();            
            if (!error.equals("")) {
                new GestorIO().out(error + "\n");
            }
        } while (!error.equals(""));	
		board.movePiece(origin, target);
	}
	
	public void victory() {
		new GestorIO().out("He ganado!! " + color + "\n");		
	}
	
}

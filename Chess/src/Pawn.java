public class Pawn extends Piece{
	
	public Pawn(char name, String color) {
		super(name,color);
	}	

	@Override
	protected String validate(Board board, Player player) {

		switch(this.getName()) {
		case 'P':
			return this.validateWhites(board, player);			
		case 'p':
			return this.validateBlacks(board, player);		
		}
		return "ERROR ficha inválida";
		
	}

	private String validateWhites(Board board, Player player) {
		if(originX + 1 == destinyX && originY == destinyY && board.getPiece(destiny).getName()=='_') {
			return "";
		}
		if(player.firstMovement() && originX + 2 == destinyX && originY == destinyY && board.getPiece(destiny).getName()=='_') {
			return "";
		}
		if(originX + 1 == destinyX && originY-1 == destinyY && board.getPiece(destiny).getColor().equals("black")) {
			return "";
		}
		if(originX + 1 == destinyX && originY+1 == destinyY && board.getPiece(destiny).getColor().equals("black")) {
			return "";
		}		
		return "ERROR a la hora de querer mover el peon blanco";
	}

	private String validateBlacks(Board board, Player player) {
		if(originX - 1 == destinyX && originY == destinyY && board.getPiece(destiny).getName()=='_') {
			return "";
		}
		if(player.firstMovement() && originX - 2 == destinyX && originY == destinyY && board.getPiece(destiny).getName()=='_') {
			return "";
		}
		if(originX - 1 == destinyX && originY-1 == destinyY && board.getPiece(destiny).getColor().equals("white")) {
			return "";
		}
		if(originX - 1 == destinyX && originY+1 == destinyY && board.getPiece(destiny).getColor().equals("white")) {
			return "";
		}		
		return "ERROR a la hora de querer mover el peon negro";
	}

}

public class Knight extends Piece{

	public Knight(char name, String color) {
		super(name,color);
	}

	@Override
	protected String validate(Board board, Player player) {
		if(originX-2  == destinyX && (originY-1 == destinyY || originY+1 == destinyY) && !board.getPiece(destiny).getColor().equals(color)) {
			return "";
		}	
		if(originX+2  == destinyX && (originY-1 == destinyY || originY+1 == destinyY) && !board.getPiece(destiny).getColor().equals(color)) {
			return "";
		}
		if(originX-1  == destinyX && (originY-2 == destinyY || originY+2 == destinyY) && !board.getPiece(destiny).getColor().equals(color)) {
			return "";
		}
		if(originX+1  == destinyX && (originY-2 == destinyY || originY+2 == destinyY) && !board.getPiece(destiny).getColor().equals(color)) {
			return "";
		}
		return "ERROR a la hora de querer mover el caballo";
	}	
}
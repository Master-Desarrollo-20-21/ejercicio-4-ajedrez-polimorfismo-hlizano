public class Bishop extends Piece{

	public Bishop(char name, String color, Coordinate coordinate) {
		super(name,color, coordinate);
	}
	

	@Override
	protected TargetPath validatePath(Piece targetPiece) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*

	@Override
	protected String validate(Board board) {
		String targetColor = board.getPiece(target).getColor();
		if(!origin.inDiagonal(target))
			return "Error!!! La ruta destino no está en diagonal con el origen";

		
		
		return null;
	}

	@Override
	protected String validate(String colorDestiny, Player player) {
		int diagonalDirection = origin.getDiagonalDirection(destiny);
		boolean freeRoad = false;

			
		if(diagonalDirection == 1) 
			freeRoad = this.isFreeDiagonalPathFirstQuad(board);
		if(diagonalDirection == 2) 
			freeRoad = this.isFreeDiagonalPathSecondQuad(board);
		if(diagonalDirection == 3) 
			freeRoad = this.isFreeDiagonalPathThirdQuad(board);
		if(diagonalDirection == 4) 
			freeRoad = this.isFreeDiagonalPathFourthQuad(board);
		
		if(freeRoad) 
			return "";
		else 
			return "Error, hay piezas en medio del camino";

	}

	private boolean isFreeDiagonalPathFirstQuad(Board board) {		
		int i = 1;
		while(originX-i>destinyX && originY+i<destinyY) {
			if(board.getPiece(new Coordinate(originX-i, originY+i)).getName()!='_') {
				return false;
			}
			i++;
		}
		return true;
	}
	
	private boolean isFreeDiagonalPathSecondQuad(Board board) {
		int i = 1;
		while(originX-i>destinyX && originY-i>destinyY) {
			if(board.getPiece(new Coordinate(originX-i, originY-i)).getName()!='_') {
				return false;
			}
			i++;
		}
		return true;
	}

	private boolean isFreeDiagonalPathThirdQuad(Board board) {
		int i = 1;
		while(originX+i<destinyX && originY-i>destinyY) {
			if(board.getPiece(new Coordinate(originX+i, originY-i)).getName()!='_') {
				return false;
			}
			i++;
		}
		return true;
	}

	private boolean isFreeDiagonalPathFourthQuad(Board board) {
		int i = 1;
		while(originX+i<destinyX && originY+i<destinyY) {
			if(board.getPiece(new Coordinate(originX+i, originY+i)).getName()!='_') {
				return false;
			}
			i++;
		}
		return true;
	}

*/

}

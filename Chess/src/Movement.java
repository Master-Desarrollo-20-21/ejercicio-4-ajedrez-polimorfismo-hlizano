
public class Movement {
	
	private Board board;
	private Piece originPiece; 
	private Piece targetPiece; 
	private String playerColor;
    
	public Movement(Board board, Piece origin, Piece target, String playerColor) {
	
		this.board = board;
		this.originPiece = origin;
		this.targetPiece = target;	
		this.playerColor = playerColor;
	}

	public String validate() {
 
		if (originPiece.color != this.playerColor) {
			return "Solo puede mover fichas suyas";
		}
		if (targetPiece.color == this.playerColor) {
			return "No puede mover a una casilla ocupada por otra ficha suya";
		}		
		TargetPath tp= originPiece.validatePath(targetPiece);
		return validateDirection(tp);
	}

	private String validateDirection(TargetPath tp) {
		switch(tp) {
		case INVALID:
			return "No es un moviento válido";			
		case NORTH:
			return north();		
		case SOUTH:
			return south();
		case EAST:
			return east();
		case WEST:
			return west();
		case NORTHEAST:
			return northEast();
		case NORTHWEST:
			return northWest();
		case SOUTHEAST:
			return southEast();			
		case SOUTHWEST:
			return southWest();
/*		
 * ***********se usan solo para el movimiento del caballo***********	
 * 
		case LNORTHEAST:
			return validateLNorthEastSquares();			
		case LNORTHWEST:
			return validateLNorthWestSquares();			
		case LWESTNORTH:
			return validateLWestNorthSquares();			
		case LWESTSOUTH:
			return validateLWestSouthSquares();			
		case LSOUTHWEST:
			return validateLSouthWestSquares();			
		case LSOUTHEAST:
			return validateLSouthEastSquares();			
		case LEASTNORTH:
			return validateLEsatNorthSquares();			
		case LEASTSOUTH:
			return validateLEastSouthSquares();
			
			*/
		default:
			return "Error desconocido";				
		}
	}

	private String southWest() {
		for(int i = 1; i < targetPiece.getCoordinate().getRow(); i++) {			
			if(board.getPiece(new Coordinate(originPiece.getCoordinate().getRow()+i, originPiece.getCoordinate().getColumn()-i)).getName()!='_') {
				return "Error!! hay piezas en medio";
			}
		}
		return "";
	}

	private String southEast() {
		for(int i = 1; i< targetPiece.getCoordinate().getRow(); i++) {			
			if(board.getPiece(new Coordinate(originPiece.getCoordinate().getRow()+i, originPiece.getCoordinate().getColumn()+i)).getName()!='_') {
				return "Error!! hay piezas en medio";
			}
		}
		return "";
	}

	private String northWest() {
		for(int i = 1; i > targetPiece.getCoordinate().getRow(); i--) {			
			if(board.getPiece(new Coordinate(originPiece.getCoordinate().getRow()-i, originPiece.getCoordinate().getColumn()-i)).getName()!='_') {
				return "Error!! hay piezas en medio";
			}
		}
		return "";
	}

	private String northEast() {		
		for(int i = 1; i > targetPiece.getCoordinate().getRow(); i--) {			
			if(board.getPiece(new Coordinate(originPiece.getCoordinate().getRow()-i, originPiece.getCoordinate().getColumn()+i)).getName()!='_') {
				return "Error!! hay piezas en medio";
			}
		}
		return "";
	}

	private String west() {
		for(int i = originPiece.getCoordinate().getColumn()-1; i > targetPiece.getCoordinate().getColumn(); i--) {
			int rowConstant = originPiece.getCoordinate().getRow();
			if(board.getPiece(new Coordinate(rowConstant, i)).getName()!='_') {
				return "Error!! hay piezas en medio";
			}
		}
		return "";
	}

	private String east() {
		for(int i = originPiece.getCoordinate().getColumn()+1; i < targetPiece.getCoordinate().getColumn(); i++) {
			int rowConstant = originPiece.getCoordinate().getRow();
			if(board.getPiece(new Coordinate(rowConstant, i)).getName()!='_') {
				return "Error!! hay piezas en medio";
			}
		}
		return "";
	}

	private String south() {
		for(int i = originPiece.getCoordinate().getRow()+1; i < targetPiece.getCoordinate().getRow(); i++) {
			int columnConstant = originPiece.getCoordinate().getColumn();
			if(board.getPiece(new Coordinate(i, columnConstant)).getName()!='_') {
				return "Error!! hay piezas en medio";
			}
		}
		return "";
	}

	private String north() {
		for(int i = originPiece.getCoordinate().getRow()-1; i > targetPiece.getCoordinate().getRow(); i--) {
			int columnConstant = originPiece.getCoordinate().getColumn();
			if(board.getPiece(new Coordinate(i, columnConstant)).getName()!='_') {
				return "Error!! hay piezas en medio";
			}
		}
		return "";
	}
	
}

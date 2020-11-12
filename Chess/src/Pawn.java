public class Pawn extends Piece{
	
	public Pawn(char name, String color, Coordinate coordinate) {
		super(name,color, coordinate);
	}	

	@Override
	protected TargetPath validatePath(Piece target) {
		
		switch(this.getName()) {
			case 'P':
				return this.validateWhites(target);			
			case 'p':
				return this.validateBlacks(target);		
		}
		return TargetPath.INVALID;		
	}

	private TargetPath validateWhites(Piece targetPiece) {
		
		Coordinate origin = this.getCoordinate();
		Coordinate target = targetPiece.getCoordinate();
		
		if(origin.equalColumn(target) && origin.getHorizontalDistance(target) == 1 && 
				!origin.isRowGreaterThan(target) && targetPiece.getName()=='_') {
			return TargetPath.SOUTH;
		}
		if(origin.doubleJumpWhitePawnMovement(target) && origin.inColumn(target) && targetPiece.getName()=='_') {
			return TargetPath.SOUTH;
		}
		if(origin.getHorizontalDistance(target) == 1 && !origin.isRowGreaterThan(target) && 
				origin.getVerticalDistance(target) == 1 && origin.getColumn()>target.getColumn() && 
				targetPiece.getColor().equals("black")) {
			return TargetPath.SOUTHWEST;
		}
		if(origin.getVerticalDistance(target) == 1 && !origin.isRowGreaterThan(target) && 
				origin.getHorizontalDistance(target) == 1 && origin.getColumn()<target.getColumn() && 
				targetPiece.getColor().equals("black")) {
			return TargetPath.SOUTHEAST;
		}
		return TargetPath.INVALID;		
	}

	private TargetPath validateBlacks(Piece targetPiece) {
		
		Coordinate origin = this.getCoordinate();
		Coordinate target = targetPiece.getCoordinate();
		
		if(origin.equalColumn(target) && origin.getHorizontalDistance(target) == 1 && 
				origin.isRowGreaterThan(target) && targetPiece.getName()=='_') {
			return TargetPath.NORTH;
		}
		if(origin.doubleJumpBlackPawnMovement(target) && origin.inColumn(target) && targetPiece.getName()=='_') {
			return TargetPath.NORTH;
		}
		if(origin.getHorizontalDistance(target) == 1 && origin.isRowGreaterThan(target) && 
				origin.getVerticalDistance(target) == 1 && origin.getColumn()>target.getColumn() && 
				targetPiece.getColor().equals("white")) {
			return TargetPath.NORTHWEST;
		}
		if(origin.getVerticalDistance(target) == 1 && origin.isRowGreaterThan(target) && 
				origin.getHorizontalDistance(target) == 1 && origin.getColumn()<target.getColumn() && 
				targetPiece.getColor().equals("white")) {
			return TargetPath.NORTHEAST;
		}
		return TargetPath.INVALID;
	}

}

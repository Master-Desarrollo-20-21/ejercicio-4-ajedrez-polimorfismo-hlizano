public class Rook extends Piece{

	public Rook(char name, String color, Coordinate coordinate) {
		super(name,color, coordinate);
	}
	
	@Override
	protected TargetPath validatePath(Piece targetPiece) {
		
		Coordinate origin = this.getCoordinate();
		Coordinate target = targetPiece.getCoordinate();
		if( origin.inRow(target) && !origin.inColumn(target)) {
			if(origin.getRow()<target.getRow())
				return TargetPath.SOUTH;
			return TargetPath.NORTH;
		}
		if( origin.inColumn(target) && !origin.inRow(target)) {
			if(origin.getColumn()<target.getColumn())
				return TargetPath.EAST;
			return TargetPath.WEST;
		}
		return TargetPath.INVALID;
	}
}
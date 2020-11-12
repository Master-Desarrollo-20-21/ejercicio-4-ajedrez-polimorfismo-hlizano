
public class EmptySquare extends Piece{

	public EmptySquare(char name, String color, Coordinate coordinate) {
		super(name,color, coordinate);
	}

	@Override
	protected TargetPath validatePath(Piece targetPiece) {
		// TODO Auto-generated method stub
		return null;
	}

}

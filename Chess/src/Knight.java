public class Knight extends Piece{

	public Knight(char name, String color, Coordinate coordinate) {
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
		if(origin.getHorizontalDistance(target) == 2 && origin.getVerticalDistance(target)== 1 && !targetColor.equals(color)) {
			return "";
		}
		if(origin.getHorizontalDistance(target) == 1 && origin.getVerticalDistance(target)== 2 && !targetColor.equals(color)) {
			return "";
		}
		return "ERROR a la hora de querer mover el caballo";
	}
*/
}
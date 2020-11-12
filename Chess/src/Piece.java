
public abstract class Piece {
	protected char name;
	protected String color;
	protected Coordinate coordinate;
	
	public Piece(char name, String color, Coordinate coordinate) {
		this.name = name;
		this.color = color;
		this.coordinate = coordinate;
	}
		
	public void show() {
		GestorIO gestorIO = new GestorIO();
		gestorIO.out(" " + name);		
	}
	
	protected abstract TargetPath validatePath(Piece targetPiece);
	
	public char getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
}

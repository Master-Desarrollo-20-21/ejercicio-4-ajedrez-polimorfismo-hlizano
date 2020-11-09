
public abstract class Piece {
	protected char name;
	protected String color;
	protected int originX;
	protected int originY;
	protected int destinyX;
	protected int destinyY;
	protected Coordinate destiny;
	protected Coordinate origin;
	
	public Piece() {
		
	}
	
	public Piece(char name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public Piece(Piece piece) {
		this.name = piece.name;
		this.color = piece.color;
	}
		
	public void show() {
		GestorIO gestorIO = new GestorIO();
		gestorIO.out(" " + name);		
	}
	
	public char getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}

	protected abstract String validate(Board board, Player player);

	public void setProposedCoordinates(Coordinate origin, Coordinate destiny) {
		this.originX = origin.getRow();
		this.originY = origin.getColumn();
		this.destinyX = destiny.getRow();
		this.destinyY = destiny.getColumn();
		this.destiny = destiny;
		this.origin = origin;
	}
	
	

}

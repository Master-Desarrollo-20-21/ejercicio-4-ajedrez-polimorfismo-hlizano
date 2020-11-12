
public class Coordinate {
	private int row;
	private int column;
	
	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public Coordinate() {
		// TODO Auto-generated constructor stub
	}

	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public boolean equal(Coordinate coordinate) {
		return this.equalRow(coordinate) && this.equalColumn(coordinate);
	}
	
	public boolean equalRow(Coordinate coordinate) {
		return this.row == coordinate.getRow();
	}
	
	public boolean equalColumn(Coordinate coordinate) {
		return this.column == coordinate.getColumn();
	}
	
	public boolean inRow(Coordinate coordinate){
		return this.row == coordinate.row;
	}
	
	public boolean inColumn(Coordinate coordinate){
		return this.column == coordinate.column;
	}
	
	public boolean inDiagonal(Coordinate coordinate){
        return  this.row - this.column == coordinate.row - coordinate.column ||
                this.row + this.column == coordinate.row + coordinate.column;
    }
	
	public int getHorizontalDistance(Coordinate coordinate) {
        return Math.abs(this.getRow() - coordinate.getRow());        
    }
	
	public int getVerticalDistance(Coordinate coordinate) {
        return Math.abs(this.getColumn() - coordinate.getColumn());
    }
	
	public boolean isRowGreaterThan(Coordinate coordinate) {
		return this.getRow()>coordinate.getRow();
	}
	
	public boolean isColumnGreaterThan(Coordinate coordinate) {
		return this.getColumn()>coordinate.getColumn();
	}
	
	public boolean doubleJumpWhitePawnMovement(Coordinate coordinate) {
		return this.getRow() == 1 && coordinate.getRow() == 3; 
	}
	
	public boolean doubleJumpBlackPawnMovement(Coordinate coordinate) {
		return this.getRow() == 6 && coordinate.getRow() == 4; 
	}

    public void position(String msg) {
        boolean error = false;
        do {
            GestorIO gestorIO = new GestorIO();
            gestorIO.out(msg);
            gestorIO.out("Introduce fila [1,8]: ");
            this.row = gestorIO.inInt();
            this.row--;
            gestorIO.out("Introduce columna [1,8]: ");
            this.column = gestorIO.inInt();
            this.column--;
            error = !this.isValid();
            if (error) {
                new GestorIO().out("Error!!! Valores fuera de rango\n");
            }
        } while (error);
    }
	
    private boolean isValid() {
        return 0 <= this.row && this.row <= 7 &&
        		0 <= this.column && this.column <= 7;
    }   
    
}

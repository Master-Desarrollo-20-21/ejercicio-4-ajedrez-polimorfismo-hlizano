
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
		return this.row == coordinate.getRow() && this.column == coordinate.getColumn();
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
    
    public int getDiagonalDirection(Coordinate destiny) {    	
    	if(this.row>destiny.row && this.column<destiny.column) {
    		return checkFirstQuadrant(destiny);    		
    	}
    	if(this.row>destiny.row && this.column>destiny.column) {
    		return checkSecondQuadrant(destiny);    		
    	}   
    	if(this.row<destiny.row && this.column>destiny.column) {
    		return checkThirdQuadrant(destiny);    		
    	} 
    	if(this.row<destiny.row && this.column<destiny.column) {
    		return checkFourthQuadrant(destiny);    		
    	} 
    	return 0;
    }

	private int checkFirstQuadrant(Coordinate destiny) {
		int i = 1;
		while(this.row-i>=0 && this.column+i<=7) {
			if(destiny.row == this.row-i && destiny.column == this.column+i)
				return 1;
			i++;
		}
		return 0;
	}

	private int checkSecondQuadrant(Coordinate destiny) {
		int i = 1;
		while(this.row-i>=0 && this.column-i>=0) {
			if(destiny.row == this.row-i && destiny.column == this.column-i)
				return 2;
			i++;
		}
		return 0;
	}
	
	private int checkThirdQuadrant(Coordinate destiny) {
		int i = 1;
		while(this.row+i<=7 && this.column-i>=0) {
			if(destiny.row == this.row+i && destiny.column == this.column-i)
				return 3;
			i++;
		}
		return 0;
	}

	private int checkFourthQuadrant(Coordinate destiny) {
		int i = 1;
		while(this.row+i<=7 && this.column-i<=7) {
			if(destiny.row == this.row+i && destiny.column == this.column+i)
				return 4;
			i++;
		}
		return 0;
	}

}

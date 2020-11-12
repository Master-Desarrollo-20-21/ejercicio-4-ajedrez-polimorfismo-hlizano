//import static util.Constants.A;


public class Board {

	private Piece[][] piece;
	
	public Board() {
		piece = new Piece[8][8];

		this.putEmptySquares();
		this.putPawns();
		this.putRooks();
		this.putKnights();
		this.putBishops();
		this.putQueens();
		this.putKings();
	}	

	private void putKings() {
		piece[0][3] = new King('K', "white", new Coordinate(0, 3));
		piece[7][3] =new King('k', "black", new Coordinate(7, 3));		
	}

	private void putQueens() {
		piece[0][4] = new Queen('Q', "white", new Coordinate(0, 4));
		piece[7][4] = new Queen('q', "black", new Coordinate(7, 4));		
	}

	private void putBishops() {
		piece[0][2] = new Bishop('B', "white", new Coordinate(0, 2));
		piece[0][5] = new Bishop('B', "white", new Coordinate(0, 5));
		piece[7][2] = new Bishop('b', "black", new Coordinate(7, 2));
		piece[7][5] = new Bishop('b', "black", new Coordinate(7, 5));		
	}

	private void putKnights() {
		piece[0][1] = new Knight('H', "white", new Coordinate(0, 1));
		piece[0][6] = new Knight('H', "white", new Coordinate(0, 6));
		piece[7][1] = new Knight('h', "black", new Coordinate(7, 1));
		piece[7][6] = new Knight('h', "black", new Coordinate(7, 6));
		
	}

	private void putRooks() {
		piece[0][0] = new Rook('R', "white", new Coordinate(0, 0));
		piece[0][7] = new Rook('R', "white", new Coordinate(0, 7));
		piece[7][0] = new Rook('r', "black", new Coordinate(7, 0));
		piece[7][7] = new Rook('r', "black", new Coordinate(7, 7));				
	}

	private void putPawns() {
		for(int i = 0; i<8; i++) {
			piece[1][i] = new Pawn('P', "white", new Coordinate(1, i));
			piece[6][i] = new Pawn('p', "black", new Coordinate(6, i));			
		}		
	}	
	
	private void putEmptySquares() {
		for(int i = 2; i<6; i++) {
			for(int j = 0; j<8; j++) {
				piece[i][j] = new EmptySquare('_', "none", new Coordinate(i, j));
			}			
		}		
	}	
	
	public void show() {
		GestorIO gestorIO = new GestorIO();
		gestorIO.out(" ");
		for(int i = 0; i<8; i++) {
			gestorIO.out(" ");
			gestorIO.out(i+1);
		}
		gestorIO.out("\n");
		for(int i = 0; i<8; i++) {
			gestorIO.out(i+1);
			for(int j = 0; j<8; j++) {
				piece[i][j].show();
			}
			gestorIO.out("\n");
		}		
	}

	public boolean isMate() {
		int kingQuantity = 0;
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				char piece = this.piece[i][j].getName();
				if(piece =='k' || piece == 'K') {
					kingQuantity++;
				} 
			}
		}
		return kingQuantity == 1;
	}

	public void movePiece(Coordinate origin, Coordinate target) {
		piece[target.getRow()][target.getColumn()] = piece[origin.getRow()][origin.getColumn()];
		piece[origin.getRow()][origin.getColumn()] = new EmptySquare('_', "none", new Coordinate(-1, -1));
	}

	public Piece getPiece(Coordinate coordinate) {		
		return piece[coordinate.getRow()][coordinate.getColumn()];
	}

}

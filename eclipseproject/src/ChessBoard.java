


public class ChessBoard {
	private ChessPiece[][] board;

	public ChessBoard() {
		board = new ChessPiece[8][8];
	}

	public void initialize() {
		// initializes the board to an 8X8 array with all empty squares. An empty square is null.

		// 8 white pawns
		Pawn[] wpawns = new Pawn[8];
		for(int i=0; i<8; i++) {
			wpawns[i] = new Pawn(this, ChessPiece.Color.WHITE);
			board[1][i] = wpawns[i];
			wpawns[i].setRow(1);
			wpawns[i].setColumn(i);
		}

		// 8 black pawns
		Pawn[] bpawns = new Pawn[8];
		for(int i=0; i<8; i++) {
			bpawns[i] = new Pawn(this, ChessPiece.Color.BLACK);
			board[6][i] = bpawns[i];
			bpawns[i].setRow(6);
			bpawns[i].setColumn(i);
		}

		// 2 white rooks
		Rook[] wrooks = new Rook[2];
		for(int i=0; i<2; i++) {
			wrooks[i] = new Rook(this, ChessPiece.Color.WHITE);
		}
		board[0][0] = wrooks[0];
		board[0][7] = wrooks[1];
		
		wrooks[0].setPosition("a1");
		wrooks[1].setPosition("h1");

		// 2 black rooks
		Rook[] brooks = new Rook[2];
		for(int i=0; i<2; i++) {
			brooks[i] = new Rook(this, ChessPiece.Color.BLACK);
		}
		board[7][0] = brooks[0];
		board[7][7] = brooks[1];
		brooks[0].setPosition("a8");
		brooks[1].setPosition("h8");

		// 2 white knights
		Knight[] wknights = new Knight[2];
		for(int i=0; i<2; i++) {
			wknights[i] = new Knight(this, ChessPiece.Color.WHITE);
		}
		board[0][1] = wknights[0];
		board[0][6] = wknights[1];
		
		wknights[0].setPosition("b1");
		wknights[1].setPosition("g1");

		// 2 black knights
		Knight[] bknights = new Knight[2];
		for(int i=0; i<2; i++) {
			bknights[i] = new Knight(this, ChessPiece.Color.BLACK);
		}
		board[7][1] = bknights[0];
		board[7][6] = bknights[1];
		
		bknights[0].setPosition("b8");
		bknights[1].setPosition("g8");
		

		// 2 white bishops
		Bishop[] wbishops = new Bishop[2];
		for(int i=0; i<2; i++) {
			wbishops[i] = new Bishop(this, ChessPiece.Color.WHITE);
		}
		board[0][2] = wbishops[0];
		board[0][5] = wbishops[1];
		
		wbishops[0].setPosition("c1");
		wbishops[1].setPosition("f1");

		// 2 black bishops
		Bishop[] bbishops = new Bishop[2];
		for(int i=0; i<2; i++) {
			bbishops[i] = new Bishop(this, ChessPiece.Color.BLACK);
		}
		board[7][2] = bbishops[0];
		board[7][5] = bbishops[1];
		
		bbishops[0].setPosition("c8");
		bbishops[1].setPosition("f8");

		// White and black Queen
		
		Queen wqueen = new Queen(this, ChessPiece.Color.WHITE);
		Queen bqueen = new Queen(this, ChessPiece.Color.BLACK);
		
		board[0][3] = wqueen;
		board[7][3] = bqueen;
		
		wqueen.setPosition("d1");
		bqueen.setPosition("d8");
		

		// White and black King
		
		King wking = new King(this, ChessPiece.Color.WHITE);;
		King bking = new King(this, ChessPiece.Color.BLACK);
		board[0][4] = wking;
		board[7][4] = bking;
		
		wking.setPosition("e1");
		bking.setPosition("e8");
	}

	public ChessPiece getPiece(String position) {
		// This method returns the chess piece at a given position.
		char letter = position.charAt(0);
		char digit = position.charAt(1);
		int row, column;
		switch(letter) {
		case 'a': column=0; break;
		case 'b': column=1; break;
		case 'c': column=2; break;
		case 'd': column=3; break;
		case 'e': column=4; break;
		case 'f': column=5; break;
		case 'g': column=6; break;
		case 'h': column=7; break;
		default: column=0;
		}
		row = digit -'0' -1;
		return board[row][column];
	}
	
	public boolean placePiece(ChessPiece piece, String position) {
		// This method tries to place the given piece at a given 
		// position, and returns true if successful, and false if 
		// there is already a piece in the given position.
		if(getPiece(position)!=null) return false;
		char letter = position.charAt(0);
		char digit = position.charAt(1);
		int row, column;
		switch(letter) {
		case 'a': column=0; break;
		case 'b': column=1; break;
		case 'c': column=2; break;
		case 'd': column=3; break;
		case 'e': column=4; break;
		case 'f': column=5; break;
		case 'g': column=6; break;
		case 'h': column=7; break;
		default: column=0;
		}
		row = digit -'0' -1;
		
		//<hajar>
		piece.setPosition(position);
		//</hajar>
		board[row][column] = piece;
		return true;
	}

	public boolean move(String fromPosition, String toPosition) {
		// This method checks if moving the piece from the 
		// fromPosition to toPosition is a legal move. Legality 
		// is defined based on the rules described above. If 
		// the move is legal, it executes the move, changing the 
		// value of the board as needed. The method returns true 
		// if the move was executed, and false otherwise.
		ChessPiece cp = getPiece(fromPosition);
		if(cp == null) {
			return false;
		} else {
			if (cp.legalMoves()!=null && cp.legalMoves().contains(toPosition)) {
				board[cp.getRow()][cp.getColumn()]=null;
				return placePiece(cp, toPosition);				
			}
		}
		return false;
	}

	public String toString(){
		String chess="";
		String upperLeft = "\u250C";
		String upperRight = "\u2510";
		String horizontalLine = "\u2500";
		String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
		String verticalLine = "\u2502";
		String upperT = "\u252C";
		String bottomLeft = "\u2514";
		String bottomRight = "\u2518";
		String bottomT = "\u2534";
		String plus = "\u253C";
		String leftT = "\u251C";
		String rightT = "\u2524";

		String topLine = upperLeft;

		for (int i = 0; i<7; i++){
		topLine += horizontal3 + upperT;
		}

		topLine += horizontal3 + upperRight;

		String bottomLine = bottomLeft;

		for (int i = 0; i<7; i++){			
		bottomLine += horizontal3 + bottomT;		
		}
		
		bottomLine += horizontal3 + bottomRight;		
		chess+=topLine + "\n";	

		for (int row = 7; row >=0; row--){			
			String midLine = "";			
			for (int col = 0; col < 8; col++){
				if(board[row][col]==null) {
					if((row+col)%2==0)
						midLine += "\u3000"+" B ";
					else
						midLine += "\u3000"+" W ";
			    } else {midLine += verticalLine + " "+board[row][col]+" ";}
			}

			midLine += verticalLine;
			String midLine2 = leftT;
			
			for (int i = 0; i<7; i++){
				midLine2 += horizontal3 + plus;
			}
			
			midLine2 += horizontal3 + rightT;
			chess+=midLine+ "\n";
			
			if(row>=1)
				chess+=midLine2+ "\n";
		}
		
		chess+=bottomLine;
		return chess;
	}
	
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();
		System.out.println(board.toString());
		board.initialize();
		System.out.println(board);
		board.move("c2", "c4");
		System.out.println(board.toString());
	}

}

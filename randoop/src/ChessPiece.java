import java.util.ArrayList;


public abstract class ChessPiece {

	public enum Color {WHITE, BLACK}

	protected ChessBoard board; // the board it belongs to, default null
	protected int row; // the index of the horizontal rows
	protected int column; // the index of the vertical column
	protected Color color; // the index of the piece

	public ChessPiece(ChessBoard board, Color color) { //This constructor sets the board and color attributes.
		this.board = board;
		this.color = color;
	}

	public int getRow() { // This method returns the row.
		return row;
	}

	public int getColumn() { // This method returns the column.
		return column;
	}

	public void setRow(int i) { // This method sets the row.
		//<hajar> if statement needed?
		//if(i>=0 && i<8)
			this.row = i;
	}

	public void setColumn(int i) { // This method sets the column.
		//<hajar> if statement needed?
		//if(i>=0 && i<8)
			this.column = i;
	}

	public Color getColor() { // 	This method returns the color of the piece. 
		//There is no need for a setColor method because a piece cannot change color.
		return color;
	}

	public String getPosition() { // This method returns the position of the piece in the format single letter (a..h) followed by a single digit (1..8).
		char letter;
		switch(column) {
		case 0: letter='a'; break;
		case 1: letter='b'; break;
		case 2: letter='c'; break;
		case 3: letter='d'; break;
		case 4: letter='e'; break;
		case 5: letter='f'; break;
		case 6: letter='g'; break;
		case 7: letter='h'; break;
		default: letter=' ';
		}
		return new String(""+ letter + (row+1));
	}
	
	public void setPosition(String position) { // This method sets the position of the piece to the appropriate row and column based on the argument, which in the format single letter (a..h) followed by a single digit (1..8).
		char letter = position.charAt(0);
		char digit = position.charAt(1);
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
	}
	
	//<hajar>
	protected String onePossibleMove(int row,int column){
		String returnString = "";
		if(column>=0 && column<=7){		
			if(row>=0 && row <=7){
				char columnChar = (char) ('a' + column);
				char rowChar = (char)('1'+row);
				StringBuilder sb = new StringBuilder();
				sb.append(columnChar);
				sb.append(rowChar);
				return returnString+sb.toString();
			}
		}
		return null;
	}
	
	abstract public String toString();
	//This method will be implemented in the concrete subclasses corresponding to each chess piece. This method returns a String composed of a single character that corresponds to which piece it is. In the unicode character encoding scheme there are characters that represent each chess piece.

	abstract public ArrayList<String> legalMoves();
	//This method will be implemented in the concrete subclasses corresponding to each chess piece. This method returns all the legal moves that piece can make based on the rules described above in the assignment.
}

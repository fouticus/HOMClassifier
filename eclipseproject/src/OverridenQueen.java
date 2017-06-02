import java.util.ArrayList;


public class OverridenQueen extends Queen {

	public OverridenQueen(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(color==Color.WHITE)
			return "\u2655";
		else
			return "\u265B";
	}

	@Override
	public ArrayList<String> legalMoves() {
		return new ArrayList<String>();
	}
	
	@Override
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
	@Override	
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
	

}

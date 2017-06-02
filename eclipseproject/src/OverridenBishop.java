import java.util.ArrayList;


public class OverridenBishop extends Bishop {

	public OverridenBishop(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(color==Color.WHITE)
			return "\u2657";
		else
			return "\u265D";
	}

	@Override
	public ArrayList<String> legalMoves() {
		ArrayList<String> returnList = new ArrayList<String>();
		
		//<hajar> simplified this code		
		
		String position;
		
		int[] horDirection =  { 1,1,-1,-1 };
		int[] verDirection =  { 1,-1,+1,-1 };
		
		for (int direction = 0 ; direction < 4 ; direction++)
		{
			for(int OffSet=1;OffSet<=7;OffSet++){
				int rowPos;
				int colPos;
					
				rowPos = this.getRow() + ( OffSet * horDirection[direction]  )  ;
				colPos = this.getColumn()+ ( OffSet  * verDirection[direction] ) ;
				
				position=onePossibleMove(rowPos, colPos);
				if(position!=null){
					if(board.getPiece(position)!=null){
						if(board.getPiece(position).getColor().equals(this.getColor())){
							break;
						}else{
							returnList.add(onePossibleMove(rowPos, colPos));
							break;
						}
					}else{
						returnList.add(onePossibleMove(rowPos, colPos));	
					}
				}
			}
		
		}
		
		return returnList;
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
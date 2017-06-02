import java.util.ArrayList;


public class Pawn extends ChessPiece {

	public Pawn(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(color==ChessPiece.Color.WHITE)
			return "\u2659";
		else
			return "\u265F";
	}

	@Override
	public ArrayList<String> legalMoves() {
		ArrayList<String> returnList = new ArrayList<String>();
		if(this.getColor().equals(ChessPiece.Color.WHITE)){
			//white pawn always moves up
			int currentCol = this.getColumn();
			int nextRow = this.getRow()+1;
			
			if(nextRow<=7){
				if(board.getPiece(onePossibleMove(nextRow, currentCol))==null){
					returnList.add(onePossibleMove(nextRow, currentCol));
				}				
			}
			
			
			if(this.getRow()==1){
				//opening move, 2 movements are allowed.
				int nextNextRow = this.getRow()+2;
				
				if(board.getPiece(onePossibleMove(nextRow, currentCol))==null && board.getPiece(onePossibleMove(nextNextRow,currentCol))==null){
					//both in front are empty. forward movement possible. 
					returnList.add(onePossibleMove(nextNextRow, currentCol));
				}
			}
			
			int leftColumn = currentCol-1;
			int rightColumn = currentCol+1;
			if(leftColumn>=0){
				if(board.getPiece(onePossibleMove(nextRow, leftColumn))!=null){
					if(!board.getPiece(onePossibleMove(nextRow, leftColumn)).getColor().equals(this.getColor())){
						//This piece can be taken out
						returnList.add(onePossibleMove(nextRow, leftColumn));
					}
				}
			}
			if(rightColumn<=7){
				if(board.getPiece(onePossibleMove(nextRow, rightColumn))!=null){
					if(!board.getPiece(onePossibleMove(nextRow, rightColumn)).getColor().equals(this.getColor())){
						//This piece can be taken out
						returnList.add(onePossibleMove(nextRow, rightColumn));
					}
				}
			}			
			
			
		}else{
			//Black pawn always moves down
			int currentCol = this.getColumn();
			int nextRow = this.getRow()-1;
			
			if(nextRow>=0){
				if(board.getPiece(onePossibleMove(nextRow, currentCol))==null){
					returnList.add(onePossibleMove(nextRow, currentCol));
				}				
			}
			
			
			if(this.getRow()==6){
				//opening move, 2 movements are allowed.
				int nextNextRow = this.getRow()-2;
				if(board.getPiece(onePossibleMove(nextRow, currentCol))==null && board.getPiece(onePossibleMove(nextNextRow, currentCol))==null){
					//both in front are empty. forward movement possible. 
					returnList.add(onePossibleMove(nextNextRow, currentCol));
				}
			}
			
			int leftColumn = currentCol-1;
			int rightColumn = currentCol+1;
			if(leftColumn>=0){
				if(board.getPiece(onePossibleMove(nextRow, leftColumn))!=null){
					if(!board.getPiece(onePossibleMove(nextRow, leftColumn)).getColor().equals(this.getColor())){
						//This piece can be taken out
						returnList.add(onePossibleMove(nextRow, leftColumn));
					}
				}
			}
			if(rightColumn<=7){
				if(board.getPiece(onePossibleMove(nextRow, rightColumn))!=null){
					if(!board.getPiece(onePossibleMove(nextRow, rightColumn)).getColor().equals(this.getColor())){
						//This piece can be taken out
						returnList.add(onePossibleMove(nextRow, rightColumn));
					}
				}
			}			

		}
		return returnList;
	}
	


}

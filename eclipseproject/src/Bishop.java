import java.util.ArrayList;


public class Bishop extends ChessPiece {

	public Bishop(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(color==ChessPiece.Color.WHITE)
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

}

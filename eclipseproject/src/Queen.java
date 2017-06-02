import java.util.ArrayList;


public class Queen extends ChessPiece {

	public Queen(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(color==ChessPiece.Color.WHITE)
			return "\u2655";
		else
			return "\u265B";
	}

	@Override
	public ArrayList<String> legalMoves() {
		return new ArrayList<String>();
	}

}

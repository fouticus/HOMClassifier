import java.util.ArrayList;

public class Knight extends ChessPiece {

	public Knight(ChessBoard board, ChessPiece.Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(color==ChessPiece.Color.WHITE)
			return "\u2658";
		else
			return "\u265E";
	}

	@Override
	public ArrayList<String> legalMoves() {
		return new ArrayList<String>();
	}

}

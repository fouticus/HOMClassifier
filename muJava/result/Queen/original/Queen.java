// This is a mutant program.
// Author : ysma

import java.util.ArrayList;


public class Queen extends ChessPiece
{

    public Queen( ChessBoard board, ChessPiece.Color color )
    {
        super( board, color );
    }

    public  java.lang.String toString()
    {
        if (color == ChessPiece.Color.WHITE) {
            return "♕";
        } else {
            return "♛";
        }
    }

    public  java.util.ArrayList<String> legalMoves()
    {
        return new java.util.ArrayList<String>();
    }

}

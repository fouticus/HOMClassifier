// This is a mutant program.
// Author : ysma

import java.util.ArrayList;


public class Pawn extends ChessPiece
{

    public Pawn( ChessBoard board, ChessPiece.Color color )
    {
        super( board, color );
    }

    public  java.lang.String toString()
    {
        if (color == ChessPiece.Color.WHITE) {
            return "♙";
        } else {
            return "♟";
        }
    }

    public  java.util.ArrayList<String> legalMoves()
    {
        java.util.ArrayList<String> returnList = new java.util.ArrayList<String>();
        return returnList;
    }

}

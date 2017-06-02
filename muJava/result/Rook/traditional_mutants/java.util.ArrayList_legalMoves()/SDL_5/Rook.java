// This is a mutant program.
// Author : ysma

import java.util.ArrayList;


public class Rook extends ChessPiece
{

    public Rook( ChessBoard board, ChessPiece.Color color )
    {
        super( board, color );
    }

    public  java.lang.String toString()
    {
        if (color == ChessPiece.Color.WHITE) {
            return "♖";
        } else {
            return "♜";
        }
    }

    public  java.util.ArrayList<String> legalMoves()
    {
        java.util.ArrayList<String> returnList = new java.util.ArrayList<String>();
        java.lang.String position;
        int[] horDirection = { -1, +1, 0, 0 };
        int[] verDirection = { 0, 0, -1, +1 };
        return returnList;
    }

}

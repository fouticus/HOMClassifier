// This is a mutant program.
// Author : ysma

import java.util.ArrayList;


public class Knight extends ChessPiece
{

    public Knight( ChessBoard board, ChessPiece.Color color )
    {
        super( board, color );
    }

    public  java.lang.String toString()
    {
        if (true) {
            return "♘";
        } else {
            return "♞";
        }
    }

    public  java.util.ArrayList<String> legalMoves()
    {
        return new java.util.ArrayList<String>();
    }

}

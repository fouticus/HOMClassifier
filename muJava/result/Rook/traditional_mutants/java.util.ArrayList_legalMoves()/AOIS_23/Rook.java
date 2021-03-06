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
        for (int direction = 0; direction < 4; direction++) {
            for (int OffSet = 1; OffSet <= 7; OffSet++) {
                int rowPos;
                int colPos;
                rowPos = this.getRow() + horDirection[direction] * OffSet;
                colPos = this.getColumn() + verDirection[direction] * OffSet++;
                position = onePossibleMove( rowPos, colPos );
                if (onePossibleMove( rowPos, colPos ) != null) {
                    if (board.getPiece( position ) != null) {
                        if (board.getPiece( position ).getColor().equals( this.getColor() )) {
                            break;
                        } else {
                            returnList.add( onePossibleMove( rowPos, colPos ) );
                            break;
                        }
                    } else {
                        returnList.add( onePossibleMove( rowPos, colPos ) );
                    }
                }
            }
        }
        return returnList;
    }

}

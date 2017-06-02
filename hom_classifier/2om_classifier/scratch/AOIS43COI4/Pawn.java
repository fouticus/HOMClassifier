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
        if (this.getColor().equals( ChessPiece.Color.WHITE )) {
            int currentCol = this.getColumn();
            int nextRow = this.getRow() + 1;
            if (nextRow <= 7) {
                if (board.getPiece( onePossibleMove( nextRow, currentCol ) ) == null) {
                    returnList.add( onePossibleMove( nextRow, currentCol ) );
                }
            }
            if (!(this.getRow() == 1)) {
                int nextNextRow = this.getRow() + 2;
                if (board.getPiece( onePossibleMove( nextRow, currentCol ) ) == null && board.getPiece( onePossibleMove( nextNextRow, currentCol ) ) == null) {
                    returnList.add( onePossibleMove( nextNextRow, currentCol ) );
                }
            }
            int leftColumn = currentCol - 1;
            int rightColumn = currentCol++ + 1;
            if (leftColumn >= 0) {
                if (board.getPiece( onePossibleMove( nextRow, leftColumn ) ) != null) {
                    if (!board.getPiece( onePossibleMove( nextRow, leftColumn ) ).getColor().equals( this.getColor() )) {
                        returnList.add( onePossibleMove( nextRow, leftColumn ) );
                    }
                }
            }
            if (rightColumn <= 7) {
                if (board.getPiece( onePossibleMove( nextRow, rightColumn ) ) != null) {
                    if (!board.getPiece( onePossibleMove( nextRow, rightColumn ) ).getColor().equals( this.getColor() )) {
                        returnList.add( onePossibleMove( nextRow, rightColumn ) );
                    }
                }
            }
        } else {
            int currentCol = this.getColumn();
            int nextRow = this.getRow() - 1;
            if (nextRow >= 0) {
                if (board.getPiece( onePossibleMove( nextRow, currentCol ) ) == null) {
                    returnList.add( onePossibleMove( nextRow, currentCol ) );
                }
            }
            if (this.getRow() == 6) {
                int nextNextRow = this.getRow() - 2;
                if (board.getPiece( onePossibleMove( nextRow, currentCol ) ) == null && board.getPiece( onePossibleMove( nextNextRow, currentCol ) ) == null) {
                    returnList.add( onePossibleMove( nextNextRow, currentCol ) );
                }
            }
            int leftColumn = currentCol - 1;
            int rightColumn = currentCol + 1;
            if (leftColumn >= 0) {
                if (board.getPiece( onePossibleMove( nextRow, leftColumn ) ) != null) {
                    if (!board.getPiece( onePossibleMove( nextRow, leftColumn ) ).getColor().equals( this.getColor() )) {
                        returnList.add( onePossibleMove( nextRow, leftColumn ) );
                    }
                }
            }
            if (rightColumn <= 7) {
                if (board.getPiece( onePossibleMove( nextRow, rightColumn ) ) != null) {
                    if (!board.getPiece( onePossibleMove( nextRow, rightColumn ) ).getColor().equals( this.getColor() )) {
                        returnList.add( onePossibleMove( nextRow, rightColumn ) );
                    }
                }
            }
        }
        return returnList;
    }

}
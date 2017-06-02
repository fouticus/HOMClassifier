// This is a mutant program.
// Author : ysma

import java.util.ArrayList;


public abstract class ChessPiece
{

    public enum Color 
    {
        WHITE,
        BLACK;

    }

    protected ChessBoard board;

    protected int row;

    protected int column;

    protected ChessPiece.Color color;

    public ChessPiece( ChessBoard board, ChessPiece.Color color )
    {
        this.board = board;
        this.color = color;
    }

    public  int getRow()
    {
        return row;
    }

    public  int getColumn()
    {
        return column;
    }

    public  void setRow( int i )
    {
        this.row = i;
    }

    public  void setColumn( int i )
    {
        this.column = i;
    }

    public  ChessPiece.Color getColor()
    {
        return color;
    }

    public  java.lang.String getPosition()
    {
        char letter;
        switch (column) {
        case 0 :
            letter = 'a';
            break;

        case 1 :
            letter = 'b';
            break;

        case 2 :
            letter = 'c';
            break;

        case 3 :
            letter = 'd';
            break;

        case 4 :
            letter = 'e';
            break;

        case 5 :
            letter = 'f';
            break;

        case 6 :
            letter = 'g';
            break;

        case 7 :
            letter = 'h';
            break;

        default  :
            letter = ' ';

        }
        return new java.lang.String( "" + letter + (row + 1) );
    }

    public  void setPosition( java.lang.String position )
    {
        char letter = position.charAt( 0 );
        char digit = position.charAt( 1 );
        switch (letter) {
        case 'a' :
            column = 0;
            break;

        case 'b' :
            column = 1;
            break;

        case 'c' :
            column = 2;
            break;

        case 'd' :
            column = 3;
            break;

        case 'e' :
            column = 4;

        case 'f' :
            column = 5;
            break;

        case 'g' :
            column = 6;
            break;

        case 'h' :
            column = 7;
            break;

        default  :
            column = 0;

        }
        row = digit - '0' - 1;
    }

    protected  java.lang.String onePossibleMove( int row, int column )
    {
        java.lang.String returnString = "";
        if (column >= 0 && column <= 7) {
            if (row >= 0 && row <= 7) {
                char columnChar = (char) ('a' + column);
                char rowChar = (char) ('1' + row);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append( columnChar );
                sb.append( rowChar );
                return returnString + sb.toString();
            }
        }
        return null;
    }

    public abstract  java.lang.String toString();

    public abstract  java.util.ArrayList<String> legalMoves();

}

// This is a mutant program.
// Author : ysma

public class ChessBoard
{

    private ChessPiece[][] board;

    public ChessBoard()
    {
        board = new ChessPiece[8][8];
    }

    public  void initialize()
    {
        Pawn[] wpawns = new Pawn[8];
        Pawn[] bpawns = new Pawn[8];
        for (int i = 0; i < 8; i++) {
            bpawns[i] = new Pawn( this, ChessPiece.Color.BLACK );
            board[6][i] = bpawns[i];
            bpawns[i].setRow( 6 );
            bpawns[i].setColumn( i );
        }
        Rook[] wrooks = new Rook[2];
        for (int i = 0; i < 2; i++) {
            wrooks[i] = new Rook( this, ChessPiece.Color.WHITE );
        }
        board[0][0] = wrooks[0];
        board[0][7] = wrooks[1];
        wrooks[0].setPosition( "a1" );
        wrooks[1].setPosition( "h1" );
        Rook[] brooks = new Rook[2];
        for (int i = 0; i < 2; i++) {
            brooks[i] = new Rook( this, ChessPiece.Color.BLACK );
        }
        board[7][0] = brooks[0];
        board[7][7] = brooks[1];
        brooks[0].setPosition( "a8" );
        brooks[1].setPosition( "h8" );
        Knight[] wknights = new Knight[2];
        for (int i = 0; i < 2; i++) {
            wknights[i] = new Knight( this, ChessPiece.Color.WHITE );
        }
        board[0][1] = wknights[0];
        board[0][6] = wknights[1];
        wknights[0].setPosition( "b1" );
        wknights[1].setPosition( "g1" );
        Knight[] bknights = new Knight[2];
        for (int i = 0; i < 2; i++) {
            bknights[i] = new Knight( this, ChessPiece.Color.BLACK );
        }
        board[7][1] = bknights[0];
        board[7][6] = bknights[1];
        bknights[0].setPosition( "b8" );
        bknights[1].setPosition( "g8" );
        Bishop[] wbishops = new Bishop[2];
        for (int i = 0; i < 2; i++) {
            wbishops[i] = new Bishop( this, ChessPiece.Color.WHITE );
        }
        board[0][2] = wbishops[0];
        board[0][5] = wbishops[1];
        wbishops[0].setPosition( "c1" );
        wbishops[1].setPosition( "f1" );
        Bishop[] bbishops = new Bishop[2];
        for (int i = 0; i < 2; i++) {
            bbishops[i] = new Bishop( this, ChessPiece.Color.BLACK );
        }
        board[7][2] = bbishops[0];
        board[7][5] = bbishops[1];
        bbishops[0].setPosition( "c8" );
        bbishops[1].setPosition( "f8" );
        Queen wqueen = new Queen( this, ChessPiece.Color.WHITE );
        Queen bqueen = new Queen( this, ChessPiece.Color.BLACK );
        board[0][3] = wqueen;
        board[7][3] = bqueen;
        wqueen.setPosition( "d1" );
        bqueen.setPosition( "d8" );
        King wking = new King( this, ChessPiece.Color.WHITE );
        ;
        King bking = new King( this, ChessPiece.Color.BLACK );
        board[0][4] = wking;
        board[7][4] = bking;
        wking.setPosition( "e1" );
        bking.setPosition( "e8" );
    }

    public  ChessPiece getPiece( java.lang.String position )
    {
        char letter = position.charAt( 0 );
        char digit = position.charAt( 1 );
        int row;
        int column;
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
            break;

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
        return board[row][column];
    }

    public  boolean placePiece( ChessPiece piece, java.lang.String position )
    {
        if (getPiece( position ) != null) {
            return false;
        }
        char letter = position.charAt( 0 );
        char digit = position.charAt( 1 );
        int row;
        int column;
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
            break;

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
        piece.setPosition( position );
        board[row][column] = piece;
        return true;
    }

    public  boolean move( java.lang.String fromPosition, java.lang.String toPosition )
    {
        ChessPiece cp = getPiece( fromPosition );
        if (cp == null) {
            return false;
        } else {
            if (cp.legalMoves() != null && cp.legalMoves().contains( toPosition )) {
                board[cp.getRow()][cp.getColumn()] = null;
                return placePiece( cp, toPosition );
            }
        }
        return false;
    }

    public  java.lang.String toString()
    {
        java.lang.String chess = "";
        java.lang.String upperLeft = "┌";
        java.lang.String upperRight = "┐";
        java.lang.String horizontalLine = "─";
        java.lang.String horizontal3 = horizontalLine + "　" + horizontalLine;
        java.lang.String verticalLine = "│";
        java.lang.String upperT = "┬";
        java.lang.String bottomLeft = "└";
        java.lang.String bottomRight = "┘";
        java.lang.String bottomT = "┴";
        java.lang.String plus = "┼";
        java.lang.String leftT = "├";
        java.lang.String rightT = "┤";
        java.lang.String topLine = upperLeft;
        for (int i = 0; i < 7; i++) {
            topLine += horizontal3 + upperT;
        }
        topLine += horizontal3 + upperRight;
        java.lang.String bottomLine = bottomLeft;
        for (int i = 0; i < 7; i++) {
            bottomLine += horizontal3 + bottomT;
        }
        bottomLine += horizontal3 + bottomRight;
        chess += topLine + "\n";
        for (int row = 7; row >= 0; row--) {
            java.lang.String midLine = "";
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == null) {
                    if ((row + col) % 2 == 0) {
                        midLine += "　" + " B ";
                    } else {
                        midLine += "　" + " W ";
                    }
                } else {
                    midLine += verticalLine + " " + board[row][col] + " ";
                }
            }
            midLine += verticalLine;
            java.lang.String midLine2 = leftT;
            for (int i = 0; i < 7; i++) {
                midLine2 += horizontal3 + plus;
            }
            midLine2 += horizontal3 + rightT;
            chess += midLine + "\n";
            if (row >= 1) {
                chess += midLine2 + "\n";
            }
        }
        chess += bottomLine;
        return chess;
    }

    public static  void main( java.lang.String[] args )
    {
        ChessBoard board = new ChessBoard();
        System.out.println( board.toString() );
        board.initialize();
        System.out.println( board );
        board.move( "c2", "c4" );
        System.out.println( board.toString() );
    }

}

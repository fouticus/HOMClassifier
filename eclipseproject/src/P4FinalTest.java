import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author SHAIKHSHAWON
 *
 */
public class P4FinalTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P4FinalTest p4FinalTest = new P4FinalTest();
		
		
		/*for(int i=0;i<=19;i++){
			System.err.println();			
			System.err.println("Test "+i);
			System.err.println();			
			p4FinalTest.runTest(i);
		}*/
		
		p4FinalTest.runTest(Integer.parseInt(args[0]));
	}

	public void runTest(int testNumber) {
		
		Class chessBoard = null;
		try {
			// check whether the class exits
			chessBoard = Class.forName("ChessBoard");
		} catch (ClassNotFoundException e) {
			System.err.println("Cannot find the ChessBoard.class. Please check the class name");
			System.exit(0);
		}
		
		Class chessPiece = null;
		try {
			// check whether the class exits
			chessPiece = Class.forName("ChessPiece");
		} catch (ClassNotFoundException e) {
			System.err.println("Cannot find the ChessPiece.class. Please check the class name");
			System.exit(0);
		}
		
		switch(testNumber){
	      case 0:{	    	
	    	//check board field type in ChessBoard
	    	System.err.println(fieldCheck(chessBoard, "board", ChessPiece[][].class));
	    	
	    	break;
	      }
	      case 1:{		    	
	    	//check field types in ChessPiece
	    	System.err.println(fieldCheck(chessPiece, "board", ChessBoard.class));
	    	System.err.println(fieldCheck(chessPiece, "row", int.class));
	    	System.err.println(fieldCheck(chessPiece, "column", int.class));
	    	System.err.println(fieldCheck(chessPiece, "color", ChessPiece.Color.class));
	    	
	    	break;
	      }
	    
	       case 2:{
	    	//test chessPiece Constructor
	    	
	       }
			case 3:{
				/*Testing Bishop toString(). 
				 * 
				 */
				//<hajar>
				ChessBoard testCase3_chessBoard=new ChessBoard();
				//</hajar>
				Bishop testCase3_chessPiece1 = new Bishop(testCase3_chessBoard, ChessPiece.Color.WHITE);
				testCase3_chessPiece1.setRow(2);
				testCase3_chessPiece1.setColumn(3);
				Bishop testCase3_chessPiece2 = new Bishop(testCase3_chessBoard,ChessPiece.Color.BLACK);
				testCase3_chessPiece2.setRow(4);
				testCase3_chessPiece2.setColumn(5);
				StringBuilder returnChar1 = new StringBuilder();
				returnChar1.append('\u2657');
				StringBuilder returnChar2 = new StringBuilder();
				returnChar2.append('\u265D');
				String chessPiece1_toString = returnChar1.toString();
				String chessPiece2_toString = returnChar2.toString();
				
				if(chessPiece1_toString.equals(testCase3_chessPiece1.toString())){
					System.err.println("toString for Black Bishop");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for Black Bishop");
					System.err.println("returns:"+testCase3_chessPiece1.toString());
					System.err.println("Should return:"+chessPiece1_toString);
				}
				
				
				if(chessPiece2_toString.equals(testCase3_chessPiece2.toString())){
					System.err.println("toString for White Bishop");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for White Bishop");
					System.err.println("returns:"+testCase3_chessPiece2.toString());
					System.err.println("Should return:"+chessPiece2_toString);
				}

			}
			break;
			case 4:{

				/*Testing King toString(). 
				 * 
				 */
				//<hajar>
				ChessBoard testCase4_chessBoard=new ChessBoard();
				//</hajar>
				King testCase4_chessPiece1 = new King(testCase4_chessBoard,ChessPiece.Color.WHITE);
				testCase4_chessPiece1.setRow(2); 
				testCase4_chessPiece1.setColumn(3);
				King testCase4_chessPiece2 = new King(testCase4_chessBoard,ChessPiece.Color.BLACK);
				testCase4_chessPiece1.setRow(4);
				testCase4_chessPiece1.setColumn(5);
				StringBuilder returnChar1 = new StringBuilder();
				returnChar1.append('\u2654');
				StringBuilder returnChar2 = new StringBuilder();
				returnChar2.append('\u265A');
				String chessPiece1_toString = returnChar1.toString();
				String chessPiece2_toString = returnChar2.toString();
				
				if(chessPiece1_toString.equals(testCase4_chessPiece1.toString())){
					System.err.println("toString for Black King");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for Black King");
					System.err.println("returns:"+testCase4_chessPiece1.toString());
					System.err.println("Should return:"+chessPiece1_toString);
				}
				
				
				if(chessPiece2_toString.equals(testCase4_chessPiece2.toString())){
					System.err.println("toString for White King");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for White King");
					System.err.println("returns:"+testCase4_chessPiece2.toString());
					System.err.println("Should return:"+chessPiece2_toString);
				}


			}
			break;
			case 5:{

				/*Testing Queen toString(). 
				 * 
				 */
				//<hajar>
				ChessBoard testCase5_chessBoard=new ChessBoard();
				//</hajar>
				Queen testCase5_chessPiece1 = new Queen(testCase5_chessBoard,ChessPiece.Color.WHITE);
				testCase5_chessPiece1.setRow(2);
				testCase5_chessPiece1.setColumn(3);
				Queen testCase5_chessPiece2 = new Queen(testCase5_chessBoard,ChessPiece.Color.BLACK);
				testCase5_chessPiece2.setRow(4);
				testCase5_chessPiece2.setColumn(5);
				StringBuilder returnChar1 = new StringBuilder();
				returnChar1.append('\u2655');
				StringBuilder returnChar2 = new StringBuilder();
				returnChar2.append('\u265B');
				String chessPiece1_toString = returnChar1.toString();
				String chessPiece2_toString = returnChar2.toString();
				
				if(chessPiece1_toString.equals(testCase5_chessPiece1.toString())){
					System.err.println("toString for Black Queen");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for Black Queen");
					System.err.println("returns:"+testCase5_chessPiece1.toString());
					System.err.println("Should return:"+chessPiece1_toString);
				}
				
				
				if(chessPiece2_toString.equals(testCase5_chessPiece2.toString())){
					System.err.println("toString for White Queen");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for White Queen");
					System.err.println("returns:"+testCase5_chessPiece2.toString());
					System.err.println("Should return:"+chessPiece2_toString);
				}

			}
			break;
			case 6:{

				/*Testing Knight toString(). 
				 * 
				 */
				//<hajar>
				ChessBoard testCase6_chessBoard=new ChessBoard();
				//</hajar>
				Knight testCase6_chessPiece1 = new Knight(testCase6_chessBoard,ChessPiece.Color.WHITE);
				testCase6_chessPiece1.setRow(2);
				testCase6_chessPiece1.setColumn(3);
				Knight testCase6_chessPiece2 = new Knight(testCase6_chessBoard,ChessPiece.Color.BLACK);
				testCase6_chessPiece2.setRow(4); 
				testCase6_chessPiece2.setColumn(5); 
				StringBuilder returnChar1 = new StringBuilder();
				returnChar1.append('\u2658');
				StringBuilder returnChar2 = new StringBuilder();
				returnChar2.append('\u265E');
				String chessPiece1_toString = returnChar1.toString();
				String chessPiece2_toString = returnChar2.toString();
				
				if(chessPiece1_toString.equals(testCase6_chessPiece1.toString())){
					System.err.println("toString for Black Knight");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for Black Knight");
					System.err.println("returns:"+testCase6_chessPiece2.toString());
					System.err.println("Should return:"+chessPiece1_toString);
				}
				
				
				if(chessPiece2_toString.equals(testCase6_chessPiece2.toString())){
					System.err.println("toString for White Knight");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for White Knight");
					System.err.println("returns:"+testCase6_chessPiece2.toString());
					System.err.println("Should return:"+chessPiece2_toString);
				}

			}
			break;
			case 7:{

				/*Testing Pawn toString(). 
				 * 
				 */
				//<hajar>
				ChessBoard testCase7_chessBoard=new ChessBoard();
				//</hajar>
				Pawn testCase7_chessPiece1 = new Pawn(testCase7_chessBoard,ChessPiece.Color.WHITE);
				testCase7_chessPiece1.setRow(2); 
				testCase7_chessPiece1.setColumn(3); 
				Pawn testCase7_chessPiece2 = new Pawn(testCase7_chessBoard,ChessPiece.Color.BLACK);
				testCase7_chessPiece2.setRow(4);
				testCase7_chessPiece2.setColumn(5);
				StringBuilder returnChar1 = new StringBuilder();
				returnChar1.append('\u2659');
				StringBuilder returnChar2 = new StringBuilder();
				returnChar2.append('\u265F');
				String chessPiece1_toString = returnChar1.toString();
				String chessPiece2_toString = returnChar2.toString();
				
				if(chessPiece1_toString.equals(testCase7_chessPiece1.toString())){
					System.err.println("toString for Black Pawn");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for Black Pawn");
					System.err.println("returns:"+testCase7_chessPiece1.toString());
					System.err.println("Should return:"+chessPiece1_toString);
				}
				
				
				if(chessPiece2_toString.equals(testCase7_chessPiece2.toString())){
					System.err.println("toString for White Pawn");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for White Pawn");
					System.err.println("returns:"+testCase7_chessPiece2.toString());
					System.err.println("Should return:"+chessPiece2_toString);
				}
				
			}
			break;
			case 8:{

				/*Testing Rook toString(). 
				 * 
				 */
				//<hajar>
				ChessBoard testCase8_chessBoard=new ChessBoard();
				//</hajar>
				Rook testCase8_chessPiece1 = new Rook(testCase8_chessBoard,ChessPiece.Color.WHITE);
				testCase8_chessPiece1.setRow(2); 
				testCase8_chessPiece1.setColumn(3); 
				Rook testCase8_chessPiece2 = new Rook(testCase8_chessBoard,ChessPiece.Color.BLACK);
				testCase8_chessPiece2.setRow(4);
				testCase8_chessPiece2.setColumn(5);
				StringBuilder returnChar1 = new StringBuilder();
				returnChar1.append('\u2656');
				StringBuilder returnChar2 = new StringBuilder();
				returnChar2.append('\u265C');
				String chessPiece1_toString = returnChar1.toString();
				String chessPiece2_toString = returnChar2.toString();
				
				if(chessPiece1_toString.equals(testCase8_chessPiece1.toString())){
					System.err.println("toString for Black Rook");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for Black Rook");
					System.err.println("returns:"+testCase8_chessPiece1.toString());
					System.err.println("Should return:"+chessPiece1_toString);
				}
				
				
				if(chessPiece2_toString.equals(testCase8_chessPiece2.toString())){
					System.err.println("toString for White Rook");
					System.err.println("Implemented correctly");
				}else{
					System.err.println("toString for White Rook");
					System.err.println("returns:"+testCase8_chessPiece2.toString());
					System.err.println("Should return:"+chessPiece2_toString);
				}
								
			}
			break;
			case 9:{
				/* Testing ChessBoard constructor. 
				 * Should construct an empty board.
				 * 
				 */
				ChessBoard testCase9_chessBoard1 = new ChessBoard();
				checkFieldValue(testCase9_chessBoard1, "board", 1);				
			}
			break;
			case 10:{
				/* Testing ChessBoard initialize() method. 
				 * Should construct a initialized board.
				 * 
				 */				
				ChessBoard testCase10_chessBoard1 = new ChessBoard();
				
				testCase10_chessBoard1.initialize();
				
				boolean initializeCorrectFlag = true; 
				
				ChessPiece p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("a2");
				
				if(!checkPiece(p, "a2",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Pawn not at a2");
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("b2");
				
				if(!checkPiece(p, "b2",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Pawn not at b2");
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("c2");
				
				if(!checkPiece(p, "c2",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Pawn not at c2");
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("d2");
				
				if(!checkPiece(p, "d2",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Pawn not at d2");					
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("e2");
				
				if(!checkPiece(p, "e2",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Pawn not at e2");					
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("f2");
				
				if(!checkPiece(p, "f2",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Pawn not at f2");										
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("g2");
				
				if(!checkPiece(p, "g2",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Pawn not at g2");
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("h2");
				
				if(!checkPiece(p, "h2",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Pawn not at h2");					
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("a7");

				if(!checkPiece(p, "a7",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Pawn not at a7");
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("b7");
				
				if(!checkPiece(p, "b7",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Pawn not at b7");					
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("c7");
				
				if(!checkPiece(p, "c7",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Pawn not at c7");										
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("d7");
				
				if(!checkPiece(p, "d7",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Pawn not at d7");						
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("e7");
				
				if(!checkPiece(p, "e7",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Pawn not at e7");											
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("f7");
				
				if(!checkPiece(p, "f7",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Pawn not at f7");																
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("g7");
				
				if(!checkPiece(p, "g7",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Pawn not at g7");																					
				}
				
				p=new OverridenPawn(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("h7");
				
				if(!checkPiece(p, "h7",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Pawn not at h7");	
				}

				p=new OverridenRook(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("a1");
				
				if(!checkPiece(p, "a1",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White rook not at a1");
				}
				
				p=new OverridenRook(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("h1");
				
				if(!checkPiece(p, "h1",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White rook not at h1");					
				}
				
				p=new OverridenRook(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("a8");
				
				if(!checkPiece(p, "a8",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black rook not at a8");										
				}
				
				p=new OverridenRook(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("h8");
				
				if(!checkPiece(p, "h8",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black rook not at h8");															
				}

				
				
				p=new OverridenKnight(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("b1");
				
				if(!checkPiece(p, "b1",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White knight not at b1");																				
				}
				
				p=new OverridenKnight(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("g1");
				
				if(!checkPiece(p, "g1",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White knight not at g1");																									
				}
				
				p=new OverridenKnight(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("b8");
				
				if(!checkPiece(p, "b8",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black knight not at b8");																														
				}
				
				p=new OverridenKnight(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("g8");
				
				if(!checkPiece(p, "g8",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black knight not at g8");																																			
				}
				
				p=new OverridenBishop(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("c1");
				
				if(!checkPiece(p, "c1",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Bishop not at c1");																									
				}
				
				p=new OverridenBishop(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("f1");
				
				if(!checkPiece(p, "f1",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Bishop not at f1");																														
				}
				
				p=new OverridenBishop(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("c8");
				
				if(!checkPiece(p, "c8",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Bishop not at c8");																																			
				}
				
				p=new OverridenBishop(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("f8");
				
				if(!checkPiece(p, "f8",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Bishop not at f8");																																								
				}
				
				p=new OverridenKing(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("e1");
				
				if(!checkPiece(p, "e1",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White King not at e1");																																													
				}
				
				p=new OverridenQueen(testCase10_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("d1");
				
				
				if(!checkPiece(p, "d1",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Queen not at d1");																																																		
				}
				
				p=new OverridenKing(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("e8");
				
				if(!checkPiece(p, "e8",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black King not at e8");																																																							
				}
				
				p=new OverridenQueen(testCase10_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("d8");
				
				if(!checkPiece(p, "d8",testCase10_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Queen not at d8");																																																												
				}
				
				
				if(initializeCorrectFlag){
					System.err.println("ChessBoard initialize()");
					System.err.println("implemented correctly");
				}else{
					System.err.println("ChessBoard initialize()");
					System.err.println("not implemented correctly");					
				}
			}
			break;
			case 11:{						
				/* Testing ChessBoard placePiece() method. 
				 * Should construct a initialized board.
				 * 
				 */						
				ChessBoard testCase11_chessBoard1 = new ChessBoard();
				
				testCase11_chessBoard1.placePiece(new Pawn(testCase11_chessBoard1, ChessPiece.Color.WHITE), "h2");
				testCase11_chessBoard1.placePiece(new Pawn(testCase11_chessBoard1, ChessPiece.Color.BLACK), "h7");
				
				testCase11_chessBoard1.placePiece(new Rook(testCase11_chessBoard1, ChessPiece.Color.WHITE), "h1");
				testCase11_chessBoard1.placePiece(new Rook(testCase11_chessBoard1, ChessPiece.Color.BLACK), "h8");
				
				testCase11_chessBoard1.placePiece(new Knight(testCase11_chessBoard1, ChessPiece.Color.WHITE), "g1");
				testCase11_chessBoard1.placePiece(new Knight(testCase11_chessBoard1, ChessPiece.Color.BLACK), "g8");
				
				testCase11_chessBoard1.placePiece(new Bishop(testCase11_chessBoard1, ChessPiece.Color.WHITE), "f1");
				testCase11_chessBoard1.placePiece(new Bishop(testCase11_chessBoard1, ChessPiece.Color.BLACK), "f8");
				
				testCase11_chessBoard1.placePiece(new King(testCase11_chessBoard1, ChessPiece.Color.WHITE), "e1");
				testCase11_chessBoard1.placePiece(new King(testCase11_chessBoard1, ChessPiece.Color.BLACK), "e8");
				
				testCase11_chessBoard1.placePiece(new Queen(testCase11_chessBoard1, ChessPiece.Color.WHITE), "d1");
				testCase11_chessBoard1.placePiece(new Queen(testCase11_chessBoard1, ChessPiece.Color.BLACK), "d8");
				
				boolean initializeCorrectFlag = true;
				
				ChessPiece p=new OverridenPawn(testCase11_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("h2");
				
				if(!checkPiece(p, "h2",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Pawn not at h2");
				}
				
				p=new OverridenPawn(testCase11_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("h7");
				
				if(!checkPiece(p, "h7",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Pawn not at h7");
				}
				
				p=new OverridenRook(testCase11_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("h1");
				
				if(!checkPiece(p, "h1",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White rook not at h1");
				}
				
				p=new OverridenRook(testCase11_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("h8");
				
				if(!checkPiece(p, "h8",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black rook not at h8");										
				}
				
				p=new OverridenKnight(testCase11_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("g1");
				
				if(!checkPiece(p, "g1",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White knight not at g1");																				
				}
				
				p=new OverridenKnight(testCase11_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("g8");
				
				if(!checkPiece(p, "g8",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black knight not at g8");																														
				}
				
				p=new OverridenBishop(testCase11_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("f1");
				
				if(!checkPiece(p, "f1",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Bishop not at f1");																									
				}
				
				p=new OverridenBishop(testCase11_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("f8");
				
				if(!checkPiece(p, "f8",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Bishop not at f8");																																			
				}
				
				p=new OverridenKing(testCase11_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("e1");
				
				if(!checkPiece(p, "e1",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White King not at e1");																																													
				}
				
				p=new OverridenKing(testCase11_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("e8");
				
				if(!checkPiece(p, "e8",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black King not at e8");																																																							
				}
				
				p=new OverridenQueen(testCase11_chessBoard1, ChessPiece.Color.WHITE);
				p.setPosition("d1");
				
				if(!checkPiece(p, "d1",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("White Queen not at d1");																																																		
				}
				
				p=new OverridenQueen(testCase11_chessBoard1, ChessPiece.Color.BLACK);
				p.setPosition("d8");
				
				if(!checkPiece(p, "d8",testCase11_chessBoard1)){
					initializeCorrectFlag = false;
					System.err.println("Black Queen not at e8");																																																												
				}
				
				
				if(initializeCorrectFlag){
					System.err.println("ChessBoard placePiece()");
					System.err.println("implemented correctly");
				}else{
					System.err.println("ChessBoard placePiece()");
					System.err.println("not implemented correctly");					
				}		
				
				
			}
			break;
			case 12:{	
				/* Testing ChessPiece getPiece(String position) method. 
				 * Should construct a initialized board.
				 */		
				
				ChessBoard testCase12_chessBoard1 = new ChessBoard();
				setFieldValues(testCase12_chessBoard1,3,"","h2",new OverridenPawn(testCase12_chessBoard1,ChessPiece.Color.WHITE));
				setFieldValues(testCase12_chessBoard1,3,"","h7",new OverridenPawn(testCase12_chessBoard1,ChessPiece.Color.BLACK));
				setFieldValues(testCase12_chessBoard1,3,"","h1",new OverridenRook(testCase12_chessBoard1,ChessPiece.Color.WHITE));
				setFieldValues(testCase12_chessBoard1,3,"","h8",new OverridenRook(testCase12_chessBoard1,ChessPiece.Color.BLACK));
				setFieldValues(testCase12_chessBoard1,3,"","g1",new OverridenKnight(testCase12_chessBoard1,ChessPiece.Color.WHITE));
				setFieldValues(testCase12_chessBoard1,3,"","g8",new OverridenKnight(testCase12_chessBoard1,ChessPiece.Color.BLACK));
				
				setFieldValues(testCase12_chessBoard1,3,"","f1",new OverridenBishop(testCase12_chessBoard1,ChessPiece.Color.WHITE));
				setFieldValues(testCase12_chessBoard1,3,"","f8",new OverridenBishop(testCase12_chessBoard1,ChessPiece.Color.BLACK));
				
				setFieldValues(testCase12_chessBoard1,3,"","e1",new OverridenKing(testCase12_chessBoard1,ChessPiece.Color.WHITE));
				setFieldValues(testCase12_chessBoard1,3,"","e8",new OverridenKing(testCase12_chessBoard1,ChessPiece.Color.BLACK));
				
				setFieldValues(testCase12_chessBoard1,3,"","d1",new OverridenQueen(testCase12_chessBoard1,ChessPiece.Color.WHITE));
				setFieldValues(testCase12_chessBoard1,3,"","d8",new OverridenQueen(testCase12_chessBoard1,ChessPiece.Color.BLACK));

				boolean flagChessBoard = true;
				
				ChessPiece h2 = testCase12_chessBoard1.getPiece("h2");
				if(!(h2 instanceof Pawn && h2.color.equals(ChessPiece.Color.WHITE))){
					flagChessBoard = false;
					System.err.println("h2 does not return White Pawn");
				}
				

				ChessPiece h7 = testCase12_chessBoard1.getPiece("h7");
				if(!(h7 instanceof Pawn && h7.color.equals(ChessPiece.Color.BLACK))){
					flagChessBoard = false;
					System.err.println("h7 does not return Black Pawn");
				}


				ChessPiece h1 = testCase12_chessBoard1.getPiece("h1");
				if(!(h1 instanceof Rook && h1.color.equals(ChessPiece.Color.WHITE))){
					flagChessBoard = false;
					System.err.println("h1 does not return White Rook");
				}
				

				ChessPiece h8 = testCase12_chessBoard1.getPiece("h8");
				if(!(h8 instanceof Rook && h8.color.equals(ChessPiece.Color.BLACK))){
					flagChessBoard = false;
					System.err.println("h8 does not return Black Rook");
				}
				
				
				ChessPiece g1 = testCase12_chessBoard1.getPiece("g1");
				if(!(g1 instanceof Knight && g1.color.equals(ChessPiece.Color.WHITE))){
					flagChessBoard = false;
					System.err.println("g1 does not return White Knight");
				}
				
				
				ChessPiece g8 = testCase12_chessBoard1.getPiece("g8");
				if(!(g8 instanceof Knight && g8.color.equals(ChessPiece.Color.BLACK))){
					flagChessBoard = false;
					System.err.println("g8 does not return Black Knight");
				}
				
				ChessPiece f1 = testCase12_chessBoard1.getPiece("f1");
				if(!(f1 instanceof Bishop && f1.color.equals(ChessPiece.Color.WHITE))){
					flagChessBoard = false;
					System.err.println("f1 does not return White Bishop");
				}

				
				ChessPiece f8 = testCase12_chessBoard1.getPiece("f8");
				if(!(f8 instanceof Bishop && f8.color.equals(ChessPiece.Color.BLACK))){
					flagChessBoard = false;
					System.err.println("f8 does not return Black Bishop");
				}

				
				ChessPiece e1 = testCase12_chessBoard1.getPiece("e1");
				if(!(e1 instanceof King && e1.color.equals(ChessPiece.Color.WHITE))){
					flagChessBoard = false;
					System.err.println("e1 does not return White King");
				}


				ChessPiece e8 = testCase12_chessBoard1.getPiece("e8");
				if(!(e8 instanceof King && e8.color.equals(ChessPiece.Color.BLACK))){
					flagChessBoard = false;
					System.err.println("e8 does not return Black King");
				}
				
				ChessPiece d1 = testCase12_chessBoard1.getPiece("d1");
				if(!(d1 instanceof Queen && d1.color.equals(ChessPiece.Color.WHITE))){
					flagChessBoard = false;
					System.err.println("d1 does not return White Queen");
				}				

				ChessPiece d8 = testCase12_chessBoard1.getPiece("d8");
				if(!(d8 instanceof Queen && d8.color.equals(ChessPiece.Color.BLACK))){
					flagChessBoard = false;
					System.err.println("d8 does not return Black Queen");
				}				
				
				if(flagChessBoard){
					System.err.println("getPiece() works for all cases");
				}else{
					System.err.println("getPiece() doesnt work for all cases");					
				}
				
				
			}
			break;
			case 13:{
				/*
				 * Checking Bishop legalMoves
				 */
				
				ChessBoard testCase13_chessBoard1 = new ChessBoard();
				//initialize
				setFieldValues(testCase13_chessBoard1,1,"","",null);
				boolean resultMove=false;
				//move
				setFieldValues(testCase13_chessBoard1,2,"h2","h4",null);
				setFieldValues(testCase13_chessBoard1,2,"d7","d5",null);
				setFieldValues(testCase13_chessBoard1,2,"d2","d3",null);
				setFieldValues(testCase13_chessBoard1,2,"d5","d3",null);
				setFieldValues(testCase13_chessBoard1,2,"c1","e3",null);				
				
				ChessPiece masterChessPiece = testCase13_chessBoard1.getPiece("e3");
				OverridenBishop testMasterBishop=(OverridenBishop) masterChessPiece;
				ArrayList<String> returnPossibleMasterMoves = testMasterBishop.legalMoves();
				Bishop testBishop = new Bishop(testCase13_chessBoard1 , testMasterBishop.color);
				testBishop.setRow(testMasterBishop.row);
				testBishop.setColumn(testMasterBishop.column);

				ArrayList<String> returnPossibleMoves = testBishop.legalMoves();
				
				if(returnPossibleMasterMoves.containsAll(returnPossibleMoves) && returnPossibleMoves.containsAll(returnPossibleMasterMoves)){
					System.err.println("Bishop legalMoves() match");
				}else{
					System.err.println("Bishop legalMoves() doesnt match");
					System.err.println("Correct legalMoves() are:");
					for(String correct:returnPossibleMasterMoves){
						System.err.println(correct);
					}

					System.err.println("Board looks like");
					System.err.println("The following:");
						System.err.println(overridenToString(testCase13_chessBoard1));

					
					System.err.println("Your legalMoves() are:");
					for(String incorrect:returnPossibleMoves){
						System.err.println(incorrect);
					}
										
				}
				
			}
			break;
			case 14:{
				/*
				 * Checking Pawn legalMoves
				 */
				
				ChessBoard testCase14_chessBoard1=new ChessBoard();
				
				//initialize
				setFieldValues(testCase14_chessBoard1,1,"","",null);
				//move
				setFieldValues(testCase14_chessBoard1,2,"c7","c5",null);
				setFieldValues(testCase14_chessBoard1,2,"h2","h4",null);
				setFieldValues(testCase14_chessBoard1,2,"c5","c4",null);
				setFieldValues(testCase14_chessBoard1,2,"c4","c3",null);
				setFieldValues(testCase14_chessBoard1,2,"a2","a4",null);
				setFieldValues(testCase14_chessBoard1,2,"a1","a3",null);		
				
				ChessPiece masterChessPiece = testCase14_chessBoard1.getPiece("b2");
				OverridenPawn testMasterPawn=(OverridenPawn)masterChessPiece;
				ArrayList<String> returnPossibleMasterMoves=null, returnPossibleMoves=null;
				if(testMasterPawn!=null){					
					returnPossibleMasterMoves = testMasterPawn.legalMoves();
					Pawn testPawn = new Pawn( testCase14_chessBoard1 ,  testMasterPawn.color);
					testPawn.setRow(testMasterPawn.row); 
					testPawn.setColumn(testMasterPawn.column);
					returnPossibleMoves = testPawn.legalMoves();
				}
				
				if(returnPossibleMasterMoves.containsAll(returnPossibleMoves) && returnPossibleMoves.containsAll(returnPossibleMasterMoves)){
					System.err.println("Pawn legalMoves() match");
				}else{
					System.err.println("Pawn legalMoves() doesnt match");
					System.err.println("Correct legalMoves() are:");
					for(String correct:returnPossibleMasterMoves){
						System.err.println(correct);
					}

					System.err.println("Board looks like");
					System.err.println("The following:");
					System.err.println(overridenToString(testCase14_chessBoard1));

					
					System.err.println("Your legalMoves() are:");
					for(String incorrect:returnPossibleMoves){
						System.err.println(incorrect);
					}
				}
			}
			break;
			case 15:{
				/*
				 * Checking Knight legalMoves
				 */
				
				ChessBoard testCase15_chessBoard1=new ChessBoard();
				
				//initialize
				setFieldValues(testCase15_chessBoard1,1,"","",null);
				//move
				setFieldValues(testCase15_chessBoard1,2,"d2","d4",null);
				setFieldValues(testCase15_chessBoard1,2,"d7","d5",null);
				setFieldValues(testCase15_chessBoard1,2,"c1","f4",null);
				setFieldValues(testCase15_chessBoard1,2,"g7","g5",null);
				setFieldValues(testCase15_chessBoard1,2,"d1","d2",null);
				setFieldValues(testCase15_chessBoard1,2,"b8","c6",null);
				setFieldValues(testCase15_chessBoard1,2,"h2","h4",null);	
				
				ChessPiece masterChessPiece=testCase15_chessBoard1.getPiece("b1");				
				Knight testKnight1=new Knight(testCase15_chessBoard1, masterChessPiece.color);
				testKnight1.setRow(masterChessPiece.row);
				testKnight1.setColumn(masterChessPiece.column);
				
				masterChessPiece=testCase15_chessBoard1.getPiece("g1");				
				Knight testKnight2=new Knight(testCase15_chessBoard1, masterChessPiece.color);
				testKnight2.setRow(masterChessPiece.row);
				testKnight2.setColumn(masterChessPiece.column);
				
				masterChessPiece=testCase15_chessBoard1.getPiece("b8");				
				Knight testKnight3=new Knight(testCase15_chessBoard1, masterChessPiece.color);
				testKnight3.setRow(masterChessPiece.row);
				testKnight3.setColumn(masterChessPiece.column);
				
				masterChessPiece=testCase15_chessBoard1.getPiece("g8");				
				Knight testKnight4=new Knight(testCase15_chessBoard1, masterChessPiece.color);
				testKnight4.setRow(masterChessPiece.row);
				testKnight4.setColumn(masterChessPiece.column);
				
				
				if(testKnight1.legalMoves().isEmpty() && testKnight2.legalMoves().isEmpty()
						&& testKnight3.legalMoves().isEmpty() && testKnight4.legalMoves().isEmpty()){
					System.err.println("Knight legalMoves() match");
				}
				else
				{
					System.err.println("Knight legalMoves() does not match");
				}
								
			}
			break;
			case 16:{
				/*
				 * Checking Queen legalMoves
				 */
				
				ChessBoard testCase16_chessBoard1=new ChessBoard();
				
				//initialize
				setFieldValues(testCase16_chessBoard1,1,"","",null);
				//move
				setFieldValues(testCase16_chessBoard1,2,"d2","d4",null);
				setFieldValues(testCase16_chessBoard1,2,"d7","d5",null);
				setFieldValues(testCase16_chessBoard1,2,"c1","f4",null);
				setFieldValues(testCase16_chessBoard1,2,"g7","g5",null);
				setFieldValues(testCase16_chessBoard1,2,"d1","d2",null);
				setFieldValues(testCase16_chessBoard1,2,"b8","c6",null);
				setFieldValues(testCase16_chessBoard1,2,"h2","h4",null);	
				
				ChessPiece masterChessPiece=testCase16_chessBoard1.getPiece("d1");				
				Queen testQueen1=new Queen(testCase16_chessBoard1, masterChessPiece.color);
				testQueen1.setRow(masterChessPiece.row);
				testQueen1.setColumn(masterChessPiece.column);
				
				masterChessPiece=testCase16_chessBoard1.getPiece("d8");				
				Queen testQueen2=new Queen(testCase16_chessBoard1, masterChessPiece.color);
				testQueen2.setRow(masterChessPiece.row);
				testQueen2.setColumn(masterChessPiece.column);

				
				if(testQueen1.legalMoves().isEmpty() && testQueen2.legalMoves().isEmpty()){
					System.err.println("Queen legalMoves() match");
				}
				else
				{
					System.err.println("Queen legalMoves() does not match");
				}							
				
			}
			break;
			case 17:{
				/*
				 * Checking King legalMoves
				 */
				
				ChessBoard testCase17_chessBoard1=new ChessBoard();

				//initialize
				setFieldValues(testCase17_chessBoard1,1,"","",null);
				//move
				setFieldValues(testCase17_chessBoard1,2,"d2","d4",null);
				setFieldValues(testCase17_chessBoard1,2,"d7","d5",null);
				setFieldValues(testCase17_chessBoard1,2,"c1","f4",null);
				setFieldValues(testCase17_chessBoard1,2,"g7","g5",null);
				setFieldValues(testCase17_chessBoard1,2,"e1","b4",null);
				setFieldValues(testCase17_chessBoard1,2,"b8","c6",null);
				setFieldValues(testCase17_chessBoard1,2,"h2","h4",null);
				setFieldValues(testCase17_chessBoard1,2,"g5","h4",null);
				setFieldValues(testCase17_chessBoard1,2,"d1","d2",null);

				
				ChessPiece masterChessPiece=testCase17_chessBoard1.getPiece("e1");				
				King testKing1=new King(testCase17_chessBoard1, masterChessPiece.color);
				testKing1.setRow(masterChessPiece.row);
				testKing1.setColumn(masterChessPiece.column);
				
				masterChessPiece=testCase17_chessBoard1.getPiece("e8");
				King testKing2=new King(testCase17_chessBoard1, masterChessPiece.color);
				testKing2.setRow(masterChessPiece.row);
				testKing2.setColumn(masterChessPiece.column);
	
				
				if(testKing1.legalMoves().isEmpty() && testKing2.legalMoves().isEmpty()){
					System.err.println("King legalMoves() match");
				}
				else
				{
					System.err.println("King legalMoves() does not match");
				}			
				
			}
			break;
			case 18:{
				/*
				 * Checking Rook legalMoves
				 */
				
				ChessBoard testCase18_chessBoard1=new ChessBoard();
				
				//initialize
				setFieldValues(testCase18_chessBoard1,1,"","",null);
				//move
				setFieldValues(testCase18_chessBoard1,2,"d2","d4",null);
				setFieldValues(testCase18_chessBoard1,2,"d7","d5",null);
				setFieldValues(testCase18_chessBoard1,2,"c1","f4",null);
				setFieldValues(testCase18_chessBoard1,2,"g7","g5",null);
				setFieldValues(testCase18_chessBoard1,2,"e1","b4",null);
				setFieldValues(testCase18_chessBoard1,2,"b8","c6",null);
				setFieldValues(testCase18_chessBoard1,2,"h2","h4",null);
				setFieldValues(testCase18_chessBoard1,2,"g5","h4",null);
				setFieldValues(testCase18_chessBoard1,2,"h1","h3",null);
				
				ChessPiece masterChessPiece = testCase18_chessBoard1.getPiece("h3");
				OverridenRook testMasterRook=(OverridenRook)masterChessPiece;
				ArrayList<String> returnPossibleMasterMoves = testMasterRook.legalMoves();
				Rook testRook = new Rook(testCase18_chessBoard1,testMasterRook.color);
				testRook.setRow(testMasterRook.row);
				testRook.setColumn(testMasterRook.column);

				ArrayList<String> returnPossibleMoves = testRook.legalMoves();
				
				if(returnPossibleMasterMoves.containsAll(returnPossibleMoves) && returnPossibleMoves.containsAll(returnPossibleMasterMoves)){
					System.err.println("Rook legalMoves() match");
				}else{
					System.err.println("Rook legalMoves() doesnt match");	
					System.err.println("Correct legalMoves() are:");
					for(String correct:returnPossibleMasterMoves){
						System.err.println(correct);
					}
					
					System.err.println("Board looks like");
					System.err.println("The following:");
					System.err.println(overridenToString(testCase18_chessBoard1));
										
					System.err.println("Your legalMoves() are:");
					for(String incorrect:returnPossibleMoves){
						System.err.println(incorrect);
					}
				}
							
			}
			break;
			case 19:{
				/* After initializing the board
				 * The following moves are made
				 * Testing the board arrangement 
				 * after all these moves. 
				 */
				
				ChessBoard testCase19_chessBoard1=new ChessBoard();
				//initialize
				setFieldValues(testCase19_chessBoard1,1,"","",null);
				//move
				setFieldValues(testCase19_chessBoard1,2,"d2","d4",null);
				setFieldValues(testCase19_chessBoard1,2,"d7", "d5",null);
				setFieldValues(testCase19_chessBoard1,2,"c1", "f4",null);
				setFieldValues(testCase19_chessBoard1,2,"e1", "b4",null);
				setFieldValues(testCase19_chessBoard1,2,"b8", "c6",null);
				setFieldValues(testCase19_chessBoard1,2,"h2", "h4",null);
				setFieldValues(testCase19_chessBoard1,2,"g5", "h4",null);
				setFieldValues(testCase19_chessBoard1,2,"h1", "h3",null);
				
				
				ChessBoard testCase19_chessBoard2 = new ChessBoard();
				testCase19_chessBoard2.initialize();
				testCase19_chessBoard2.move("d2", "d4");
				testCase19_chessBoard2.move("d7", "d5");
				testCase19_chessBoard2.move("c1", "f4");
				testCase19_chessBoard2.move("e1", "b4");
				testCase19_chessBoard2.move("b8", "c6");
				testCase19_chessBoard2.move("h2", "h4");
				testCase19_chessBoard2.move("g5", "h4");
				testCase19_chessBoard2.move("h1", "h3");

				if(overridenToString(testCase19_chessBoard1).equals(overridenToString(testCase19_chessBoard2))){
					System.err.println("move() results in correct");
					System.err.println("board arrangement");
				}else{
					System.err.println("move() does not result in correct");
					System.err.println("board arrangement");			
					
					System.err.println("Correct Board looks like");
					System.err.println("The following:");
					System.err.println(overridenToString(testCase19_chessBoard1));
								
					System.err.println("");

					System.err.println("Your Board looks like");
					System.err.println("The following:");
					System.err.println(overridenToString(testCase19_chessBoard2));
	
								
					
				}
				
			}
			break;

		}
	}
	private ChessPiece[][] overrideninitialize(ChessBoard object){
		ChessPiece[][] board=new ChessPiece[8][8];
		
		// initializes the board to an 8X8 array with all empty squares. An empty square is null.

				// 8 white pawns
				OverridenPawn[] wpawns = new OverridenPawn[8];
				for(int i=0; i<8; i++) {
					wpawns[i] = new OverridenPawn(object, ChessPiece.Color.WHITE);
					board[1][i] = wpawns[i];
					wpawns[i].setRow(1);
					wpawns[i].setColumn(i);
				}

				// 8 black pawns
				OverridenPawn[] bpawns = new OverridenPawn[8];
				for(int i=0; i<8; i++) {
					bpawns[i] = new OverridenPawn(object, ChessPiece.Color.BLACK);
					board[6][i] = bpawns[i];
					bpawns[i].setRow(6);
					bpawns[i].setColumn(i);
				}

				// 2 white rooks
				OverridenRook[] wrooks = new OverridenRook[2];
				for(int i=0; i<2; i++) {
					wrooks[i] = new OverridenRook(object, ChessPiece.Color.WHITE);
				}
				board[0][0] = wrooks[0];
				board[0][7] = wrooks[1];
				
				wrooks[0].setPosition("a1");
				wrooks[1].setPosition("h1");

				// 2 black rooks
				OverridenRook[] brooks = new OverridenRook[2];
				for(int i=0; i<2; i++) {
					brooks[i] = new OverridenRook(object, ChessPiece.Color.BLACK);
				}
				board[7][0] = brooks[0];
				board[7][7] = brooks[1];
				brooks[0].setPosition("a8");
				brooks[1].setPosition("h8");

				// 2 white knights
				OverridenKnight[] wknights = new OverridenKnight[2];
				for(int i=0; i<2; i++) {
					wknights[i] = new OverridenKnight(object, ChessPiece.Color.WHITE);
				}
				board[0][1] = wknights[0];
				board[0][6] = wknights[1];
				
				wknights[0].setPosition("b1");
				wknights[1].setPosition("g1");

				// 2 black knights
				OverridenKnight[] bknights = new OverridenKnight[2];
				for(int i=0; i<2; i++) {
					bknights[i] = new OverridenKnight(object, ChessPiece.Color.BLACK);
				}
				board[7][1] = bknights[0];
				board[7][6] = bknights[1];
				
				bknights[0].setPosition("b8");
				bknights[1].setPosition("g8");
				

				// 2 white bishops
				OverridenBishop[] wbishops = new OverridenBishop[2];
				for(int i=0; i<2; i++) {
					wbishops[i] = new OverridenBishop(object, ChessPiece.Color.WHITE);
				}
				board[0][2] = wbishops[0];
				board[0][5] = wbishops[1];
				
				wbishops[0].setPosition("c1");
				wbishops[1].setPosition("f1");

				// 2 black bishops
				OverridenBishop[] bbishops = new OverridenBishop[2];
				for(int i=0; i<2; i++) {
					bbishops[i] = new OverridenBishop(object, ChessPiece.Color.BLACK);
				}
				board[7][2] = bbishops[0];
				board[7][5] = bbishops[1];
				
				bbishops[0].setPosition("c8");
				bbishops[1].setPosition("f8");

				// White and black Queen
				
				OverridenQueen wqueen = new OverridenQueen(object, ChessPiece.Color.WHITE);
				OverridenQueen bqueen = new OverridenQueen(object, ChessPiece.Color.BLACK);
				
				board[0][3] = wqueen;
				board[7][3] = bqueen;
				
				wqueen.setPosition("d1");
				bqueen.setPosition("d8");
				

				// White and black King
				
				OverridenKing wking = new OverridenKing(object, ChessPiece.Color.WHITE);;
				OverridenKing bking = new OverridenKing(object, ChessPiece.Color.BLACK);
				board[0][4] = wking;
				board[7][4] = bking;
				
				wking.setPosition("e1");
				bking.setPosition("e8");
		
		return board;
	}
	
	private ChessPiece[][] overridenMove(ChessBoard object,ChessPiece[][] board, String fromPosition,String toPosition){
		
		ChessPiece cp = object.getPiece(fromPosition);
		if(cp != null) {
			if (cp.legalMoves()!=null && cp.legalMoves().contains(toPosition)) {
				board[cp.getRow()][cp.getColumn()]=null;
				return overridenPlacePiece(object,board,cp, toPosition);				
			}
		}
		return board;		
		
	}
	
	public ChessPiece[][] overridenPlacePiece(ChessBoard object,ChessPiece[][] board,ChessPiece piece, String position) {
		// This method tries to place the given piece at a given 
		// position, and returns true if successful, and false if 
		// there is already a piece in the given position.
		if(object.getPiece(position)!=null) return board;
		char letter = position.charAt(0);
		char digit = position.charAt(1);
		int row, column;
		switch(letter) {
		case 'a': column=0; break;
		case 'b': column=1; break;
		case 'c': column=2; break;
		case 'd': column=3; break;
		case 'e': column=4; break;
		case 'f': column=5; break;
		case 'g': column=6; break;
		case 'h': column=7; break;
		default: column=0;
		}
		row = digit -'0' -1;
		
		//<hajar>
		piece.setPosition(position);
		//</hajar>
		board[row][column] = piece;
		return board;
	}
	
	public String overridenToString(Object object) {
		
		try{
			Field boardField = object.getClass().getDeclaredField("board");
			boardField.setAccessible(true);
			ChessPiece[][] board=(ChessPiece[][]) boardField.get(object);	
			
			
		    String chess="";
		    String upperLeft = "\u250C";
		    String upperRight = "\u2510";
		    String horizontalLine = "\u2500";
		    String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
		    String verticalLine = "\u2502";
		    String upperT = "\u252C";
		    String bottomLeft = "\u2514";
		    String bottomRight = "\u2518";
		    String bottomT = "\u2534";
		    String plus = "\u253C";
		    String leftT = "\u251C";
		    String rightT = "\u2524";

		    String topLine = upperLeft;
		    for (int i = 0; i<7; i++){
		        topLine += horizontal3 + upperT;
		    }
		    topLine += horizontal3 + upperRight;

		    String bottomLine = bottomLeft;
		    for (int i = 0; i<7; i++){
		        bottomLine += horizontal3 + bottomT;
		    }
		    bottomLine += horizontal3 + bottomRight;
		    chess+=topLine + "\n";

		    for (int row = 7; row >=0; row--){
		        String midLine = "";
		        for (int col = 0; col < 8; col++){
		            if(board[row][col]==null) {
		                midLine += verticalLine + " \u3000 ";
		            } else {midLine += verticalLine + " "+board[row][col]+" ";}
		        }
		        midLine += verticalLine;
		        String midLine2 = leftT;
		        for (int i = 0; i<7; i++){
		            midLine2 += horizontal3 + plus;
		        }
		        midLine2 += horizontal3 + rightT;
		        chess+=midLine+ "\n";
		        if(row>=1)
		            chess+=midLine2+ "\n";
		    }

		    chess+=bottomLine;
		    return chess;

		} catch (NoSuchFieldException e) {
			System.err.println("Required Field does not exist " + e.getMessage());
		} catch (IllegalAccessException e) {
			System.err.println("Cannot access the field " + e.getMessage());
		}	
		 return "";	
	}
	
	private boolean checkPiece(ChessPiece piece,String position,ChessBoard testBoard) {
		ChessPiece returnedPiece = testBoard.getPiece(position);
		return (piece.getClass().getSuperclass().equals( returnedPiece.getClass() ) || piece.getClass().equals( returnedPiece.getClass()))
				&& piece.color.equals(returnedPiece.color)
				&& piece.getPosition().equals(returnedPiece.getPosition());
			
	}

	protected String onePossibleMove(int row,int column){
			String returnString = "";
			if(column>=0 && column<=7){		
				if(row>=0 && row <=7){
					char columnChar = (char) ('a' + column);
					char rowChar = (char)('1'+row);
					StringBuilder sb = new StringBuilder();
					sb.append(columnChar);
					sb.append(rowChar);
					return returnString+sb.toString();
				}
			}
			return null;
	}
		
	private String fieldCheck(Class type, String fieldName, Class fieldType) {

			try {
				Field field = type.getDeclaredField(fieldName);
				if (!field.getType().equals(fieldType)) {
					return "The field " + fieldName + " is not of the required type " + fieldType + ".\n";
				}

			} catch (NoSuchFieldException e) {
				return type.getName() + " does not have a variable called " + fieldName + ".\n";
			}
			return "Variable " + fieldName + " with type " + fieldType + ".\n";
	}
		
	private void checkFieldValue(Object object, String fieldName, int characteristic) {
			try {

				Field field = object.getClass().getDeclaredField(fieldName);
				field.setAccessible(true);
				if(characteristic==1) {
					ChessPiece[][] chessPiece=(ChessPiece[][])(field.get(object));
					System.err.println("The board size is: " +  chessPiece[0].length + "*"+chessPiece[1].length );
				}
			} catch (NoSuchFieldException e) {
				System.err.println("The class " + object.getClass().getName() + " does not have a variable called " + fieldName + ".\n");
				System.exit(0);
			} catch (IllegalAccessException e) {
				System.err.println("Cannot access the variable " + fieldName);
				System.exit(0);
			}
	}
		
	private void setFieldValues(Object object, int characteristic, String fromPosition, String toPosition, ChessPiece piece) {
			try {
				
				ChessBoard obj=(ChessBoard)object;
				Field board = object.getClass().getDeclaredField("board");
				board.setAccessible(true);
				//initialize
				if(characteristic==1){

					board.set(object, overrideninitialize(obj));	
				}
				//move
				else if(characteristic==2){
					
					ChessPiece[][] temp=(ChessPiece[][]) board.get(object);
					board.set(object, overridenMove(obj,temp,fromPosition,toPosition));	
					
				}
				//place
				else if(characteristic==3){
					ChessPiece[][] temp=(ChessPiece[][]) board.get(object);
					board.set(object, overridenPlacePiece(obj,temp,piece,toPosition));	
				}


			} catch (NoSuchFieldException e) {
				System.err.println("Required Field does not exist " + e.getMessage());
			} catch (IllegalAccessException e) {
				System.err.println("Cannot access the field " + e.getMessage());
			}
	}

	
}

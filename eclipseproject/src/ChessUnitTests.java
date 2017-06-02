import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.Assert;
import org.junit.Before;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChessUnitTests{
	Class chessBoardClass;
	Class chessPieceClass;
	ChessBoard chessBoard;
	ChessBoard chessBoard2;
	ChessPiece chessPiece;
	ChessPiece chessPiece2;
	
	@Before
	public void initialize() throws ClassNotFoundException{
	}
	
	@Test 
	/* Check that classes exists
	 */
	public void classes_exist() throws Throwable {
		chessBoardClass = Class.forName("ChessBoard");
		chessPieceClass = Class.forName("ChessPiece");
	}
	
	@Test
	public void chessBoard_fieldCheck() throws ClassNotFoundException{
		chessBoardClass = Class.forName("ChessBoard");
		Assert.assertTrue(fieldCheck(chessBoardClass, "board", ChessPiece[][].class));
	}
	@Test
	public void chessPiece_fieldCheck() throws ClassNotFoundException {
		chessPieceClass = Class.forName("ChessPiece");
		Assert.assertTrue(fieldCheck(chessPieceClass, "board", ChessBoard.class));
	}
	@Test
	public void chessPiece_fieldCheck2() throws ClassNotFoundException {
		chessPieceClass = Class.forName("ChessPiece");
		Assert.assertTrue(fieldCheck(chessPieceClass, "row", int.class));
	}
	@Test
	public void chessPiece_fieldCheck3() throws ClassNotFoundException {
		chessPieceClass = Class.forName("ChessPiece");
		Assert.assertTrue(fieldCheck(chessPieceClass, "column", int.class));
	}
	@Test
	public void chessPiece_fieldCheck4() throws ClassNotFoundException {
		chessPieceClass = Class.forName("ChessPiece");
		Assert.assertTrue(fieldCheck(chessPieceClass, "color", ChessPiece.Color.class));
	}
	@Test
	public void bishop_white_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Bishop(chessBoard, ChessPiece.Color.WHITE);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u2657');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	@Test
	public void bishop_black_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Bishop(chessBoard, ChessPiece.Color.BLACK);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u265D');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	@Test
	public void king_white_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new King(chessBoard, ChessPiece.Color.WHITE);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u2654');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	
	@Test
	public void king_black_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new King(chessBoard, ChessPiece.Color.BLACK);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u265A');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	@Test
	public void queen_white_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Queen(chessBoard, ChessPiece.Color.WHITE);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u2655');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	
	@Test
	public void queen_black_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Queen(chessBoard, ChessPiece.Color.BLACK);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u265B');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}

	@Test
	public void knight_white_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Knight(chessBoard, ChessPiece.Color.WHITE);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u2658');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	
	@Test
	public void knight_black_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Knight(chessBoard, ChessPiece.Color.BLACK);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u265E');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	
	@Test
	public void pawn_white_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Pawn(chessBoard, ChessPiece.Color.WHITE);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u2659');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	
	@Test
	public void pawn_black_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Pawn(chessBoard, ChessPiece.Color.BLACK);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u265F');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	@Test
	public void rook_white_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Rook(chessBoard, ChessPiece.Color.WHITE);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u2656');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	
	@Test
	public void rook_black_toString() {
		chessBoard=new ChessBoard();
		chessPiece = new Rook(chessBoard, ChessPiece.Color.BLACK);
		StringBuilder returnChar1 = new StringBuilder();
		returnChar1.append('\u265C');
		String chessPiece_toString = returnChar1.toString();
		
		Assert.assertTrue(chessPiece_toString.equals(chessPiece.toString()));
	}
	
	@Test
	public void chessBoard_constructor() {
		chessBoard = new ChessBoard();
		Assert.assertTrue(checkFieldValue(chessBoard, "board", 1));
	}
	
	@Test
	public void chessBoard_initialize(){
		chessBoard = new ChessBoard();
		
		chessBoard.initialize();
		boolean initializeCorrectFlag = true; 
		
		
		// White Pawns
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("a2");
		Assert.assertTrue(checkPiece(chessPiece, "a2",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("b2");
		Assert.assertTrue(checkPiece(chessPiece, "b2",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("c2");
		Assert.assertTrue(checkPiece(chessPiece, "c2",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("d2");
		Assert.assertTrue(checkPiece(chessPiece, "d2",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("e2");
		Assert.assertTrue(checkPiece(chessPiece, "e2",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("f2");
		Assert.assertTrue(checkPiece(chessPiece, "f2",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("g2");
		Assert.assertTrue(checkPiece(chessPiece, "g2",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("h2");
		Assert.assertTrue(checkPiece(chessPiece, "h2",chessBoard));
	// Black pawns	
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("a7");
		Assert.assertTrue(checkPiece(chessPiece, "a7",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("b7");
		Assert.assertTrue(checkPiece(chessPiece, "b7",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("c7");
		Assert.assertTrue(checkPiece(chessPiece, "c7",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("d7");
		Assert.assertTrue(checkPiece(chessPiece, "d7",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("e7");
		Assert.assertTrue(checkPiece(chessPiece, "e7",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("f7");
		Assert.assertTrue(checkPiece(chessPiece, "f7",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("g7");
		Assert.assertTrue(checkPiece(chessPiece, "g7",chessBoard));
		
		chessPiece=new OverridenPawn(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("h7");
		Assert.assertTrue(checkPiece(chessPiece, "h7",chessBoard));

		
		//======== Rooks ==================================
		chessPiece=new OverridenRook(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("a1");
		Assert.assertTrue(checkPiece(chessPiece, "a1",chessBoard));

		chessPiece=new OverridenRook(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("h1");
		Assert.assertTrue(checkPiece(chessPiece, "h1",chessBoard));
		
		chessPiece=new OverridenRook(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("a8");
		Assert.assertTrue(checkPiece(chessPiece, "a8",chessBoard));

		chessPiece=new OverridenRook(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("h8");
		Assert.assertTrue(checkPiece(chessPiece, "h8",chessBoard));
		
		// knights
		chessPiece=new OverridenKnight(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("b1");
		Assert.assertTrue(checkPiece(chessPiece, "b1",chessBoard));

		chessPiece=new OverridenKnight(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("g1");
		Assert.assertTrue(checkPiece(chessPiece, "g1",chessBoard));
		
		chessPiece=new OverridenKnight(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("b8");
		Assert.assertTrue(checkPiece(chessPiece, "b8",chessBoard));

		chessPiece=new OverridenKnight(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("g8");
		Assert.assertTrue(checkPiece(chessPiece, "g8",chessBoard));
		
		// bishops
		chessPiece=new OverridenBishop(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("c1");
		Assert.assertTrue(checkPiece(chessPiece, "c1",chessBoard));

		chessPiece=new OverridenBishop(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("f1");
		Assert.assertTrue(checkPiece(chessPiece, "f1",chessBoard));
		
		chessPiece=new OverridenBishop(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("c8");
		Assert.assertTrue(checkPiece(chessPiece, "c8",chessBoard));

		chessPiece=new OverridenBishop(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("f8");
		Assert.assertTrue(checkPiece(chessPiece, "f8",chessBoard));
		
		//kings & queens
		chessPiece=new OverridenKing(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("e1");
		Assert.assertTrue(checkPiece(chessPiece, "e1",chessBoard));
		
		chessPiece=new OverridenQueen(chessBoard, ChessPiece.Color.WHITE);
		chessPiece.setPosition("d1");
		Assert.assertTrue(checkPiece(chessPiece, "d1",chessBoard));
		
		chessPiece=new OverridenKing(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("e8");
		Assert.assertTrue(checkPiece(chessPiece, "e8",chessBoard));
		
		chessPiece=new OverridenQueen(chessBoard, ChessPiece.Color.BLACK);
		chessPiece.setPosition("d8");
		Assert.assertTrue(checkPiece(chessPiece, "d8",chessBoard));
	}

	
	/// ================= place piece methods
	@Test
	public void chessBoard_placePiece1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "h2";
		Class pieceClass = Class.forName("OverridenPawn");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "h7";
		Class pieceClass = Class.forName("OverridenPawn");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "h1";
		Class pieceClass = Class.forName("OverridenRook");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "h8";
		Class pieceClass = Class.forName("OverridenRook");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece5() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "g1";
		Class pieceClass = Class.forName("OverridenKnight");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece6() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "g8";
		Class pieceClass = Class.forName("OverridenKnight");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece7() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "f1";
		Class pieceClass = Class.forName("OverridenBishop");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece8() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "f8";
		Class pieceClass = Class.forName("OverridenBishop");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece9() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "e1";
		Class pieceClass = Class.forName("OverridenKing");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece10() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "e8";
		Class pieceClass = Class.forName("OverridenKing");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece11() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "d1";
		Class pieceClass = Class.forName("OverridenQueen");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	@Test
	public void chessBoard_placePiece12() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String position = "d8";
		Class pieceClass = Class.forName("OverridenQueen");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessBoard.placePiece((ChessPiece)pieceConstructor.newInstance(chessBoard, col), position);
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		chessPiece.setPosition(position);
		Assert.assertTrue(checkPiece(chessPiece, position,chessBoard));
	}
	
	// ========== get piece tests =================
	@Test
	public void chessPiece_getPiece1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "h2";
		Class pieceClass = Class.forName("OverridenPawn");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "h7";
		Class pieceClass = Class.forName("OverridenPawn");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "h1";
		Class pieceClass = Class.forName("OverridenRook");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "h8";
		Class pieceClass = Class.forName("OverridenRook");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece5() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "g1";
		Class pieceClass = Class.forName("OverridenKnight");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece6() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "g8";
		Class pieceClass = Class.forName("OverridenKnight");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece7() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "f1";
		Class pieceClass = Class.forName("OverridenBishop");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece8() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "f8";
		Class pieceClass = Class.forName("OverridenBishop");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece9() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "e1";
		Class pieceClass = Class.forName("OverridenKing");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece10() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "e8";
		Class pieceClass = Class.forName("OverridenKing");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece11() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "d1";
		Class pieceClass = Class.forName("OverridenQueen");
		ChessPiece.Color col = ChessPiece.Color.WHITE;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	@Test
	public void chessPiece_getPiece12() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String position = "d8";
		Class pieceClass = Class.forName("OverridenQueen");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		chessBoard = new ChessBoard();
		chessPiece = (ChessPiece)pieceConstructor.newInstance(chessBoard, col);
		setFieldValues(chessBoard,3,"",position,chessPiece);
		chessPiece2 = chessBoard.getPiece(position);
		Assert.assertTrue(chessPiece2.getClass().equals(pieceClass) && chessPiece2.toString().equals(chessPiece.toString()));
	}
	
	
	//================== legal moves ================
	@Test
	public void bishop_legalMoves() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		chessBoard = new ChessBoard();
		setFieldValues(chessBoard,1,"","",null);
		setFieldValues(chessBoard,2,"h2","h4",null);
		setFieldValues(chessBoard,2,"d7","d5",null);
		setFieldValues(chessBoard,2,"d2","d3",null);
		setFieldValues(chessBoard,2,"d5","d3",null);
		setFieldValues(chessBoard,2,"c1","e3",null);
		
		String pieceLoc = "e3";
		Class pieceClass = Class.forName("OverridenBishop");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		
		//legal moves according to the piece on the board
		chessPiece = chessBoard.getPiece(pieceLoc);
		ArrayList<String> returnPossibleMoves = chessPiece.legalMoves();
		
		//oracle master moves according to the overriden piece
		chessPiece2 = (ChessPiece)pieceConstructor.newInstance(chessBoard, chessPiece.getColor());
		chessPiece2.setRow(chessPiece.getRow());
		chessPiece2.setColumn(chessPiece.getColumn());
		ArrayList<String> returnPossibleMasterMoves = chessPiece2.legalMoves();
		
		Assert.assertTrue(returnPossibleMasterMoves.containsAll(returnPossibleMoves) 
					&& returnPossibleMoves.containsAll(returnPossibleMasterMoves));
	}
	@Test
	public void pawn_legalMoves() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		chessBoard = new ChessBoard();
		setFieldValues(chessBoard,1,"","",null);
		setFieldValues(chessBoard,2,"c7","c5",null);
		setFieldValues(chessBoard,2,"h7","h4",null);
		setFieldValues(chessBoard,2,"c5","c4",null);
		setFieldValues(chessBoard,2,"c4","c3",null);
		setFieldValues(chessBoard,2,"a2","a4",null);
		setFieldValues(chessBoard,2,"a1","a3",null);
		
		String pieceLoc = "b2";
		Class pieceClass = Class.forName("OverridenPawn");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		
		//legal moves according to the piece on the board
		chessPiece = chessBoard.getPiece(pieceLoc);
		ArrayList<String> returnPossibleMoves = chessPiece.legalMoves();
		
		//oracle master moves according to the overriden piece
		chessPiece2 = (ChessPiece)pieceConstructor.newInstance(chessBoard, chessPiece.getColor());
		chessPiece2.setRow(chessPiece.getRow());
		chessPiece2.setColumn(chessPiece.getColumn());
		ArrayList<String> returnPossibleMasterMoves = chessPiece2.legalMoves();
		
		Assert.assertTrue(returnPossibleMasterMoves.containsAll(returnPossibleMoves) 
					&& returnPossibleMoves.containsAll(returnPossibleMasterMoves));
	}
	@Test
	public void knight_legalMoves() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		chessBoard = new ChessBoard();
		setFieldValues(chessBoard,1,"","",null);
		setFieldValues(chessBoard,2,"d2","d4",null);
		setFieldValues(chessBoard,2,"d7","d5",null);
		setFieldValues(chessBoard,2,"c1","f4",null);
		setFieldValues(chessBoard,2,"g7","g5",null);
		setFieldValues(chessBoard,2,"d1","d2",null);
		setFieldValues(chessBoard,2,"b8","c6",null);
		setFieldValues(chessBoard,2,"h2","h4",null);
		
		String pieceLoc = "b1";
		Class pieceClass = Class.forName("OverridenKnight");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		
		//legal moves according to the piece on the board
		chessPiece = chessBoard.getPiece(pieceLoc);
		ArrayList<String> returnPossibleMoves = chessPiece.legalMoves();
		
		//oracle master moves according to the overriden piece
		chessPiece2 = (ChessPiece)pieceConstructor.newInstance(chessBoard, chessPiece.getColor());
		chessPiece2.setRow(chessPiece.getRow());
		chessPiece2.setColumn(chessPiece.getColumn());
		ArrayList<String> returnPossibleMasterMoves = chessPiece2.legalMoves();
		
		Assert.assertTrue(returnPossibleMasterMoves.containsAll(returnPossibleMoves) 
					&& returnPossibleMoves.containsAll(returnPossibleMasterMoves));
	}
	@Test
	public void queen_legalMoves() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		chessBoard = new ChessBoard();
		setFieldValues(chessBoard,1,"","",null);
		setFieldValues(chessBoard,2,"d2","d4",null);
		setFieldValues(chessBoard,2,"d7","d5",null);
		setFieldValues(chessBoard,2,"c1","f4",null);
		setFieldValues(chessBoard,2,"g7","g5",null);
		setFieldValues(chessBoard,2,"d1","d2",null);
		setFieldValues(chessBoard,2,"b8","c6",null);
		setFieldValues(chessBoard,2,"h2","h4",null);
		
		String pieceLoc = "d1";
		Class pieceClass = Class.forName("OverridenQueen");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		
		//legal moves according to the piece on the board
		chessPiece = chessBoard.getPiece(pieceLoc);
		ArrayList<String> returnPossibleMoves = chessPiece.legalMoves();
		
		//oracle master moves according to the overriden piece
		chessPiece2 = (ChessPiece)pieceConstructor.newInstance(chessBoard, chessPiece.getColor());
		chessPiece2.setRow(chessPiece.getRow());
		chessPiece2.setColumn(chessPiece.getColumn());
		ArrayList<String> returnPossibleMasterMoves = chessPiece2.legalMoves();
		
		Assert.assertTrue(returnPossibleMasterMoves.containsAll(returnPossibleMoves) 
					&& returnPossibleMoves.containsAll(returnPossibleMasterMoves));
	}
	@Test
	public void king_legalMoves() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		chessBoard = new ChessBoard();
		setFieldValues(chessBoard,1,"","",null);
		setFieldValues(chessBoard,2,"d2","d4",null);
		setFieldValues(chessBoard,2,"d7","d5",null);
		setFieldValues(chessBoard,2,"c1","f4",null);
		setFieldValues(chessBoard,2,"g7","g5",null);
		setFieldValues(chessBoard,2,"e1","b4",null);
		setFieldValues(chessBoard,2,"b8","c6",null);
		setFieldValues(chessBoard,2,"h2","h4",null);
		setFieldValues(chessBoard,2,"g5","h4",null);
		setFieldValues(chessBoard,2,"d1","d2",null);
		
		String pieceLoc = "e1";
		Class pieceClass = Class.forName("OverridenKing");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		
		//legal moves according to the piece on the board
		chessPiece = chessBoard.getPiece(pieceLoc);
		ArrayList<String> returnPossibleMoves = chessPiece.legalMoves();
		
		//oracle master moves according to the overriden piece
		chessPiece2 = (ChessPiece)pieceConstructor.newInstance(chessBoard, chessPiece.getColor());
		chessPiece2.setRow(chessPiece.getRow());
		chessPiece2.setColumn(chessPiece.getColumn());
		ArrayList<String> returnPossibleMasterMoves = chessPiece2.legalMoves();
		
		Assert.assertTrue(returnPossibleMasterMoves.containsAll(returnPossibleMoves) 
					&& returnPossibleMoves.containsAll(returnPossibleMasterMoves));
	}
	@Test
	public void rook_legalMoves() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		chessBoard = new ChessBoard();
		setFieldValues(chessBoard,1,"","",null);
		setFieldValues(chessBoard,2,"d2","d4",null);
		setFieldValues(chessBoard,2,"d7","d5",null);
		setFieldValues(chessBoard,2,"c1","f4",null);
		setFieldValues(chessBoard,2,"g7","g5",null);
		setFieldValues(chessBoard,2,"e1","b4",null);
		setFieldValues(chessBoard,2,"b8","c6",null);
		setFieldValues(chessBoard,2,"h2","h4",null);
		setFieldValues(chessBoard,2,"g5","h4",null);
		setFieldValues(chessBoard,2,"h1","h3",null);
		
		String pieceLoc = "h3";
		Class pieceClass = Class.forName("OverridenRook");
		ChessPiece.Color col = ChessPiece.Color.BLACK;
		Constructor pieceConstructor = pieceClass.getConstructor(ChessBoard.class, ChessPiece.Color.class);
		
		//legal moves according to the piece on the board
		chessPiece = chessBoard.getPiece(pieceLoc);
		ArrayList<String> returnPossibleMoves = chessPiece.legalMoves();
		
		//oracle master moves according to the overriden piece
		chessPiece2 = (ChessPiece)pieceConstructor.newInstance(chessBoard, chessPiece.getColor());
		chessPiece2.setRow(chessPiece.getRow());
		chessPiece2.setColumn(chessPiece.getColumn());
		ArrayList<String> returnPossibleMasterMoves = chessPiece2.legalMoves();
		
		Assert.assertTrue(returnPossibleMasterMoves.containsAll(returnPossibleMoves) 
					&& returnPossibleMoves.containsAll(returnPossibleMasterMoves));
	}
	
	@Test
	public void chessBoard_state(){
		chessBoard=new ChessBoard();
		//initialize
		setFieldValues(chessBoard,1,"","",null);
		//move
		setFieldValues(chessBoard,2,"d2","d4",null);
		setFieldValues(chessBoard,2,"d7", "d5",null);
		setFieldValues(chessBoard,2,"c1", "f4",null);
		setFieldValues(chessBoard,2,"e1", "b4",null);
		setFieldValues(chessBoard,2,"b8", "c6",null);
		setFieldValues(chessBoard,2,"h2", "h4",null);
		setFieldValues(chessBoard,2,"g5", "h4",null);
		setFieldValues(chessBoard,2,"h1", "h3",null);
		
		
		chessBoard2 = new ChessBoard();
		chessBoard2.initialize();
		chessBoard2.move("d2", "d4");
		chessBoard2.move("d7", "d5");
		chessBoard2.move("c1", "f4");
		chessBoard2.move("e1", "b4");
		chessBoard2.move("b8", "c6");
		chessBoard2.move("h2", "h4");
		chessBoard2.move("g5", "h4");
		chessBoard2.move("h1", "h3");
		
		Assert.assertTrue(overridenToString(chessBoard).equals(overridenToString(chessBoard2)));
	}
	
	//chesspiece set/get row/column?
	
	private boolean fieldCheck(Class type, String fieldName, Class fieldType) {
		try {
			Field field = type.getDeclaredField(fieldName);
			if (!field.getType().equals(fieldType)) {
				return false;
			}

		} catch (NoSuchFieldException e) {
			return false;
		}
		return true;
	}
	private boolean checkFieldValue (Object object, String fieldName, int characteristic){
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			if(characteristic==1) {
				ChessPiece[][] chessPiece=(ChessPiece[][])(field.get(object));
				return (chessPiece.length==8 && chessPiece[0].length==8);
			}
			return false;
		} catch (NoSuchFieldException|IllegalAccessException e) {
			return false;
		}
		
	}
	private void setFieldValues(Object object, int characteristic, String fromPosition, String toPosition, ChessPiece piece) {
			try {
				
				ChessBoard obj=(ChessBoard)object;
				Field board = object.getClass().getDeclaredField("board");
				board.setAccessible(true);
				//initialize
				if(characteristic==1){

					board.set(object, overridenInitialize(obj));	
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
	private boolean checkPiece(ChessPiece piece,String position,ChessBoard testBoard) {
		ChessPiece returnedPiece = testBoard.getPiece(position);
		return (piece.getClass().getSuperclass().equals(returnedPiece.getClass() ) || piece.getClass().equals( returnedPiece.getClass()))
				&& piece.toString().equals(returnedPiece.toString())
				&& piece.getPosition().equals(returnedPiece.getPosition());
	}		
	private ChessPiece[][] overridenInitialize(ChessBoard object){
		ChessPiece[][] board=new ChessPiece[8][8];
		
		// initializes the board to an 8X8 array with all empty squares. An empty square is null.

				// 8 white pawns
				Pawn[] wpawns = new Pawn[8];
				for(int i=0; i<8; i++) {
					wpawns[i] = new Pawn(object, ChessPiece.Color.WHITE);
					board[1][i] = wpawns[i];
					wpawns[i].setRow(1);
					wpawns[i].setColumn(i);
				}

				// 8 black pawns
				Pawn[] bpawns = new Pawn[8];
				for(int i=0; i<8; i++) {
					bpawns[i] = new Pawn(object, ChessPiece.Color.BLACK);
					board[6][i] = bpawns[i];
					bpawns[i].setRow(6);
					bpawns[i].setColumn(i);
				}

				// 2 white rooks
				Rook[] wrooks = new Rook[2];
				for(int i=0; i<2; i++) {
					wrooks[i] = new Rook(object, ChessPiece.Color.WHITE);
				}
				board[0][0] = wrooks[0];
				board[0][7] = wrooks[1];
				
				wrooks[0].setPosition("a1");
				wrooks[1].setPosition("h1");

				// 2 black rooks
				Rook[] brooks = new Rook[2];
				for(int i=0; i<2; i++) {
					brooks[i] = new Rook(object, ChessPiece.Color.BLACK);
				}
				board[7][0] = brooks[0];
				board[7][7] = brooks[1];
				brooks[0].setPosition("a8");
				brooks[1].setPosition("h8");

				// 2 white knights
				Knight[] wknights = new Knight[2];
				for(int i=0; i<2; i++) {
					wknights[i] = new Knight(object, ChessPiece.Color.WHITE);
				}
				board[0][1] = wknights[0];
				board[0][6] = wknights[1];
				
				wknights[0].setPosition("b1");
				wknights[1].setPosition("g1");

				// 2 black knights
				Knight[] bknights = new Knight[2];
				for(int i=0; i<2; i++) {
					bknights[i] = new Knight(object, ChessPiece.Color.BLACK);
				}
				board[7][1] = bknights[0];
				board[7][6] = bknights[1];
				
				bknights[0].setPosition("b8");
				bknights[1].setPosition("g8");
				

				// 2 white bishops
				Bishop[] wbishops = new Bishop[2];
				for(int i=0; i<2; i++) {
					wbishops[i] = new Bishop(object, ChessPiece.Color.WHITE);
				}
				board[0][2] = wbishops[0];
				board[0][5] = wbishops[1];
				
				wbishops[0].setPosition("c1");
				wbishops[1].setPosition("f1");

				// 2 black bishops
				Bishop[] bbishops = new Bishop[2];
				for(int i=0; i<2; i++) {
					bbishops[i] = new Bishop(object, ChessPiece.Color.BLACK);
				}
				board[7][2] = bbishops[0];
				board[7][5] = bbishops[1];
				
				bbishops[0].setPosition("c8");
				bbishops[1].setPosition("f8");

				// White and black Queen
				
				Queen wqueen = new Queen(object, ChessPiece.Color.WHITE);
				Queen bqueen = new Queen(object, ChessPiece.Color.BLACK);
				
				board[0][3] = wqueen;
				board[7][3] = bqueen;
				
				wqueen.setPosition("d1");
				bqueen.setPosition("d8");
				

				// White and black King
				
				King wking = new King(object, ChessPiece.Color.WHITE);;
				King bking = new King(object, ChessPiece.Color.BLACK);
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
}

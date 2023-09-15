package sed.work.chessfx;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    List<List<StackPane>> boardCells = new ArrayList();
    Map<String, ImageView> chessPieces = new HashMap();
    Image chessPiecesImage =  new Image(getClass().getResource("images/chess_pieces_two.png").toExternalForm(), 0, 100, true, false);
        
    @Override
    public void start(Stage stage) {        
        StackPane root = new StackPane();
        var scene = new Scene(root, 800, 800);
        URL cssURL = getClass().getResource("css/board_colors.css");
        scene.getStylesheets().add(cssURL.toExternalForm());
        root.getChildren().add(createChessBoard(boardCells));       
        
        createChessPieces();       
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public void createChessPieces(){
        ImageView whiteRookOne = new ImageView(chessPiecesImage);
        whiteRookOne.setViewport(new Rectangle2D(0, 0, 36, 46));
        whiteRookOne.setUserData("white-rook-one");
        setOnDragDetected(whiteRookOne);
        setOnDragDone(whiteRookOne);
        chessPieces.put(whiteRookOne.getUserData().toString(), whiteRookOne);
        boardCells.get(0).get(7).getChildren().add(whiteRookOne);
        
        ImageView whiteKnightOne = new ImageView(chessPiecesImage);
        whiteKnightOne.setViewport(new Rectangle2D(43, 0, 48, 50));
        whiteKnightOne.setUserData("white-knight-one");
        setOnDragDetected(whiteKnightOne);
        setOnDragDone(whiteKnightOne);
        chessPieces.put(whiteKnightOne.getUserData().toString(), whiteKnightOne);
        boardCells.get(1).get(7).getChildren().add(whiteKnightOne);
        
        ImageView whiteBishopOne = new ImageView(chessPiecesImage);
        whiteBishopOne.setViewport(new Rectangle2D(92, 0, 48, 50));
        whiteBishopOne.setUserData("white-Bishop-one");
        setOnDragDetected(whiteBishopOne);
        setOnDragDone(whiteBishopOne);
        chessPieces.put(whiteBishopOne.getUserData().toString(), whiteBishopOne);
        boardCells.get(2).get(7).getChildren().add(whiteBishopOne);
        
        ImageView whiteQueen = new ImageView(chessPiecesImage);
        whiteQueen.setViewport(new Rectangle2D(188, 0, 48, 50));
        whiteQueen.setUserData("white-queen");
        setOnDragDetected(whiteQueen);
        setOnDragDone(whiteQueen);
        chessPieces.put(whiteQueen.getUserData().toString(), whiteQueen);
        boardCells.get(3).get(7).getChildren().add(whiteQueen);
        
        ImageView whiteKing = new ImageView(chessPiecesImage);
        whiteKing.setViewport(new Rectangle2D(140, 0, 48, 50));
        whiteKing.setUserData("white-king");
        setOnDragDetected(whiteKing);
        setOnDragDone(whiteKing);
        chessPieces.put(whiteKing.getUserData().toString(), whiteKing);
        boardCells.get(4).get(7).getChildren().add(whiteKing);        
        
        ImageView whiteBishopTwo = new ImageView(chessPiecesImage);
        whiteBishopTwo.setViewport(new Rectangle2D(92, 0, 48, 50));
        whiteBishopTwo.setUserData("white-bishop-two");
        setOnDragDetected(whiteBishopTwo);
        setOnDragDone(whiteBishopTwo);
        chessPieces.put(whiteBishopTwo.getUserData().toString(), whiteBishopTwo);
        boardCells.get(5).get(7).getChildren().add(whiteBishopTwo);
        
        ImageView whiteKnightTwo = new ImageView(chessPiecesImage);
        whiteKnightTwo.setViewport(new Rectangle2D(239, 0, 48, 50));
        whiteKnightTwo.setUserData("white-knight-two");
        setOnDragDetected(whiteKnightTwo);
        setOnDragDone(whiteKnightTwo);
        chessPieces.put(whiteKnightTwo.getUserData().toString(), whiteKnightTwo);
        boardCells.get(6).get(7).getChildren().add(whiteKnightTwo);
        
        ImageView whiteRookTwo = new ImageView(chessPiecesImage);
        whiteRookTwo.setViewport(new Rectangle2D(0, 0, 36, 46));
        whiteRookTwo.setUserData("white-rook-two");
        setOnDragDetected(whiteRookTwo);
        setOnDragDone(whiteRookTwo);
        chessPieces.put(whiteRookTwo.getUserData().toString(), whiteRookTwo);
        boardCells.get(7).get(7).getChildren().add(whiteRookTwo);
        
        for(int i = 0; i < 8; i++){
            ImageView whitePawn = new ImageView(chessPiecesImage);
            whitePawn.setViewport(new Rectangle2D(286, 0, 48, 50));
            whitePawn.setUserData("white-pawn-" + i);
            setOnDragDetected(whitePawn);
            setOnDragDone(whitePawn);
            chessPieces.put(whitePawn.getUserData().toString(), whitePawn);
            boardCells.get(i).get(6).getChildren().add(whitePawn);
        }
        
        
        
        ImageView blackRookOne = new ImageView(chessPiecesImage);
        blackRookOne.setViewport(new Rectangle2D(0, 55, 36, 46));
        blackRookOne.setUserData("black-rook-one");
        setOnDragDetected(blackRookOne);
        setOnDragDone(blackRookOne);
        chessPieces.put(blackRookOne.getUserData().toString(), blackRookOne);
        boardCells.get(0).get(0).getChildren().add(blackRookOne);
        
        ImageView blackKnightOne = new ImageView(chessPiecesImage);
        blackKnightOne.setViewport(new Rectangle2D(43, 55, 48, 50));
        blackKnightOne.setUserData("black-knight-one");
        setOnDragDetected(blackKnightOne);
        setOnDragDone(blackKnightOne);
        chessPieces.put(blackKnightOne.getUserData().toString(), blackKnightOne);
        boardCells.get(1).get(0).getChildren().add(blackKnightOne);
        
        ImageView blackBishopOne = new ImageView(chessPiecesImage);
        blackBishopOne.setViewport(new Rectangle2D(92, 55, 48, 50));
        blackBishopOne.setUserData("black-bishop-one");
        setOnDragDetected(blackBishopOne);
        setOnDragDone(blackBishopOne);
        chessPieces.put(blackBishopOne.getUserData().toString(), blackBishopOne);
        boardCells.get(2).get(0).getChildren().add(blackBishopOne);
        
        ImageView blackQueen = new ImageView(chessPiecesImage);
        blackQueen.setViewport(new Rectangle2D(188, 55, 48, 50));
        blackQueen.setUserData("black-queen");
        setOnDragDetected(blackQueen);
        setOnDragDone(blackQueen);
        chessPieces.put(blackQueen.getUserData().toString(), blackQueen);
        boardCells.get(3).get(0).getChildren().add(blackQueen);
        
        ImageView blackKing = new ImageView(chessPiecesImage);
        blackKing.setViewport(new Rectangle2D(140, 55, 48, 50));
        blackKing.setUserData("black-king");
        setOnDragDetected(blackKing);
        setOnDragDone(blackKing);
        chessPieces.put(blackKing.getUserData().toString(), blackKing);
        boardCells.get(4).get(0).getChildren().add(blackKing);        
        
        ImageView blackBishopTwo = new ImageView(chessPiecesImage);
        blackBishopTwo.setViewport(new Rectangle2D(92, 55, 48, 50));
        blackBishopTwo.setUserData("black-bishop-two");
        setOnDragDetected(blackBishopTwo);
        setOnDragDone(blackBishopTwo);
        chessPieces.put(blackBishopTwo.getUserData().toString(), blackBishopTwo);
        boardCells.get(5).get(0).getChildren().add(blackBishopTwo);
        
        ImageView blackKnightTwo = new ImageView(chessPiecesImage);
        blackKnightTwo.setViewport(new Rectangle2D(239, 55, 48, 50));
        blackKnightTwo.setUserData("black-knight-two");
        setOnDragDetected(blackKnightTwo);
        setOnDragDone(blackKnightTwo);
        chessPieces.put(blackKnightTwo.getUserData().toString(), blackKnightTwo);
        boardCells.get(6).get(0).getChildren().add(blackKnightTwo);
        
        ImageView blackRookTwo = new ImageView(chessPiecesImage);
        blackRookTwo.setViewport(new Rectangle2D(0, 55, 36, 46));
        blackRookTwo.setUserData("black-rook-two");
        setOnDragDetected(blackRookTwo);
        setOnDragDone(blackRookTwo);
        chessPieces.put(blackRookTwo.getUserData().toString(), blackRookTwo);
        boardCells.get(7).get(0).getChildren().add(blackRookTwo);
        
        for(int i = 0; i < 8; i++){
            ImageView blackPawn = new ImageView(chessPiecesImage);
            blackPawn.setViewport(new Rectangle2D(290, 55, 48, 50));
            blackPawn.setUserData("black-pawn-" + i);
            setOnDragDetected(blackPawn);
            setOnDragDone(blackPawn);
            chessPieces.put(blackPawn.getUserData().toString(), blackPawn);
            boardCells.get(i).get(1).getChildren().add(blackPawn);
        }
    }
    
    public StackPane createChessBoard(List<List<StackPane>> boardCells){
        GridPane board = new GridPane();
        board.getStyleClass().add("gridpane-background-color");   
        board.setVgap(3);
        board.setHgap(3);
        board.setStyle("-fx-background-color: black;");
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(12.5);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(12.5);
        for(int i = 0; i < 8; i++){
            board.getColumnConstraints().add(columnConstraints);
            board.getRowConstraints().add(rowConstraints);
        }
        
        for(int i = 0; i < 8; i++){
            List<StackPane> row = new ArrayList();
            
            for(int z = 0; z < 8; z++){
                StackPane cell = new StackPane();
                setOnDragEntered(cell);
                setOnDragExited(cell);
                setOnDragOver(cell);
                setOnDragDropped(cell);
                
                if(i % 2 == 1 && z % 2 == 1){
                    cell.setId("cell-white-color");
                }
                else if(i % 2 == 1 && z % 2 == 0){
                    cell.setId("cell-brown-color");
                }
                else if(i % 2 == 0 && z % 2 == 1){
                    cell.setId("cell-brown-color");
                }
                else{
                    cell.setId("cell-white-color");
                }
                
                row.add(cell);     
                board.add(cell, i, z);
            }
            
            boardCells.add(row);
            
        }
        
        return new StackPane(board);
    }
    
    
    //source event handlers
    public void setOnDragDetected(ImageView source)
    {
        source.setOnDragDetected((MouseEvent event) -> {
            /* drag was detected, start drag-and-drop gesture*/
            System.out.println("onDragDetected");
            final ImageView preview = new ImageView(source.snapshot(null, null));
            
            /* allow any transfer mode */
            Dragboard db = source.startDragAndDrop(TransferMode.ANY);

            /* put a string on dragboard */
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getUserData().toString());//ToDo
            db.setContent(content);
            db.setDragView(preview.getImage(), 20, 20);
            
            source.setVisible(false);
            event.consume();
        });
    }

    public void setOnDragDone(ImageView source)
    {
        source.setOnDragDone((DragEvent event) -> {
            /* the drag-and-drop gesture ended */
            System.out.println("onDragDone");
            /* if the data was successfully moved, clear it */
//            if (event.getTransferMode() == TransferMode.MOVE) {
//                source.setText("");
//            }

            event.consume();
        });
    }

    
    
    //target event handlers
    public void setOnDragOver(StackPane target)
    {
        target.setOnDragOver((DragEvent event) -> {
            /* data is dragged over the target */
            System.out.println("onDragOver");

            /* accept it only if it is  not dragged from the same node
            * and if it has a string data */
            if (event.getGestureSource() != target
                    && event.getDragboard().hasString()) {
                /* allow for both copying and moving, whatever user chooses */
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }

            event.consume();
        });
    }

    public void setOnDragEntered(StackPane target)
    {
        target.setOnDragEntered((DragEvent event) -> {
            /* the drag-and-drop gesture entered the target */
            System.out.println("onDragEntered");
            /* show to the user that it is an actual gesture target */
            if (event.getGestureSource() != target
                    && event.getDragboard().hasString()) {
                target.setStyle("-fx-background-color: green;");
            }

            event.consume();
        });
    }

    public void setOnDragExited(StackPane target)
    {
        target.setOnDragExited((DragEvent event) -> {
            /* mouse moved away, remove the graphical cues */
            target.setStyle(null);

            event.consume();
        });
    }

    public void setOnDragDropped(StackPane target)
    {
        target.setOnDragDropped((DragEvent event) -> {
            /* data dropped */
            System.out.println("onDragDropped");
            /* if there is a string data on dragboard, read it and use it */
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                //target.setText(db.getString());               
                target.getChildren().clear();
                ImageView droppedImageView = chessPieces.get(db.getString());
                
                target.getChildren().add(droppedImageView);
                droppedImageView.setVisible(true);
                success = true;
            }
            /* let the source know whether the string was successfully
            * transferred and used */
            event.setDropCompleted(success);

            event.consume();
        });
    }    
}